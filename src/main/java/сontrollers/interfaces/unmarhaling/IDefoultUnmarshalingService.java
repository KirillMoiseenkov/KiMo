package сontrollers.interfaces.unmarhaling;

import DAO.interfaces.IDAO;

public interface IDefoultUnmarshalingService<T extends IDAO> {

    /*
                public void setProperties();
                public String getProperties();
    */
    public T execute();


}
