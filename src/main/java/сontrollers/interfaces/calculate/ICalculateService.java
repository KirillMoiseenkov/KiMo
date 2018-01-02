package сontrollers.interfaces.calculate;

import DAO.interfaces.IDAO;
import models.beforecalculate.ItemOfMenu;

public interface ICalculateService <T extends IDAO> {

    public void setDAO(T ...dao);

}
