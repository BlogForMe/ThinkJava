package HoldingObject.Demo.QueueAndCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Jon on 2016/6/12.
 * 11.13.1  适配器方法惯用法
 */

class ReversibleArrayList<T> extends  ArrayList<T>{
    public ReversibleArrayList(Collection<T> c) {
        super(c);
    }
    public  Iterable<T> reversed(){
        return new Iterable<T>() {
            int current  = size() -1;
            public  boolean hasNext(){return  current > -1;}
            public  T next(){return  get(current--);}
            @Override
            public Iterator<T> iterator() {
                return null;
            }
        };
    }
}

public class AdapterMethodIdiom{
}
