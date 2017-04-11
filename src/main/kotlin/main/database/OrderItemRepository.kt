package main.database

import main.model.OrderItemEntity
import org.springframework.data.mongodb.repository.MongoRepository

interface OrderItemRepository : MongoRepository<OrderItemEntity, String> {

    fun findByUsername(username: String): OrderItemEntity
}
