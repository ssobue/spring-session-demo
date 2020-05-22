package dev.sobue.spring.session;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
@DisplayName("Application Launching Tests")
class SpringSessionDemoApplicationTests {

    @Autowired
    private ApplicationContext context;

    @Test
    @DisplayName("Context Load Test")
    void contextLoads() {
        assertNotNull(context);
    }
}
