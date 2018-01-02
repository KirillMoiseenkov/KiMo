package сontrollers.interfaces.calculate;

import models.BaseModel;

import java.util.List;

public interface ICalculateTargetService<T extends BaseModel>{

    public List<T> exexute();

}
