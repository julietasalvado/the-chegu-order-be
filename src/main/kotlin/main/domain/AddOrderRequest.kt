package main.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import main.model.OrderEntity
import java.util.*

/**
 * DTO that represents a request for creating a new order
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class AddOrderRequest(
        var place: String,
        var date: Date)

/**
 * Translates from [AddOrderRequest] to [OrderEntity].
 */
fun AddOrderRequest.toOrderEntity(): OrderEntity = OrderEntity(
        date = this.date,
        place = this.place
)
