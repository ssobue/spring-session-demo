package dev.sobue.spring.session;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.session.Session;

import static java.util.UUID.randomUUID;

@Slf4j
@Data
@ToString
@Builder
public class CookieSession implements Session, Serializable {

  private final String id = randomUUID().toString();

  private final Map<String, Object> attributes = new ConcurrentHashMap<>();

  private Instant lastAccessedTime = Instant.now();

  @Override
  public String getId() {
    return id;
  }

  @Override
  public String changeSessionId() {
    return null;
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T> T getAttribute(String attributeName) {
    log.info("get attribute = {}", attributeName);
    log.info("dump attribute = {}", attributes);
    return (T) attributes.get(attributeName);
  }

  @Override
  public Set<String> getAttributeNames() {
    return attributes.keySet();
  }

  @Override
  public void setAttribute(String attributeName, Object attributeValue) {
    log.info("set attribute = k:{} o:{}", attributeName, attributeValue);
    log.info("dump attribute = {}", attributes);
    attributes.put(attributeName, attributeValue);
    log.info("dump attribute = {}", attributes);
  }

  @Override
  public void removeAttribute(String attributeName) {
    log.info("remove attribute = k:{}", attributeName);
    log.info("dump attribute = {}", attributes);
    attributes.remove(attributeName);
    log.info("dump attribute = {}", attributes);
  }

  @Override
  public Instant getCreationTime() {
    return null;
  }

  @Override
  public void setLastAccessedTime(Instant lastAccessedTime) {
    this.lastAccessedTime = lastAccessedTime;
  }

  @Override
  public Instant getLastAccessedTime() {
    return lastAccessedTime;
  }

  @Override
  public void setMaxInactiveInterval(Duration interval) {

  }

  @Override
  public Duration getMaxInactiveInterval() {
    return Duration.of(30, ChronoUnit.MINUTES);
  }

  @Override
  public boolean isExpired() {
    return false;
  }
}
