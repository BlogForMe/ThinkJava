package pattern.proxy.headfirst;


import java.lang.reflect.Proxy;
import java.util.HashMap;

public class MatchMakingTestDrive {
    HashMap<String, PersonBean> datingDB = new HashMap<>();

    public static void main(String[] args) {
        MatchMakingTestDrive test = new MatchMakingTestDrive();
        test.drive();

    }
    void drive(){
        PersonBean joe = getPersonFromDatabase("Joe Javabean");
        PersonBean ownerProxy = getOwnerProxy(joe);
        System.out.println("Name is "+ ownerProxy.getName());
        System.out.println("Interests set from owner proxy");
        try {
            ownerProxy.setHotOrNotRating(10);
        }catch (Exception e){
//            e.printStackTrace();
        }

        System.out.println("Rating is " + ownerProxy.getHotOrNotRating());
    }

    public MatchMakingTestDrive() {
        initializeDatabase();
    }

    PersonBean getOwnerProxy(PersonBean person){
        return (PersonBean) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new OwnerInvocationHandler(person)
        );
    }
    PersonBean getNonOwnerProxy(PersonBean person){
        return (PersonBean) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new NOnOwnerInvocationHandler(person)
        );
    }

    PersonBean getPersonFromDatabase(String name) {
        return (PersonBean) datingDB.get(name);
    }

    void initializeDatabase() {
        PersonBeanIml joe = new PersonBeanIml();
        joe.setName("Joe Javabean");
        joe.setInterests("cars, computers, music");
        joe.setHotOrNotRating(7);
        datingDB.put(joe.getName(), joe);

        PersonBeanIml kelly = new PersonBeanIml();
        kelly.setName("Joe Javabean");
        kelly.setInterests("cars, computers, music");
        kelly.setHotOrNotRating(7);
        datingDB.put(kelly.getName(), kelly);


    }
}
