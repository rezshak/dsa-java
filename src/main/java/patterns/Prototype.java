package patterns;

import java.util.HashMap;
import java.util.Map;

enum ShapeType {
    RECTANGLE("Rectangle"), SQUARE("Square"), CIRCLE("Circle");
    final String name;
    ShapeType(String name) { this.name = name; }
}

abstract class Shape implements Cloneable {
    final int id;
    ShapeType type;
    abstract void draw();
    Shape(int id) {
        this.id = id;
        this.type = null;
    }
    int getId() { return id; }
    ShapeType getType() { return type; }
    public Object clone() {
        Object clone = null;
        try { clone = super.clone(); }
        catch (CloneNotSupportedException e) { e.printStackTrace(); }
        return clone;
    }
}

class Rectangle extends Shape {
    Rectangle(int id) {
        super(id);
        type = ShapeType.RECTANGLE;
    }
    @Override void draw() { System.out.println("⬜️⬜️" + id); }
}

class Square extends Shape {
    Square(int id) {
        super(id);
        type = ShapeType.SQUARE;
    }
    @Override void draw() { System.out.println("⬜️" + id); }
}

class Circle extends Shape {
    Circle(int id) {
        super(id);
        type = ShapeType.CIRCLE;
    }
    @Override void draw() { System.out.println("⚪️" + id); };
}

class ShapeCache {
    static Map<Integer, Shape> shapeCache = new HashMap<>();
    static Shape getShapeById(int id) {
        Shape cachedShape = shapeCache.get(id);
        return (Shape) cachedShape.clone();
    }
    static void loadCache() {
        Rectangle rectangle = new Rectangle(100);
        shapeCache.put(rectangle.getId(), rectangle);
        Square square = new Square(300);
        shapeCache.put(square.getId(), square);
        Circle circle = new Circle(500);
        shapeCache.put(circle.getId(), circle);
    }
}

class Prototype {
    public static void main(String[] args) {
        ShapeCache.loadCache();
        Shape clonedShape1 = ShapeCache.getShapeById(100);
        clonedShape1.draw();
        Shape clonedShape2 = ShapeCache.getShapeById(300);
        clonedShape2.draw();
        Shape clonedShape3 = ShapeCache.getShapeById(500);
        clonedShape3.draw();
    }
}