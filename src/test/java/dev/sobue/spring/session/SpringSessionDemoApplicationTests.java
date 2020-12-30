package dev.sobue.spring.session;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@DisplayName("Application Launching Tests")
class SpringSessionDemoApplicationTests {

  private final ApplicationContext context;

  @Autowired
  SpringSessionDemoApplicationTests(ApplicationContext context) {
    this.context = context;
  }

  @Test
  @DisplayName("Context Load Test")
  void contextLoads() {
    assertNotNull(context);
  }
}
