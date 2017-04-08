package main.controllers

import main.database.OrderItemDatabase
import main.exceptions.DuplicateItemException
import main.model.OrderItem
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderItemController {

    // Our order item database
    @Autowired
    private lateinit var database: OrderItemDatabase

    @RequestMapping("", method = arrayOf(RequestMethod.GET))
    fun orderItems() = database.getAllOrderItems()

    @RequestMapping("", method = arrayOf(RequestMethod.POST))
    fun addOrderItem(@RequestBody orderItem: OrderItem) =
            if (database.addOrderItem(orderItem)) orderItem
            else throw DuplicateItemException()
}
