package com.caceffo.APIportfolio.Controller;

import com.caceffo.APIportfolio.Errors.BusinessException;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("locale")
public class LocaleDemoController {
    private final MessageSource messageSource;

    public LocaleDemoController(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    @GetMapping("/hello")
    public String hellowWorld(@RequestHeader(name = "Accept-Language", required = false) Locale locale){
        throw new BusinessException("Exception.PeronsalProject.CantBeEmpty","juju");
        /*return messageSource.getMessage("greeting",null,locale);*/
    }


}
