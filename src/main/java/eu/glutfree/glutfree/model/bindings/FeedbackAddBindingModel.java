package eu.glutfree.glutfree.model.bindings;

import eu.glutfree.glutfree.model.entities.UserEntity;
import eu.glutfree.glutfree.model.entities.enums.TypeOfPlaceEnums;

public class FeedbackAddBindingModel {

    private String name;
    private int score;
    private String feedbackText;
    private String webSiteUrl;
    private String logoPicture;
    private TypeOfPlaceEnums typeOfPlace;

    public FeedbackAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }

    public String getWebSiteUrl() {
        return webSiteUrl;
    }

    public void setWebSiteUrl(String webSiteUrl) {
        this.webSiteUrl = webSiteUrl;
    }

    public String getLogoPicture() {
        return logoPicture;
    }

    public void setLogoPicture(String logoPicture) {
        this.logoPicture = logoPicture;
    }

    public TypeOfPlaceEnums getTypeOfPlace() {
        return typeOfPlace;
    }

    public void setTypeOfPlace(TypeOfPlaceEnums typeOfPlace) {
        this.typeOfPlace = typeOfPlace;
    }
}
