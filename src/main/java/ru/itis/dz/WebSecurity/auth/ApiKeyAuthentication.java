package ru.itis.dz.WebSecurity.auth;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class ApiKeyAuthentication extends AbstractAuthenticationToken {

  private String apiKey;

  public ApiKeyAuthentication(Collection<? extends GrantedAuthority> authorities, String apikey) {
    super(authorities);
    this.apiKey = apikey;
  }

  @Override
  public Object getCredentials() {
    return null;
  }

  @Override
  public Object getPrincipal() {
    return apiKey;
  }
}
