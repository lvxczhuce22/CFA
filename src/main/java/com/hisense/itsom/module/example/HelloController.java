package com.hisense.itsom.module.example;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Springboot Hello示例
 * @author W.K.
 *
 */
@RestController
public class HelloController {
	
	@RequestMapping("/hello")
    public String index() {
        return "success";
    }
	
	@RequestMapping("/hello2")
    public String index2() {
        return "success2";
    }
	
}