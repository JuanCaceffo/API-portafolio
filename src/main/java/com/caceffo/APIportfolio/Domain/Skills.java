package com.caceffo.APIportfolio.Domain;

import com.caceffo.APIportfolio.Errors.BusinessException;
import com.caceffo.APIportfolio.Repository.RepositoryProps;

public class Skills extends RepositoryProps {
    public String imgUrl;
    public Skills(String imgUrl){
        this.imgUrl = imgUrl.emptyIfIsNull();
        this.imgUrl.isBlankException(new BusinessException("Exception.PeronsalProject.CantBeEmpty","Img url"));
    }
}
