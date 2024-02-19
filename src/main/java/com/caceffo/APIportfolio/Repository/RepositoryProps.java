package com.caceffo.APIportfolio.Repository;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class RepositoryProps {

    @JsonIgnore
    public Integer id = 0;
    public void newID(Integer newID){
        this.id = newID;
    }
}
