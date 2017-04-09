package main.model

class OrderItem() {
    lateinit var id: Integer
    lateinit var username: String
    lateinit var selection: Integer
    //TODO move this fields to another entity
    var isFoodShopper: Boolean? = null
    var isMoneyGatherer: Boolean? = null
    var isUnpaired: Boolean? = null
    var userURL: String? = null

    constructor(
            id: Integer,
            username: String,
            selection: Integer,
            isFoodShopper: Boolean? = null,
            isMoneyGatherer: Boolean? = null,
            isUnpaired: Boolean? = null,
            userURL: String? = null): this() {
        this.id = id
        this.username = username
        this.selection = selection
        this.isFoodShopper = isFoodShopper
        this.isMoneyGatherer = isMoneyGatherer
        this.userURL = userURL
        this.isUnpaired = isUnpaired;
    }
}
