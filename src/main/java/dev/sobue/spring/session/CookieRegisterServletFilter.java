package dev.sobue.spring.session;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

@Slf4j
public class CookieRegisterServletFilter extends OncePerRequestFilter {

  @Override
  protected void doFilterInternal(
      HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse,
      FilterChain filterChain
  ) throws ServletException, IOException {
    log.info("start filter");

    filterChain.doFilter(httpServletRequest, httpServletResponse);

    log.info("end filter");
  }
}
