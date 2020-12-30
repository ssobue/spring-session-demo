package dev.sobue.spring.session;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.session.Session;
import org.springframework.session.SessionRepository;

@Slf4j
public class CookieSessionRepository implements SessionRepository<Session> {

  private final Map<String, Session> sessionMap = new ConcurrentHashMap<>();

  @Override
  public Session createSession() {
    CookieSession session =
        CookieSession
        .builder()
        .build();

    log.info("create session = {}", session.getId());

    return session;
  }

  @Override
  public void save(Session session) {
    log.info("save session = {}", session.getId());

    sessionMap.put(session.getId(), session);
  }

  @Override
  public Session findById(String id) {
    log.info("find-by-id session = {}", id);

    return sessionMap.get(id);
  }

  @Override
  public void deleteById(String id) {
    log.info("delete-by-id session = {}", id);

    sessionMap.remove(id);
  }
}
