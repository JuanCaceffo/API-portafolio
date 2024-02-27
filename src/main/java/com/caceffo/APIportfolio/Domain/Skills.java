package com.caceffo.APIportfolio.Domain;

import com.caceffo.APIportfolio.Errors.BusinessException;
import com.caceffo.APIportfolio.Repository.RepositoryProps;
import jakarta.annotation.Nonnull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Skills extends RepositoryProps {
    private String imgUrl;

    public Skills(){}
    public Skills(@Nonnull String imgUrl){
        this.imgUrl = imgUrl.emptyIfIsNull();
        validateFields();
    }

    public void validateFields(){
        this.imgUrl.isBlankException(new BusinessException("Exception.PeronsalProject.CantBeEmpty","Img url"));
    }
}
