package com.caceffo.APIportfolio.Domain;

import com.caceffo.APIportfolio.Reposiroty.RepositoryProps;

import java.util.Optional;

public class Skills extends RepositoryProps {
    public String imgUrl;
    public Skills(String imgUrl){
        this.imgUrl = imgUrl.emptyIfIsNull();
        this.imgUrl.isBlankException("The images url can not be empty");
    }
}
