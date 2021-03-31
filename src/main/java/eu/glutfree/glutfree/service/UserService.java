package eu.glutfree.glutfree.service;

import eu.glutfree.glutfree.model.entities.UserEntity;
import eu.glutfree.glutfree.model.service.UserRegistrationServiceModel;
import eu.glutfree.glutfree.model.service.UserUpdateServiceModel;

public interface UserService {

    void seedUsers();

    void registerAndLoginUser(UserRegistrationServiceModel serviceModel);

    boolean userNameExists(String username);


    UserEntity findUserByUsername(String name);

    void updateUser(UserRegistrationServiceModel userRegistrationServiceModel);

    UserEntity findById(Long id);

    UserEntity findByName(String username);

}