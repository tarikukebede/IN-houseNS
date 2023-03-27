package com.tarikukebede.INhousenavigationsystem.interfaces;

import java.util.ArrayList;

/**
 * @author Tariku Kebede
 * defines basic service operations
 **/
public interface ITemplateService<T,K> {
   T create(T obj);
   ArrayList<T> create(ArrayList<T> objs);
   T get(K id);
}
