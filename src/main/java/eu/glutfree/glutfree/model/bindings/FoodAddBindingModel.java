package eu.glutfree.glutfree.model.bindings;

import eu.glutfree.glutfree.model.entities.StoreEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

public class FoodAddBindingModel {

    private String name;
    private String brand;
    private MultipartFile image;
    private boolean nimaTested;
    private boolean markedAsGF;
    private boolean withoutLactose;
    private String store;

    public FoodAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    //
//    public String getUrlToPic() {
//        return urlToPic;
//    }
//
//    public void setUrlToPic(String urlToPic) {
//        this.urlToPic = urlToPic;
//    }

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

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }
}
