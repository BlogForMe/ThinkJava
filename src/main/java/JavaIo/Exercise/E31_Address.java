package JavaIo.Exercise;

import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Serializer;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

import static JavaIo.Exercise.Person1.format;

/**
 * Created by jon on 17-1-8.
 */
public class E31_Address {
    public static void main(String[] args) throws Exception {
        List<Person1> people = Arrays.asList(new Person1("Dr.bunsen", "Honeydew", "NewYork"),
                new Person1("Gonzo", "The Great", "WaSHINTON"),
                new Person1("Phillip J.", "Fly", "HANGZHOU"));
        System.out.println(people);
        Element root = new Element("people");
        for (Person1 p1 : people)
            root.appendChild(p1.getXML());

        Document doc = new Document(root);
        format(System.out, doc);
        format(new BufferedOutputStream(new FileOutputStream(JavaIo.Utils.Constants.writePathU + "People.xml")), doc);
    }
}

class Person1 {

    private String first, last, addressName;

    public Person1(String first, String last, String addressName) {
        this.first = first;
        this.last = last;
        this.addressName = addressName;
    }

    //Produce an XML Element from this Person object:
    public Element getXML() {
        Element person = new Element("person");
        Element firstName = new Element("first");
        firstName.appendChild(first);
        Element lastName = new Element("last");
        lastName.appendChild(last);
        Element address = new Element("address");
        address.appendChild(addressName);
        person.appendChild(address);
        person.appendChild(firstName);
        person.appendChild(lastName);
        return person;
    }

    //Constructor to restore a Person from an XML Element:

    public Person1(Element person) {
        first = person.getFirstChildElement("first").getValue();
        last = person.getFirstChildElement("last").getValue();
        addressName = person.getFirstChildElement("address").getValue();
    }

    @Override
    public String toString() {
        return first + "   " + last;
    }

    //Make it human-readable:
    public static void format(OutputStream os, Document doc) throws Exception {
        Serializer serializer = new Serializer(os, "ISO-8859-1");
        serializer.setIndent(4);
        serializer.setMaxLength(60);
        serializer.write(doc);
        serializer.flush();
    }
}