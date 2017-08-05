package devLib.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeomController {

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String demo() {
        return "hello world";
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public String demo1() {
        return "hello world";
    }
}
