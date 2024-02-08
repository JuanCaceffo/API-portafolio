package com.caceffo.APIportfolio.Domain;

import java.util.Optional;

public class PersonalProjects {
    private String type;
    private String title;
    private String description;
    private Optional<String> repo;
    private Optional<String> deploy;

    public PersonalProjects(String type, String title, String description, String repo, String deploy){
        type.isBlankException("Type cannot be blank");
        title.isBlankException("Title cannot be blank");
        description.isBlankException("Description cannot be blank");
        this.type = type;
        this.title = title;
        this.description = description;
        this.repo = Optional.ofNullable(repo);
        this.deploy = Optional.ofNullable(deploy);
    }

}
