package сontrollers.interfaces.unmarhaling;

import DAO.interfaces.IDAO;
import models.BaseModel;

import java.util.List;

public interface IDefoultUnmarshalingService<T extends IDAO> {

/*
            public void setProperties();
            public String getProperties();
*/
            public T execute();



}
