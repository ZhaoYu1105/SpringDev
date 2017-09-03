package devLib.boot.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeomController {

    @RequestMapping(method = RequestMethod.GET, value = "/{name}/{age}")
    @ResponseBody
    public String demo(@PathVariable String name, @PathVariable String age, String type) {
        return name + "," + age + "," + type;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public String demo1() {
        return "hello world";
    }
}
