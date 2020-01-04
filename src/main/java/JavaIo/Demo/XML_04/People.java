package JavaIo.Demo.XML_04;

import JavaIo.Utils.Constants;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Elements;

import java.util.ArrayList;

/**
 * Created by Jon on 2016/5/28.
 * 解码  XML
 * <p>
 * 为什么这里会出错
 */
public class People extends ArrayList<Person> {

    public People(String fileName) throws Exception {
        Document doc = new Builder().build(fileName);
        Elements elements = doc.getRootElement().getChildElements();
        for (int i = 0; i < elements.size(); i++)
            add(new Person(elements.get(i)));
    }

    public static void main(String[] args) throws Exception {
        People p = new People(Constants.writePathU + "People.xml");
        System.out.println(p);
    }
}
