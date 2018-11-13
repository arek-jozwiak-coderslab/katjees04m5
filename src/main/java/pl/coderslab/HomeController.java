package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    private final SomeComp someComp;

    @Autowired
    public HomeController(SomeComp someComp) {
        this.someComp = someComp;
    }

    @GetMapping("/home")
    @ResponseBody
    public String index(){
        System.out.println(someComp.getList());
        return "some return";
    }

    @RequestMapping("/home1")
    public String index2(){
        return "some return";
    }


}
