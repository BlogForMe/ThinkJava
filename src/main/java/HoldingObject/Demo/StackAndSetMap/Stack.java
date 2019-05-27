package HoldingObject.Demo.StackAndSetMap;

import java.util.LinkedList;

/**
 * Created by Jon on 2016/6/11.
 * 11.8 Stack
 */
public class Stack<T> {
    private LinkedList<T> storage  = new LinkedList<T>();
    public  void push(T v){storage.addFirst(v);}
    public  T peek(){return  storage.getFirst();}
    public  T pop(){return  storage.removeFirst();}
    public  boolean empty(){return storage.isEmpty();}

    @Override
    public String toString() {
        return storage.toString();
    }
}
