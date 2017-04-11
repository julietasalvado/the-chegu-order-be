package main.database

import main.model.OrderEntity
import org.springframework.data.mongodb.repository.MongoRepository

interface OrderRepository : MongoRepository<OrderEntity, String> {

}
