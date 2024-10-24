package edu.padroes.projetos_dio.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    /**
     * @author SandroAmânciodeSá
     * */
    @GetMapping("/api/hello")
    public String hello() {
        return "Hello, World!";
    }
}