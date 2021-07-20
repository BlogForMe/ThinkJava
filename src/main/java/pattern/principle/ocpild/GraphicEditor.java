package pattern.principle.ocpild;

public class GraphicEditor {
    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Circle());
        graphicEditor.drawShape(new Triangle());
    }

    //添加一个图形需要修改
    public void drawShape(Shape s) {
        if (s.m_type == 1)
            drawRectangle(s);
        else if (s.m_type == 2)
            drawCircle(s);
        else if (s.m_type == 3)
            drawTriangle(s);
    }


    private void drawCircle(Shape s) {
        System.out.println("绘制圆形");

    }

    private void drawRectangle(Shape s) {
        System.out.println("绘制矩形");
    }

    //添加一个图形需要修改
    private void drawTriangle(Shape s) {
        System.out.println("绘制三角形");
    }
}


class Shape {
    public int m_type;
}

class Rectangle extends Shape {
    public Rectangle() {
        super.m_type = 1;
    }
}

class Circle extends Shape {
    public Circle() {
        super.m_type = 2;
    }
}

//新增图形
class Triangle extends Shape {
    public Triangle() {
        super.m_type = 3;
    }
}