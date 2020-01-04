package JavaIo.Demo.ObjectSerialization_04;

import JavaIo.Utils.Constants;
import net.mindview.util.Print;

import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jon on 2016/5/28.
 * 18.12  transient关键字
 */
public class Logon implements Serializable {
    private Date date = new Date();
    private String username;
    private transient String password;

    public Logon(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Logon info:\n" +
                "date=" + date +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static void main(String[] args) throws Exception {
        Logon a = new Logon("Hulk", "myLittlePony");
        Print.print("Logon a = " + a);

        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(Constants.writePathU + "Logon.out"));
//        o.defaultWriteObject();       !!!!!!!!!!!!!????  为什么不能和  SerialCtrl一样调用这个方法
        o.writeObject(a);
        o.close();
        TimeUnit.SECONDS.sleep(1);  //Delay
        //Now get them  back;
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(Constants.writePathU + "Logon.out"));
        Print.print("Recovering object at " + new Date());
        a = (Logon) in.readObject();
        Print.print("Logon a = " + a);

    }


}
