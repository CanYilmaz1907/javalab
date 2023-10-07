package ru.itis.dz.WebSecurity.filter;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.itis.dz.WebSecurity.auth.ApiKeyAuthentication;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Component
public class ApiAuthenticationFilter extends OncePerRequestFilter {

  AuthenticationManager authenticationManager;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    String apiKey = request.getParameter("api-key");

    if (apiKey != null) {
      Authentication ApiKeyAuthentication;
      SecurityContextHolder.getContext().setAuthentication(
              authenticationManager.authenticate(new ApiKeyAuthentication(AuthorityUtils.NO_AUTHORITIES, apiKey))
      );
    }

    filterChain.doFilter(request, response);
  }
}
