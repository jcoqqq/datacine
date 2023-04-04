package datacine.controller;

import datacine.service.RedirectPage;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@EnableWebMvc
@RequestMapping(value = "/")
public class FrontController {
    private RedirectPage redirect;

    @GetMapping(value = "/")
    public ModelAndView hello(@RequestParam(required = false) String home) {
        ModelAndView modelAndView = new ModelAndView();
        String page=redirect.Page(home);
        modelAndView.setViewName(page);
        return modelAndView;
    }
}
