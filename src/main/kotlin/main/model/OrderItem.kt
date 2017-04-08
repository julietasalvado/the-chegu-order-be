package main.model

import jdk.nashorn.internal.codegen.types.BooleanType

class OrderItem() {
    lateinit var username: String
    lateinit var dish: Integer
    //TODO move this fields to another entity
    var isFoodShopper: Boolean? = null
    var isMoneyGatherer: Boolean? = null
    var userURL: String? = null

    constructor(
            username: String,
            dish: Integer,
            isFoodShopper: Boolean? = null,
            isMoneyGatherer: Boolean? = null,
            userURL: String? = null): this() {
        this.username = username
        this.dish = dish
        this.isFoodShopper = isFoodShopper
        this.isMoneyGatherer = isMoneyGatherer
        this.username = username
        this.userURL = userURL
    }
}
