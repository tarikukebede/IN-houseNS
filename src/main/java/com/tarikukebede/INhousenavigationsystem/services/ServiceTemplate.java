package com.tarikukebede.INhousenavigationsystem.services;

import com.tarikukebede.INhousenavigationsystem.exception.ErrorHandler;
import com.tarikukebede.INhousenavigationsystem.interfaces.ITemplateService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author Tariku Kebede
 * This class defines the basic sservice operations
 **/
public class ServiceTemplate<T, K> extends ErrorHandler<T, K> implements ITemplateService<T, K> {
    protected T t;
    private final JpaRepository<T, K> repository;

    public ServiceTemplate(JpaRepository<T, K> repository, T t) {
        super(t);
        this.repository = repository;
        this.t = t;
    }


    @Override
    public T create(T obj) {
        try {
            return repository.save(obj);
        } catch (Exception e) {
            e.printStackTrace();
            throw errorWileProcessing(t);
        }
    }

    @Override
    public ArrayList<T> create(ArrayList<T> objs) {
        if (objs == null) {
            throw badRequest(t);
        }
        ArrayList<T> ts = new ArrayList<>();
        for (T t : objs) {
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
        } catch (Exception e) {
            e.printStackTrace();
            throw errorWileProcessing(t);
        }

        if (!result.isPresent()) {
            throw notFound(t, id);
        } else {
            return result.get();
        }

    }

}
