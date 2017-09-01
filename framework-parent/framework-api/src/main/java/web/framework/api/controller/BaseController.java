package web.framework.api.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

@RestController
@RequestMapping(value = "/base")
public class BaseController {

    /**
     * 通用方法
     * 
     * @param moduel
     *            模块名称
     * @param method
     *            方法名称
     * @param request
     *            请求对象
     * @param br
     *            body读取对象
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, path = "/{moduel}/{method}")
    public String common(@PathVariable String moduel, @PathVariable String method, HttpServletRequest request, BufferedReader br) {

        String inputLine;
        String str = "";
        try {
            while ((inputLine = br.readLine()) != null) {
                str += inputLine;
            }
            br.close();
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        System.out.println("str:" + str);
        if (!str.isEmpty()) {
            JSONObject obj = JSONObject.parseObject(str);
            System.out.println(obj);
        }

        return moduel + ",\t" + method;
    }

}
