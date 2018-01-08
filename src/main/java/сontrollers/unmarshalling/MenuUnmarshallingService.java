package сontrollers.unmarshalling;

import DAO.ItemOfMenuDAOImp;
import сontrollers.interfaces.unmarhaling.IDefoultUnmarshalingService;

public class MenuUnmarshallingService implements IDefoultUnmarshalingService<ItemOfMenuDAOImp> {

    private final String nameCollection = "menu";
    private ItemOfMenuDAOImp itemOfMenuDAOImp;


    public MenuUnmarshallingService(String URLMenu) {

        itemOfMenuDAOImp = new ItemOfMenuDAOImp();
        itemOfMenuDAOImp.setListByParsing(URLMenu);
    }


    @Override
    public ItemOfMenuDAOImp execute() {
        return itemOfMenuDAOImp;
    }
}
