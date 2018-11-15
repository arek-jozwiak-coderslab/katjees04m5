package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
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

    @RequestMapping("/workers")
    public String workersAction(Model model, HttpServletRequest request) {
        List<String> fileContent;
        String person = "not found";
        try {
            ServletContext servletContext = request.getServletContext();
            String contextPath = servletContext.getRealPath(File.separator);
            fileContent = Files.readAllLines(Paths.get(contextPath + "/WEB-INF/classes/workers.txt"));
            int randomId = (new Random()).nextInt(30) + 1;
            for (String line : fileContent) {
                int id = Integer.parseInt(line.substring(0, 2));
                if (id == randomId) {
                    person = line.substring(4, line.length());
                    break;
                }
            }
            model.addAttribute("person", person);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "workers";
    }

}
