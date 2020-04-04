//: thinkjava.typeinfo/pets/ForNameCreator.java
package thinkjava.typeinfo.pets;
import java.util.*;

public class ForNameCreator extends PetCreator {
  private static List<Class<? extends Pet>> types =
    new ArrayList<Class<? extends Pet>>();
  // Types that you want to be randomly created:
  private static String[] typeNames = {
    "thinkjava.typeinfo.pets.Mutt",
    "thinkjava.typeinfo.pets.Pug",
    "thinkjava.typeinfo.pets.EgyptianMau",
    "thinkjava.typeinfo.pets.Manx",
    "thinkjava.typeinfo.pets.Cymric",
    "thinkjava.typeinfo.pets.Rat",
    "thinkjava.typeinfo.pets.Mouse",
    "thinkjava.typeinfo.pets.Hamster"
  };	
  @SuppressWarnings("unchecked")
  private static void loader() {
    try {
      for(String name : typeNames)
        types.add(
          (Class<? extends Pet>)Class.forName(name));
    } catch(ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
  static { loader(); }
  public List<Class<? extends Pet>> types() {return types;}
} ///:~
