package dev.sobue.spring.session;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.session.web.http.HttpSessionIdResolver;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static java.util.Objects.nonNull;

@Slf4j
public class CookieSessionIdResolver implements HttpSessionIdResolver {

  private static final String SESSION_COOKIE_NAME = "SESSION";

  @Override
  public List<String> resolveSessionIds(
      HttpServletRequest httpServletRequest
  ) {
    log.info("resolve session ids");

    Optional<Cookie> cookie =
        nonNull(httpServletRequest.getCookies())
            ? Stream.of(httpServletRequest.getCookies())
            .filter(c -> SESSION_COOKIE_NAME.equals(c.getName()))
            .findFirst()
            : Optional.empty();

    return cookie
        .map(value -> {
          log.info("session id = {}", value.getValue());
          return singletonList(value.getValue());
        })
        .orElseGet(() -> {
          log.info("no session id.");
          return emptyList();
        });
  }

  @Override
  public void setSessionId(
      HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse,
      String s
  ) {
    log.info("set session id = {}", s);
    httpServletResponse.addCookie(new Cookie(SESSION_COOKIE_NAME, s));
  }

  @Override
  public void expireSession(
      HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse
  ) {
    log.info("expire session");
  }
}
