package pattern.principle.ocp;

public class GraphicEditor {
    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Circle());
        graphicEditor.drawShape(new Triangle());
        graphicEditor.drawShape(new OtherGraphic());
    }

    public void drawShape(Shape s) {
        s.drawShape();
    }

}


abstract class Shape {
    public int m_type;

    abstract void drawShape();
}

class Rectangle extends Shape {
    @Override
    void drawShape() {
        System.out.println("绘制矩形");
    }
}

class Circle extends Shape {
    @Override
    void drawShape() {
        System.out.println("绘制圆形");
    }
}


class Triangle extends Shape {
    @Override
    void drawShape() {
        System.out.println("绘制三角形");
    }
}

//新增一个图形
class OtherGraphic extends Shape {

    @Override
    void drawShape() {
        System.out.println("新增一个图形");
    }
}