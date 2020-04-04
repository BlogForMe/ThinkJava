package thinkjava.Demo.GenericsAndBasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Jon on 2016/6/10.
 * 11.3 添加一组元素
 */

class Snow {
}

class Powder extends Snow {
}

class Light extends Powder {
}

class Heavy extends Powder {
}

class Crusty extends Snow {
}

class Slush extends Snow {
}

public class AsListInference {
    public static void main(String[] args) {
        List<Snow> snow1 = Arrays.asList(new Crusty(), new Slush(), new Powder());
        //Won't compile:
        for (Snow s : snow1)
            System.out.println(s);

        List<Powder> snow2 = Arrays.asList(new Light(), new Heavy());
        //Compliler says:
        ArrayList<Snow> snow3 = new ArrayList<Snow>();
        Collections.addAll(snow3, new Light(), new Heavy());

        //Give a hint using an explicit type argument specification:
        List<Snow> snow4 = Arrays.<Snow>asList(new Light(), new Heavy());



    }
}
