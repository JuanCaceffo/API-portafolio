package com.caceffo.APIportfolio.Domain;

import com.caceffo.APIportfolio.Errors.BusinessException;
import com.caceffo.APIportfolio.Reposiroty.RepositoryProps;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

import java.util.Optional;

public class PersonalProjects extends RepositoryProps {
    private String type;
    private String title;
    private String description;
    private Optional<String> repo;
    private Optional<String> deploy;

    public PersonalProjects(@Nonnull String type,@Nonnull String title, @Nonnull String description, @Nullable String repo, @Nullable String deploy){
        this.type = type.emptyIfIsNull();
        this.title = title.emptyIfIsNull();
        this.description = description.emptyIfIsNull();
        this.repo = Optional.ofNullable(repo);
        this.deploy = Optional.ofNullable(deploy);
        //validations
        this.type.isBlankException(new BusinessException("Exception.PeronsalProject.CantBeEmpty","type"));
        this.title.isBlankException(new BusinessException("Exception.PeronsalProject.CantBeEmpty","Title"));
        this.description.isBlankException(new BusinessException("Exception.PeronsalProject.CantBeEmpty","Description"));
    }


}
