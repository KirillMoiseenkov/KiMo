package DAO.interfaces;

import models.BaseModel;

import java.util.List;

public interface IDAO<T extends BaseModel> {

    T getByName(String name);

    void setList(List<T> items);

    void setListByParsing(String URL);

    List<T> getAll();

}
