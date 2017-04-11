package main.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.PersistenceConstructor
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "orders")
data class OrderEntity @PersistenceConstructor
constructor(@Id val id: ObjectId? = null, val place: String, var date: Date,
            val foodShopperName: String? = null, val moneyGathererName: String? = null, val closed: Boolean = false)