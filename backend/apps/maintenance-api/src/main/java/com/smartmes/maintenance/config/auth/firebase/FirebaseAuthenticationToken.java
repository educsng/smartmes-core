package com.smartmes.maintenance.config.auth.firebase;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

public class FirebaseAuthenticationToken extends AbstractAuthenticationToken {

    private final UserDetails userDetails;

    public FirebaseAuthenticationToken(UserDetails userDetails) {
        super(userDetails.getAuthorities());
        this.userDetails = userDetails;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.userDetails;
    }
}
