package com.leandro.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Entity class representing the user table in the database.
 * <p>
 * This class is used to map the users table in the database.
 * It contains the user's ID, username, password, and email.
 * </p>
 *
 * @author Leandro Burgos
 * @version 0.1
 */
@Data
@Entity
@Table(name = "users")
public class UserEntity implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String username;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false, unique = true)
  private String email;

  /**
   * Returns the username used to authenticate the user.
   * <p>
   * Currently, no roles are implemented, so this method returns null.
   * </p>
   *
   * @return null, as roles are not implements yet.
   */
  @Override()
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null; // No roles for now
  }

  @Override()
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override()
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override()
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override()
  public boolean isEnabled() {
    return true;
  }

}
