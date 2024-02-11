package com.caceffo.APIportfolio.Domain;

import java.util.Optional;

public class Skills {
    public String imgUrl;
    public Skills(String imgUrl){
        this.imgUrl = Optional.ofNullable(imgUrl).orElse("");
        this.imgUrl.isBlankException("The images url can not be empty");
    }
}
