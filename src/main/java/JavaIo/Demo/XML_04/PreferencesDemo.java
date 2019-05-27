package JavaIo.Demo.XML_04;

import net.mindview.util.Print;

import java.util.prefs.Preferences;

/**
 * Created by Jon on 2016/5/28.
 * 18.14  Preferences
 */
public class PreferencesDemo {

    public static void main(String[] args) throws Exception {
        Preferences prefs = Preferences.userNodeForPackage(PreferencesDemo.class);
        prefs.put("Location", "OZ");
        prefs.put("Footwear", "Ruby Slippers");
        prefs.putInt("Companions", 4);
        prefs.putBoolean("Are there witches?", true);
        int usageCount = prefs.getInt("UsageCount", 0);
        usageCount++;
        prefs.putInt("UsageCount", usageCount);
        for (String key : prefs.keys())
            Print.print(key + ":" + prefs.get(key, null));
        //You must always provide a default value;
        Print.print("How many companions does Dorothy have?" + prefs.getInt("Companions", 0));
    }

}
