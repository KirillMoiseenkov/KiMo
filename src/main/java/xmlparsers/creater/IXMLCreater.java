package xmlparsers.creater;


import java.util.List;

public interface IXMLCreater<T> {

    void parsing(List<T> model);

}
