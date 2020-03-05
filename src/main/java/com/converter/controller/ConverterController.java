package com.converter.controller;

import com.converter.service.ConverterService;
import com.fasterxml.jackson.core.JsonParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class ConverterController implements ErrorController {

    @Autowired
    ConverterService converterService;

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
        return "Error handling";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }

    @GetMapping("/")
    public String home(Model model){
        return "converter";
    }
    @PostMapping("/userInputJson")
    public String toYaml(@RequestParam(name = "json", required = false, defaultValue = "")
                                        String json, Model model) throws IOException {

        model.addAttribute("json", json);
        try{
            String yaml = converterService.toYaml(json);
            model.addAttribute("yaml", yaml);
        }catch (JsonParseException e) {
            model.addAttribute("yaml", "Given json is invalid");
        }
        return "converter";
    }
}
