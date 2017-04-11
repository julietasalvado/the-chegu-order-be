package main.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * TODO translate this class to kotlin
 */
@Document(collection = "items")
public class OrderItemEntity {
    @Id
    private ObjectId id;

    private String username;

    private Integer selection;
    //TODO move these fields to another entity

    private Boolean isFoodShopper;

    private Boolean isMoneyGatherer;

    private Boolean isUnpaired;

    private String userURL;

    @PersistenceConstructor
    public OrderItemEntity(String username, Integer selection, Boolean isFoodShopper, Boolean isMoneyGatherer, Boolean isUnpaired,
                           String userURL) {
        super();
        this.username = username;
        this.selection = selection;
        this.isFoodShopper = isFoodShopper;
        this.isMoneyGatherer = isMoneyGatherer;
        this.isUnpaired = isUnpaired;
        this.userURL = userURL;
    }

    public String getId() {
        return id.toString();
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getSelection() {
        return selection;
    }

    public void setSelection(Integer selection) {
        this.selection = selection;
    }

    public Boolean getFoodShopper() {
        return isFoodShopper;
    }

    public void setFoodShopper(Boolean foodShopper) {
        isFoodShopper = foodShopper;
    }

    public Boolean getMoneyGatherer() {
        return isMoneyGatherer;
    }

    public void setMoneyGatherer(Boolean moneyGatherer) {
        isMoneyGatherer = moneyGatherer;
    }

    public Boolean getUnpaired() {
        return isUnpaired;
    }

    public void setUnpaired(Boolean unpaired) {
        isUnpaired = unpaired;
    }

    public String getUserURL() {
        return userURL;
    }

    public void setUserURL(String userURL) {
        this.userURL = userURL;
    }
}
