package com.tarikukebede.INhousenavigationsystem.services;

import com.tarikukebede.INhousenavigationsystem.http.HttpResponses;
import com.tarikukebede.INhousenavigationsystem.interfaces.ITemplateService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author Tariku Kebede
 * This class defines the basic sservice operations
 **/
public class ServiceTemplate<T,K> implements ITemplateService<T,K> {
    protected T t;
    private final JpaRepository<T,K> repository;

    public ServiceTemplate(JpaRepository<T, K> repository, T t){
        this.repository = repository;
        this.t = t;
    }


    @Override
    public T create(T obj) {
       try{
           return repository.save(obj);
       }catch (Exception e){
           e.printStackTrace();
           throw  errorWhileProcessing();
       }
    }

    @Override
    public ArrayList<T> create(ArrayList<T> objs) {
        if(objs == null){
            throw badRequest();
        }
        ArrayList<T> ts = new ArrayList<>();
        for(T t:objs){
            T result = create(t);
            ts.add(result);
        }
        return ts;
    }

    @Override
    public T get(K id) {
        Optional<T> result;
        try {
            result = repository.findById(id);
        }catch (Exception e){
            e.printStackTrace();
            throw errorWhileProcessing();
        }

        if(!result.isPresent()){
            throw notFound(id);
        }else{
            return result.get();
        }

    }

    public ResponseStatusException notFound(K id){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                HttpResponses.notFoundResponse(t, id));
    }

    public ResponseStatusException errorWhileProcessing(){
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                HttpResponses.errorWhileProcessing(t));
    }

    public ResponseStatusException badRequest(){
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                HttpResponses.badRequest(t));
    }

}
