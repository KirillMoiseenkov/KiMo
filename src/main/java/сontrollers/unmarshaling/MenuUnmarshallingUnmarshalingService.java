package сontrollers.unmarshaling;

import DAO.ItemOfMenuDAOImp;
import сontrollers.interfaces.unmarhaling.IDefoultUnmarshalingService;

public class MenuUnmarshallingUnmarshalingService implements IDefoultUnmarshalingService<ItemOfMenuDAOImp> {

    private ItemOfMenuDAOImp itemOfMenuDAOImp;


    public MenuUnmarshallingUnmarshalingService(String URLMenu){

        itemOfMenuDAOImp = new ItemOfMenuDAOImp("menu", URLMenu);

    }



    @Override
    public ItemOfMenuDAOImp execute()
    {
        return itemOfMenuDAOImp;
    }
}
