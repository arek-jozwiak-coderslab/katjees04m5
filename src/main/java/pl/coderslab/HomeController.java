package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
public class HomeController {

    private final SomeComp someComp;

    @Autowired
    public HomeController(SomeComp someComp) {
        this.someComp = someComp;
    }

    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("param1", "someValue");
        return "index";
    }

    @RequestMapping("/helloView")
    public String helloView(Model model) {
        LocalDateTime now = LocalDateTime.now();
        if (now.getHour() > 8 && now.getHour() < 20) {
            model.addAttribute("color", "black");
            model.addAttribute("backgroundColor", "white");
        } else {
            model.addAttribute("color", "white");
            model.addAttribute("backgroundColor", "black");
        }
        return "home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    @GetMapping("/home")
    public String index() {
        System.out.println(someComp.getList());
        return "/views/home";
    }

    @RequestMapping("/home1")
    @ResponseBody
    public String index2() {
        return "some return";
    }


}
