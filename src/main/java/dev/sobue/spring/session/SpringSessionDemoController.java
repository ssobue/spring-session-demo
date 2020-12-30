package dev.sobue.spring.session;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller Class.
 *
 * @author ssobue
 */
@Controller
public class SpringSessionDemoController {

  @GetMapping({"/", "/top"})
  public ModelAndView index() {
    return new ModelAndView("index");
  }
}
