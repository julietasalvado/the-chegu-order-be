package main.controllers

import main.database.OrderRepository
import main.domain.AddOrderRequest
import main.domain.toOrderEntity
import main.misc.NoContentException
import main.model.OrderEntity
import main.misc.addMinutes
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.*
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.*

@RestController
class OrderController {

    @Value("\${default.place}")
    lateinit var place: String

    @Value("\${default.time.minutes}")
    var minutes: Int = 0

    @Autowired
    private lateinit var orderRepository: OrderRepository

    @CrossOrigin(origins = arrayOf("http://localhost:3000"))
    @PostMapping("/api/v1/orders", consumes = arrayOf("application/json"), produces = arrayOf("application/json"))
    fun addOrder(@RequestBody request: AddOrderRequest) {
        orderRepository.save(request.toOrderEntity())
    }

    /**
     * Creates a default order.
     *
     * Default values are took from the yaml property file application.yaml
     */
    @CrossOrigin(origins = arrayOf("http://localhost:3000"))
    @PostMapping("/api/v1/orders/default", consumes = arrayOf("application/json"), produces = arrayOf("application/json"))
    fun addDefaultOrder(): OrderEntity? {
        return orderRepository.save(OrderEntity(place = place, date = today().addMinutes(minutes)))
    }

    /**
     * @throws NoContentException when none order is stored
     */
    @CrossOrigin(origins = arrayOf("http://localhost:3000"))
    @GetMapping("/api/v1/orders/last", produces = arrayOf("application/json"))
    fun getLastOrder(): OrderEntity {
        val list = orderRepository.findAll()?.toList()
        if (list == null || list.isEmpty()) throw NoContentException()
        else {
            return list.sortedBy { it.date }.last()
        }
    }

    //move somewhere else... companion in datautils? top level function?
    val today: () -> Date = {
        Date.from(Instant.now().truncatedTo(ChronoUnit.DAYS))
    }
}
