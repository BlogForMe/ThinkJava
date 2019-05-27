package JavaIo.Exercise;

import net.mindview.util.Print;

import java.util.Scanner;
import java.util.prefs.Preferences;

/**
 * Created by jon on 17-1-8.
 */
public class E33_PreferencesDemo {
    public static void main(String[] args) {
        Preferences prefs = Preferences.userNodeForPackage(E33_PreferencesDemo.class);
        String directory = prefs.get("base directory", "Not defined");
        Print.print("directory: " + directory);
        Scanner sc = new Scanner(System.in);
        Print.printnb("Enter a new directory");
        directory = sc.nextLine();
        prefs.put("base directory", directory);
        Print.print("\ndirctory: " + directory);
    }
}
