package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class SessionController {

    @RequestMapping("/loginStart")
    @ResponseBody
    public String check(HttpSession session) {
        String loginStart = (String) session.getAttribute("loginStart");
        if(loginStart==null){
            loginStart = LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE).toString();
        }
        return "loginStart: " + loginStart;
    }
}
