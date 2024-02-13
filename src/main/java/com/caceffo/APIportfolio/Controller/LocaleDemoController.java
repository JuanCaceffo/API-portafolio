package com.caceffo.APIportfolio.Controller;

import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("locale")
public class LocaleDemoController {
    private final MessageSource messageSource;

    public LocaleDemoController(MessageSource messageSource){
        this.messageSource = messageSource;
    }


}
