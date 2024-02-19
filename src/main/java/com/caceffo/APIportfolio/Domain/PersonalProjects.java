package com.caceffo.APIportfolio.Domain;

import com.caceffo.APIportfolio.DTOs.PersonalProjectDTO;
import com.caceffo.APIportfolio.Domain.helpers.Langs;
import com.caceffo.APIportfolio.Errors.BusinessException;
import com.caceffo.APIportfolio.Repository.RepositoryProps;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

import java.util.Optional;

public class PersonalProjects extends RepositoryProps {
    private Langs type;
    private Langs title;
    private Langs description;
    private Optional<String> repo;
    private Optional<String> deploy;

    public PersonalProjects(@Nonnull Langs type, @Nonnull Langs title, @Nonnull Langs description, @Nullable String repo, @Nullable String deploy) {
        this.type = nullLangException("Type", type);
        this.title = nullLangException("Title", title);
        this.description = nullLangException("Description", description);
        this.repo = Optional.ofNullable(repo);
        this.deploy = Optional.ofNullable(deploy);
    }

    public PersonalProjectDTO toDTO(String lang) {
        PersonalProjectDTO dto = new PersonalProjectDTO(this.type.getFieldFromString(lang), this.title.getFieldFromString(lang), this.description.getFieldFromString(lang), this.repo.get(), this.deploy.get());
        return dto;
    }

    public Langs nullLangException(String fieldName, Langs field) {
        return Optional.ofNullable(field).orElseThrow(() -> new BusinessException("Exception.PeronsalProject.CantBeEmpty", fieldName));
    }
}
