package eu.glutfree.glutfree.model.entities;

import eu.glutfree.glutfree.model.entities.enums.RegionEnums;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class UserEntity extends BaseEntity {


  private String username;
  private String password;
  public String email;
  private List<UserRoleEntity> roles = new ArrayList<>();
  private String firstName;
  private String secondName;
  private RegionEnums region;



  @Column(nullable = false)
  public String getUsername() {
    return username;
  }

  public UserEntity setUsername(String name) {
    this.username = name;
    return this;
  }
  @Column(nullable = false)
  public String getPassword() {
    return password;
  }

  public UserEntity setPassword(String password) {
    this.password = password;
    return this;
  }
  @ManyToMany(fetch = FetchType.EAGER)
  public List<UserRoleEntity> getRoles() {
    return roles;
  }

  public UserEntity setRoles(List<UserRoleEntity> roles) {
    this.roles = roles;
    return this;
  }


  public UserEntity addRole(UserRoleEntity roleEntity) {
    this.roles.add(roleEntity);
    return this;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
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
}
