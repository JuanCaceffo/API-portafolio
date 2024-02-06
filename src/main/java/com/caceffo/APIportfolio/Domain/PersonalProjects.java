package com.caceffo.APIportfolio.Domain;

public class PersonalProjects {
    private String type;
    private String title;
    private String description;
    private String repo;
    private String deploy;

    public PersonalProjects(String type, String title, String description, String repo, String deploy){
        this.type = type;
        this.title = title;
        this.description = description;
        this.repo = repo;
        this.deploy = deploy;
    }
}
