package JavaIo.Demo.NewIO_02;

import net.mindview.util.Print;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;


/**
 * Created by jon on 16-4-3.
 */
public class AvailableCharSets {
    public static void main(String[] args) {
        SortedMap<String, Charset> charSets = Charset.availableCharsets();
        Iterator<String> it = charSets.keySet().iterator();
        while (it.hasNext()) {
            String csName = it.next();
            Print.printnb(csName);
            Iterator<String> aliases = charSets.get(csName).aliases().iterator();
            if (aliases.hasNext())
                Print.printnb(": ");
            while (aliases.hasNext()) {
                Print.printnb(aliases.next());
                if (aliases.hasNext())
                    Print.printnb(". ");
            }
            Print.print();
        }


    }
}
