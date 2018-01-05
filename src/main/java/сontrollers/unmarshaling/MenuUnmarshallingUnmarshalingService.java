package сontrollers.unmarshaling;

import DAO.ItemOfMenuDAOImp;
import сontrollers.interfaces.unmarhaling.IDefoultUnmarshalingService;

public class MenuUnmarshallingUnmarshalingService implements IDefoultUnmarshalingService<ItemOfMenuDAOImp> {

    private ItemOfMenuDAOImp itemOfMenuDAOImp;
    private final String nameCollection = "menu";


    public MenuUnmarshallingUnmarshalingService(String URLMenu){

        itemOfMenuDAOImp = new ItemOfMenuDAOImp(nameCollection, URLMenu);

    }



    @Override
    public ItemOfMenuDAOImp execute()
    {
        return itemOfMenuDAOImp;
    }
}
