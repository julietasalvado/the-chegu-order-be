package main.database

import main.model.OrderItem
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class OrderItemDatabase {

    // All of our OrderItems will live here
    private val orderItems = mutableListOf<OrderItem>()

    @PostConstruct
    private fun init() {

        // Fill our "database"
        orderItems.add(OrderItem(
                "Juanito Arcoiris",
                Integer(1),
                false,
                false,
                userURL = "https://d.gr-assets.com/books/1448127430l/7235533.jpg"))

        orderItems.add(OrderItem(
                "Dalma y Gianina",
                Integer(1),
                false,
                false,
                userURL = "https://d.gr-assets.com/books/1327656754l/11.jpg"))

        orderItems.add(OrderItem(
                "Marilyn Soldan",
                Integer(1),
                false,
                false,
                userURL = "https://d.gr-assets.com/books/1437254833l/68428.jpg"))
    }

    /**
     * Returns a list of all order items
     */
    fun getAllOrderItems() = orderItems

    /**
     * Adds the given orderItem only if the same username doesn't already exist.
     * @param orderItem the element to add
     * @return true - if the order item was successfully add
     *         false - otherwise
     */
    fun addOrderItem(orderItem: OrderItem) : Boolean {
        orderItems.firstOrNull() {it.username == orderItem.username} ?.let { return false }
        orderItems.add(orderItem)
        return true
        }
}
