package com.springapp.mvc;

import java.util.ArrayList;

/**
 * Created by Marat on 22.06.2016.
 */
public interface DocImpl {
    public String create(String name, long link, String format);

    public Docs getDocById(Integer id) throws Exception;

    public ArrayList<Docs> listDocs(int tabul) throws Exception;

    public String delete(Integer id) throws Exception;

    public String update(Integer id, String name) throws Exception;
}
