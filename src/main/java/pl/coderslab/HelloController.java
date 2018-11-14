package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class HelloController {

    @RequestMapping("/helloRequestParam")
    @ResponseBody
    private String helloRequestParam(@RequestParam(defaultValue = "1", name = "otherParamName")
                                             String paramName) {
        System.out.println(paramName);
        return "My param = " + paramName;
    }

    @RequestMapping("/random/{max}/{min}")
    @ResponseBody
    public String random(@PathVariable int max, @PathVariable int min) {
        Random random = new Random();

        return "Użytkownik podał wartości" + min + "  i " +
                max + ". Wylosowano liczbę: " + (random.nextInt(max - min) + min);
    }

}
