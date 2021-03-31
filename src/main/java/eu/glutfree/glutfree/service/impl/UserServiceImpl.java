package eu.glutfree.glutfree.service.impl;

import eu.glutfree.glutfree.model.entities.UserEntity;
import eu.glutfree.glutfree.model.entities.UserRoleEntity;
import eu.glutfree.glutfree.model.entities.enums.UserRole;
import eu.glutfree.glutfree.model.service.UserRegistrationServiceModel;
import eu.glutfree.glutfree.model.service.UserUpdateServiceModel;
import eu.glutfree.glutfree.repository.UserRepository;
import eu.glutfree.glutfree.repository.UserRoleRepository;
import eu.glutfree.glutfree.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final GlutfreeDBUserService glutfreeDBUserService;


    public UserServiceImpl(UserRoleRepository userRoleRepository,
                           UserRepository userRepository,
                           PasswordEncoder passwordEncoder, ModelMapper modelMapper, GlutfreeDBUserService glutfreeDBUserService) {
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.glutfreeDBUserService = glutfreeDBUserService;
    }


    @Override
    public void seedUsers() {

        if (userRepository.count() == 0) {

            UserRoleEntity adminRole = new UserRoleEntity().setRole(UserRole.ADMIN);
            UserRoleEntity userRole = new UserRoleEntity().setRole(UserRole.USER);

            userRoleRepository.saveAll(List.of(adminRole, userRole));

            UserEntity admin = new UserEntity().setUsername("admin").setPassword(passwordEncoder.encode("admin"));
            UserEntity user = new UserEntity().setUsername("user").setPassword(passwordEncoder.encode("user"));
            admin.setRoles(List.of(adminRole, userRole));
            user.setRoles(List.of(userRole));

            userRepository.saveAll(List.of(admin, user));
        }
    }

    @Override
    public void registerAndLoginUser(UserRegistrationServiceModel serviceModel) {
        UserEntity newUser = modelMapper.map(serviceModel, UserEntity.class);
        newUser.setPassword(passwordEncoder.encode(serviceModel.getPassword()));

        UserRoleEntity userRole = userRoleRepository.
                findByRole(UserRole.USER).orElseThrow(
                () -> new IllegalStateException("USER role not found. Please seed the roles."));

        newUser.addRole(userRole);

        newUser = userRepository.save(newUser);

        UserDetails principal = glutfreeDBUserService.loadUserByUsername(newUser.getUsername());

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                principal,
                newUser.getPassword(),
                principal.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Override
    public boolean userNameExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    @Override
    public UserEntity findUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);//TODO
    }

    @Override
    public void updateUser(UserRegistrationServiceModel userRegistrationServiceModel) {
        UserEntity currentUser = userRepository.findById(userRegistrationServiceModel.getId()).orElseThrow(
                () -> new IllegalStateException("USER  not found."));

        currentUser.setRegion(userRegistrationServiceModel.getRegion());
        currentUser.setFirstName(userRegistrationServiceModel.getFirstName());
        currentUser.setSecondName(userRegistrationServiceModel.getSecondName());

        userRepository.saveAndFlush(currentUser);

    }

    @Override
    public UserEntity findById(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(IllegalArgumentException::new);

    }

    @Override
    public UserEntity findByName(String username) {
        return userRepository
                .findByUsername(username)
                .orElseThrow(IllegalArgumentException::new);


    }
}