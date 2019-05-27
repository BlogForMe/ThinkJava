package HoldingObject.Demo.QueueAndCollection;

import java.util.Map;

/**
 * Created by Jon on 2016/6/12.
 * 11.13 Foreach与迭代器
 */
public class EnvironmentVariables {
    public static void main(String[] args) {
        for (Map.Entry entry : System.getenv().entrySet())
            System.out.println(entry.getKey() + ": " + entry.getValue());
    }
}
