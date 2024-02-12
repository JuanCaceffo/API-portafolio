package com.caceffo.APIportfolio.Reposiroty;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

public class Repository <T extends RepositoryProps> {
    private ArrayList<T> elementsList = new ArrayList<T>();
    private Integer id = 0;

    public void clear() {
        elementsList.clear();
        id = 0;
    }

    //TODO: add an exception if the element wasn't find
    public Optional<T> getById(Integer id){
        return elementsList.stream()
                .filter(element -> Objects.equals(element.id, id))
                .findFirst();
    }
}
