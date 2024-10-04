package com.smartmes.maintenance.config.auth.firebase;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Getter
public class FirebaseUserDetails implements UserDetails {

    private final String uid;
    private final String email;
    private final String name;
    private final Collection<? extends GrantedAuthority> authorities;

    public FirebaseUserDetails(String uid, String email, String name, Collection<? extends GrantedAuthority> authorities) {
        this.uid = uid;
        this.email = email;
        this.name = name;
        this.authorities = authorities;
    }

    public FirebaseUserDetails(String uid, String email, String name) {
        this(uid, email, name, Collections.emptyList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
