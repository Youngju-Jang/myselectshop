package com.sparta.myselectshop.security;
import com.sparta.myselectshop.entity.User;
import com.sparta.myselectshop.entity.UserRoleEnum;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class UserDetailsImpl implements UserDetails {
     
     //UserDetailsImpl 인증객체 생성에 사용
     //UserDetails userDetails = userDetailsService.loadUserByUsername(username);
     //Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
     
     private final User user; // 인증완료된 User 객체
     private final String username; // 인증완료된 User의 ID
     private final String password; // 인증완료된 User의 PWD
     
     //인증이 완료된 사용자 추가
     public UserDetailsImpl(User user, String username, String password) {
          this.user = user;
          this.username = username;
          this.password = password;
     }
     
     //  인증완료된 User 를 가져오는 Getter
     public User getUser() {
          return user;
     }
     
     //사용자의 권한 GrantedAuthority 로 추상화 및 반환
     @Override
     public Collection<? extends GrantedAuthority> getAuthorities() {
          UserRoleEnum role = user.getRole();
          String authority = role.getAuthority();
          
          SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(authority);
          Collection<GrantedAuthority> authorities = new ArrayList<>();
          authorities.add(simpleGrantedAuthority);
          
          return authorities;
     }
     
     // 사용자의 ID, PWD Getter
     
     @Override
     public String getUsername() {
          return this.username;
     }
     
     @Override
     public String getPassword() {
          return this.password;
     }
     
     @Override
     public boolean isAccountNonExpired() {
          return false;
     }
     
     @Override
     public boolean isAccountNonLocked() {
          return false;
     }
     
     @Override
     public boolean isCredentialsNonExpired() {
          return false;
     }
     
     @Override
     public boolean isEnabled() {
          return false;
     }
}