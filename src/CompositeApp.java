import java.util.ArrayList;
import java.util.List;

public class CompositeApp {

    public static void main(String[] args){
        Shape square1 = new Squaare();
        Shape square2 = new Squaare();
        Shape triangle1 = new Triaangle();

        Shape square3 = new Squaare();
        Shape circle1 = new Ciircle();
        Shape circle2 = new Ciircle();
        Shape circle3 = new Ciircle();

        Composite composite = new Composite();
        Composite composite1 = new Composite();
        Composite composite2 = new Composite();

        composite1.addComponent(square1);
        composite1.addComponent(square2);
        composite1.addComponent(triangle1);

        composite2.addComponent(square3);
        composite2.addComponent(circle1);
        composite2.addComponent(circle2);
        composite2.addComponent(circle3);

        composite.addComponent(composite1);
        composite.addComponent(composite2);
        composite.addComponent(new Triaangle());

        composite.draw();
    }
}

interface Shape{
    void draw();
}

class Squaare implements Shape{

    @Override
    public void draw() {
        System.out.println("Hello from square");
    }
}

class Triaangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Hello from triangle");
    }
}

class Ciircle implements Shape{

    @Override
    public void draw() {
        System.out.println("Hello from circle");
    }
}

class Composite implements Shape{
    private List<Shape> components = new ArrayList<>();

    public void addComponent(Shape component){
        components.add(component);
    }

    public void removeComponent(Shape component){
        components.remove(component);
    }

    @Override
    public void draw() {
        for(Shape component: components){
            component.draw();
        }
    }
}


