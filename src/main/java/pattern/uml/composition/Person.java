package pattern.uml.composition;

//也是整体与部分的关系，整体与部分不可以分开
public class Person {
    private IDCard card;
    private Head head = new Head();
}

class IDCard{}
class Head{}
