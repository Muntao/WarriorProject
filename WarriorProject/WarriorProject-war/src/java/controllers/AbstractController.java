/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;

/**
 *
 * @author layfl
 */

public interface AbstractController<T> {

    public List<T> findAll();

    public T findById(T t) throws Exception;

    public String add();

    public String edit();

    public String edit(T t);

    public String detail(T t);
    
    public String remove(T t);
    
    public String addNew();


}
