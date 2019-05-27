package JavaIo.Demo.BasicIO_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 有 疑问
 * Created by jon o16-4-2.
 * 18.9进程控制
 */
public class OSExecute {
    public static void command(String command) {
        boolean err = false;
        try {
            Process process = new ProcessBuilder(command.split("")).start();
            BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s;
            while ((s = results.readLine()) != null)
                System.out.println(s);
            BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((s = errors.readLine()) != null) {
                System.err.println(s);
                err = true;
            }

        } catch (IOException e) {
            if (!command.startsWith("CMD/C"))
                command("CMD/C" + command);
            else
                throw new RuntimeException(e);

        }
        if (err) {

        }
    }

    public static void main(String[] args) {
        OSExecute.command("javap OSExecuteDemo");
    }
}
