package com.caceffo.APIportfolio.Domain;

import com.caceffo.APIportfolio.DTOs.PersonalProjectDTO;
import com.caceffo.APIportfolio.Domain.helpers.Langs;
import com.caceffo.APIportfolio.Errors.BusinessException;
import com.caceffo.APIportfolio.Repository.RepositoryProps;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Optional;

@Getter
@Setter
public class PersonalProjects extends RepositoryProps {
    private Langs type;
    private Langs title;
    private Langs description;
    private String repo;
    private String deploy;
    private ArrayList<String> imgs;

    public PersonalProjects(){}

    public PersonalProjects(@Nonnull Langs type, @Nonnull Langs title, @Nonnull Langs description, @Nullable String repo, @Nullable String deploy, @Nullable ArrayList<String> imgs) {
        this.type = type;
        this.title = title;
        this.description = description;
        this.repo = repo.emptyIfIsNull();
        this.deploy = deploy.emptyIfIsNull();
        this.imgs = imgs;
        validateFields();
    }

    public PersonalProjectDTO toDTO(String lang) {
        PersonalProjectDTO dto = new PersonalProjectDTO(this.type.getFieldFromString(lang), this.title.getFieldFromString(lang), this.description.getFieldFromString(lang), this.repo, this.deploy);
        return dto;
    }

    public void validateFields(){
        nullLangException("Type", type);
        nullLangException("Title", title);
        nullLangException("Description", description);
    }

    public Langs nullLangException(String fieldName, Langs field) {
        return Optional.ofNullable(field).orElseThrow(() -> new BusinessException("Exception.PeronsalProject.CantBeEmpty", fieldName));
    }
}
