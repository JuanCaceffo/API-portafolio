package com.caceffo.APIportfolio.Domain;

import java.util.Optional;

public class Skils {
    public String imgUrl;
    public void Skills(String imgUrl){
        this.imgUrl = Optional.ofNullable(imgUrl).orElse("");
        this.imgUrl.isBlankException("The images url can not be empty");
    }
}
