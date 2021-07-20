package pattern.uml.implementation;


//A实现B类，就是依赖关系的特例。
public class PersonServiceBean implements PersonService {
    @Override
    public void delete(Integer id) {
        System.out.println("delte..");
    }
}

interface  PersonService{
    public void delete(Integer id);
}