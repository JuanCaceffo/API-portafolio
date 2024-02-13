package com.caceffo.APIportfolio.Reposiroty;

import com.caceffo.APIportfolio.Errors.BussinesExeption;

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
    public T getElementById(Integer id){
        Optional<T> element =  elementsList.stream()
                .filter(item -> Objects.equals(item.id, id))
                .findFirst();
        if (element.isEmpty()){
            throw new BussinesExeption("El elemento no fue encontrado");
        }
        return element.get();
    }

    public ArrayList<T> getAll(){
        return elementsList;
    }

    public void deleteElement(T element){
        elementsList.remove(element);
    }

    public T addElement(T element){
        element.newID(id);
        elementsList.add(element);
        id++;
        return element;
    }
}
