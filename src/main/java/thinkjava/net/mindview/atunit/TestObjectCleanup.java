//: thinkjava.net/mindview/atunit/TestObjectCleanup.java
// The @Unit @TestObjectCleanup tag.
package thinkjava.net.mindview.atunit;
import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestObjectCleanup {} ///:~
