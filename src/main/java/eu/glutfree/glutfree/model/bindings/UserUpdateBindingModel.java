package eu.glutfree.glutfree.model.bindings;

import eu.glutfree.glutfree.model.entities.enums.RegionEnums;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

public class UserUpdateBindingModel {
    private String firstName;
    private String secondName;
    private RegionEnums region;
//    private Boolean isProfileUpdated;


    public UserUpdateBindingModel() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public RegionEnums getRegion() {
        return region;
    }

    public void setRegion(RegionEnums region) {
        this.region = region;
    }

//    public Boolean getProfileUpdated() {
//        return isProfileUpdated;
//    }
//
//    public void setProfileUpdated(Boolean profileUpdated) {
//        isProfileUpdated = profileUpdated;
//    }
}
