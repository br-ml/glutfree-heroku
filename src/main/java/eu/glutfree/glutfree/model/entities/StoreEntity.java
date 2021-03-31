package eu.glutfree.glutfree.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name="stores")
public class StoreEntity extends BaseEntity{

    private String name;
    private String storeWebSiteUrl;
    private String logoUrl;
//    private Set<FoodEntity> foodEntities;


    public StoreEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @ManyToMany(mappedBy = "stores")
//    public Set<FoodEntity> getFoods() {
//        return foodEntities;
//    }
//
//    public void setFoods(Set<FoodEntity> foodEntities) {
//        this.foodEntities = foodEntities;
//    }
    @Column(length = 512)
    public String getStoreWebSiteUrl() {
        return storeWebSiteUrl;
    }

    public void setStoreWebSiteUrl(String storeWebSiteUrl) {
        this.storeWebSiteUrl = storeWebSiteUrl;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

}
