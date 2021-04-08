package eu.glutfree.glutfree.model.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name="foods")
public class FoodEntity extends BaseEntity{

    private String name;
    private String brand;
    private String urlToPic;
    private boolean nimaTested;
    private boolean markedAsGF = false;
    private boolean withoutLactose = false;
//    private Set<StoreEntity> storeEntities;
    private StoreEntity store;


    public FoodEntity() {
    }
    @Column(nullable = false)
    @Size(min = 2, max = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    public StoreEntity getStore() {
        return store;
    }

    public void setStore(StoreEntity store) {
        this.store = store;
    }

    //    @ManyToMany
//    @JoinTable(name = "foods_stores" , joinColumns = @JoinColumn(name = "food_id"), inverseJoinColumns = @JoinColumn(name = "store_id"))
//    public Set<StoreEntity> getStores() {
//        return storeEntities;
//    }
//
//    public void setStores(Set<StoreEntity> storeEntities) {
//        this.storeEntities = storeEntities;
//    }

    @Column(name = "url_top_pic")
    public String getUrlToPic() {
        return urlToPic;
    }

    public void setUrlToPic(String urlToPic) {
        this.urlToPic = urlToPic;
    }
    @Column(nullable = false)
    @Size(min = 2, max = 50)
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

//
//    public String getShortDescription() {
//        return shortDescription;
//    }
//
//    public void setShortDescription(String shortDescription) {
//        this.shortDescription = shortDescription;
//    }


    public boolean isNimaTested() {
        return nimaTested;
    }

    public void setNimaTested(boolean nimaTested) {
        this.nimaTested = nimaTested;
    }

    public boolean isMarkedAsGF() {
        return markedAsGF;
    }

    public void setMarkedAsGF(boolean markedAsGF) {
        this.markedAsGF = markedAsGF;
    }

    public boolean isWithoutLactose() {
        return withoutLactose;
    }

    public void setWithoutLactose(boolean withoutLactose) {
        this.withoutLactose = withoutLactose;
    }
}
