package com.caceffo.APIportfolio.Repository;

import com.caceffo.APIportfolio.Errors.BusinessException;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class Repository <T extends RepositoryProps> {
    private ArrayList<T> elementsList = new ArrayList<T>();
    private Integer id = 1;

    public void clear() {
        elementsList.clear();
        id = 1;
    }
    public T getElementById(Integer id){
        Optional<T> element =  elementsList.stream()
                .filter(item -> Objects.equals(item.id, id))
                .findFirst();
        if (element.isEmpty()){
            throw new BusinessException("Exception.Repository.notFound");
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
