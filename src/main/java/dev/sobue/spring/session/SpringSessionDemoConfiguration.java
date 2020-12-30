package dev.sobue.spring.session;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.session.Session;
import org.springframework.session.SessionRepository;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;
import org.springframework.session.web.http.HttpSessionIdResolver;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
@EnableSpringHttpSession
public class SpringSessionDemoConfiguration {

  @Bean
  public FilterRegistrationBean<CookieRegisterServletFilter> cookieRegisterServletFilter() {
    FilterRegistrationBean<CookieRegisterServletFilter> registrationBean = new FilterRegistrationBean<>();
    CookieRegisterServletFilter filter = new CookieRegisterServletFilter();

    registrationBean.setFilter(filter);
    registrationBean.setName("cookieRegisterServletFilter");

    return registrationBean;
  }

  @Bean
  public FilterRegistrationBean<CommonsRequestLoggingFilter> commonsRequestLoggingFilter() {
    FilterRegistrationBean<CommonsRequestLoggingFilter> registrationBean = new FilterRegistrationBean<>();
    CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
    filter.setIncludeClientInfo(true);

    registrationBean.setFilter(filter);
    registrationBean.setName("commonsRequestLoggingFilter");
    registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);

    return registrationBean;
  }

  @Bean
  public SessionRepository<Session> cookieSessionRepository() {
    return new CookieSessionRepository();
  }

  @Bean
  public HttpSessionIdResolver httpSessionIdResolver() {
    return new CookieSessionIdResolver();
  }
}
