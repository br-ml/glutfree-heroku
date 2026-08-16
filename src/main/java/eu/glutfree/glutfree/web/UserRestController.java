package eu.glutfree.glutfree.web;

import eu.glutfree.glutfree.model.bindings.LoginRequestModel;
import eu.glutfree.glutfree.model.entities.UserEntity;
import eu.glutfree.glutfree.model.service.UserRegistrationServiceModel;
import eu.glutfree.glutfree.model.view.UserViewModel;
import eu.glutfree.glutfree.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/users")
@RestController
public class UserRestController {

    private final UserService userService;
    private final ModelMapper modelMapper;
    private final AuthenticationManager authenticationManager;

    public UserRestController(UserService userService, ModelMapper modelMapper,
                              AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestModel loginRequest,
                                   HttpServletRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(), loginRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            request.getSession(true).setAttribute(
                    HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                    SecurityContextHolder.getContext());

            UserEntity user = userService.findUserByUsername(loginRequest.getUsername());
            UserViewModel viewModel = modelMapper.map(user, UserViewModel.class);
            viewModel.setRoles(user.getRoles().stream()
                    .map(r -> r.getRole().name())
                    .collect(Collectors.toList()));
            return ResponseEntity.ok(viewModel);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Invalid username or password"));
        }
    }

    @PostMapping("/api/register")
    public ResponseEntity<Void> register(@RequestBody UserRegistrationServiceModel model) {
        if (userService.userNameExists(model.getUsername())) {
            return ResponseEntity.badRequest().build();
        }
        userService.registerAndLoginUser(model);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api/me")
    public ResponseEntity<UserViewModel> me(Authentication authentication) {
        UserEntity user = userService.findUserByUsername(authentication.getName());
        UserViewModel viewModel = modelMapper.map(user, UserViewModel.class);
        viewModel.setRoles(user.getRoles().stream()
                .map(r -> r.getRole().name())
                .collect(Collectors.toList()));
        return ResponseEntity.ok(viewModel);
    }

    @PutMapping("/api/me")
    public ResponseEntity<Void> update(@RequestBody UserRegistrationServiceModel model,
                                       Authentication authentication) {
        UserEntity user = userService.findUserByUsername(authentication.getName());
        model.setId(user.getId());
        userService.updateUser(model);
        return ResponseEntity.ok().build();
    }
}
