package com.caceffo.APIportfolio.Domain;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

import java.util.Optional;

public class PersonalProjects {
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
        //TODO: When the multi-languague API is ready change this
        this.type.isBlankException("Type cannot be blank");
        this.title.isBlankException("Title cannot be blank");
        this.description.isBlankException("Description cannot be blank");
    }


}
