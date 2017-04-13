package main.controllers

import main.database.OrderItemRepository
import main.domain.AddItemOrderRequest
import main.domain.toOrderItemEntity
import main.misc.DuplicateItemException
import main.model.OrderItemEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * Controller for the items in the order.
 */
@RestController
class OrderItemController {

    @Autowired
    private lateinit var orderItemRepository: OrderItemRepository

    /**
     * Returns all items in the order. An empty array is returned when the order is empty
     */
    @CrossOrigin(origins = arrayOf("http://localhost:3000"))
    @RequestMapping("/api/v1/items", method = arrayOf(RequestMethod.GET))
    fun orderItems(): MutableList<OrderItemEntity>? = orderItemRepository.findAll()

    /**
     * Adds a new item into the order.
     * @throws DuplicateItemException if the item is already in the order
     */
    @CrossOrigin(origins = arrayOf("http://localhost:3000"))
    @PostMapping("/api/v1/items", consumes = arrayOf("application/json"), produces = arrayOf("application/json"))
    fun addOrderItem(@RequestBody orderItem: AddItemOrderRequest): OrderItemEntity {
        val toOrderItemEntity = orderItem.toOrderItemEntity()
        return if (orderItemRepository.insert(toOrderItemEntity) != null) toOrderItemEntity
        else throw DuplicateItemException()
    }

    /**
     * Remove an item from the order.
     */
    @CrossOrigin(origins = arrayOf("http://localhost:3000"))
    @DeleteMapping("/api/v1/items/{id}", produces = arrayOf("application/json"))
    fun removeOrderItem(@PathVariable("id") id: String) {
        orderItemRepository.delete(id)
    }
}
