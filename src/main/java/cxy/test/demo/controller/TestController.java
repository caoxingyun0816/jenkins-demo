package cxy.test.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.HashMap;
import java.util.Map;

/***
 * Created by Caoxingyun on 2019/07/01
 */

@RestController
@RequestMapping("/test")
public class TestController {
//
//    @Autowired
//    private TemplateEngine templateEngine;

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/hello")
    public String hello() {
        return "hello world!";
    }

    @GetMapping("/template")
    public String template() {
        Map<String, Object> param = new HashMap<>();
        param.put("title", "用户激活");
        param.put("url", "124");
        Context context = new Context();
        context.setVariables(param);
//        String emailText = templateEngine.process("/mailtemplate/mailtemplates.html", context);

        return "hello world!";
    }
}
