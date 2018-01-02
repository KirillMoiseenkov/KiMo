package DAO.interfaces;

import models.BaseModel;

import java.util.List;

public interface IDAO<T extends BaseModel> {

    T getByName(String name);

    List<T> getAll();

}
