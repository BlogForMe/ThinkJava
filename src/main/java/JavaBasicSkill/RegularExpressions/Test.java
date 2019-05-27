package JavaBasicSkill.RegularExpressions;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jon on 2016/4/16.
 */
public class Test {
    public static void main(String[] args) {
        //简单认识正则表达式
     /*   p("abc".matches("..."));
        p("a8729a".replaceAll("\\d", "-"));
        Pattern p = Pattern.compile("[a-z]{3}");
        Matcher m = p.matcher("fgh");
        p(m.matches());
        p("fgaa".matches("[a-z]{3}"));*/


        p("a".matches("."));
        p("aa".matches("aa"));
        p("aaaa".matches("a*"));
        p("aaaa".matches("a+"));
        p("aaaa".matches("a?"));
        p("".matches("a*"));
        p("a".matches("a?"));
        p("2223333444949".matches("\\d{3,100}"));
    }

    public static void p(Object o) {
        System.out.println(o);
    }
}
