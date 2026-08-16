package eu.glutfree.glutfree.model.service;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

public class FoodEditServiceModel {

    private String name;
    private String brand;
    private String copyright;
    private MultipartFile image;
    private MultipartFile labelImage;
    private LocalDate pictureDate;
    private boolean nimaTested;
    private boolean markedAsGF;
    private boolean withoutLactose;
    private String store;
    private String details;
    private boolean glutenTox;
    private String category;

    public FoodEditServiceModel() {
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

    public MultipartFile getLabelImage() {
        return labelImage;
    }

    public void setLabelImage(MultipartFile labelImage) {
        this.labelImage = labelImage;
    }

    public LocalDate getPictureDate() {
        return pictureDate;
    }

    public void setPictureDate(LocalDate pictureDate) {
        this.pictureDate = pictureDate;
    }

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

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public boolean isGlutenTox() {
        return glutenTox;
    }

    public void setGlutenTox(boolean glutenTox) {
        this.glutenTox = glutenTox;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
