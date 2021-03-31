package eu.glutfree.glutfree.model.entities;

import eu.glutfree.glutfree.model.entities.enums.TypeOfMealsEnums;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Table(name="receipts")
public class ReceiptEntity extends BaseEntity{

    private String name;
    private String description;
    private String productsList;
    private TypeOfMealsEnums typeOfMeal;
    private int duration;
    private String urlToPic;

    private UserEntity user;

    public ReceiptEntity() {
    }


    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public String getProductsList() {
        return productsList;
    }

    public void setProductsList(String productsList) {
        this.productsList = productsList;
    }
    @Enumerated
    public TypeOfMealsEnums getTypeOfMeal() {
        return typeOfMeal;
    }

    public void setTypeOfMeal(TypeOfMealsEnums typeOfMeal) {
        this.typeOfMeal = typeOfMeal;
    }

    public String getUrlToPic() {
        return urlToPic;
    }

    public void setUrlToPic(String urlToPic) {
        this.urlToPic = urlToPic;
    }
    @ManyToOne
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Column(nullable = false, columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


}
