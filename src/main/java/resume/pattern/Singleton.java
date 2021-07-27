package resume.pattern;

public class Singleton {

    private static volatile Singleton INSTANCE;

    private Singleton(){}

    public Singleton getInstance(){
        if (INSTANCE==null){
            synchronized (this){
                if (INSTANCE==null){
                    return new Singleton();
                }
            }
        }
        return INSTANCE;
    }

}
