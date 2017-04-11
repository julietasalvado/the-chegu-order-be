package main.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import main.model.OrderItemEntity

/**
 * DTO that represents a request for adding a new item to the order
 */
@JsonIgnoreProperties(ignoreUnknown = true)
data class AddItemOrderRequest(
        var username: String,
        var selection: Int,
        //TODO move these fields to another entity
        var isFoodShopper: Boolean,
        var isMoneyGatherer: Boolean,
        var isUnpaired: Boolean,
        var userURL: String)

/**
 * Translates from AddItemOrderRequest to OrderItemEntity
 */
fun AddItemOrderRequest.toOrderItemEntity(): OrderItemEntity = OrderItemEntity(
        /*username = */username,
        /*selection = */selection,
        /*foodShopper = */isFoodShopper,
        /*moneyGatherer = */isMoneyGatherer,
        /*unpaired = */isUnpaired,
        /*userURL = */userURL
)
