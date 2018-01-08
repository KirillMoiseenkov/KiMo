package сontrollers.interfaces.marshaling;

import models.BaseModel;

import java.util.List;

public interface IDefoultMarshaling<T extends BaseModel> {


    public void setList(List<T> model);

    public void execute();


}
