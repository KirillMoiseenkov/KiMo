package сontrollers.interfaces.calculate;

import DAO.interfaces.IDAO;

public interface ICalculateService<T extends IDAO> {

    public void setDAO(T... dao);

}
