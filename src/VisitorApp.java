import com.sun.glass.events.WheelEvent;

public class VisitorApp {
    public static void main(String[] args){
//        Element body = new BodyElement();
//        Element engine = new EngineElement();
//        //Visitor hooligan = new HooliganVisitor();
//        Visitor mech = new MechanicVisitor();
//
//        body.accept(mech);
//        engine.accept(mech);

        Element car = new CarElement();
        car.accept(new HooliganVisitor());
        System.out.println();
        car.accept(new MechanicVisitor());
    }
}
interface Visitor{
    void visit(BodyElement bodyElement);
    void visit(EngineElement bodyElement);
    void visit(CarElement carElement);
    void visit(WheelElement wheelElement);
}

interface Element{
    void accept(Visitor visitor);
}

class BodyElement implements Element{

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class EngineElement implements Element{

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class CarElement implements Element{
    Element[] elements;

    public CarElement() {
        this.elements = new Element[] {
                new WheelElement("Переднее левое"), new WheelElement("Переднее правое"),
                new WheelElement("Заднее левое"), new WheelElement("Заднее правое"),
                new BodyElement(), new EngineElement()
        };
    }
    @Override
    public void accept(Visitor visitor) {
        for(Element e: elements){
            e.accept(visitor);
        }
        visitor.visit(this);
    }
}

class WheelElement implements Element{
    private String name;

    public WheelElement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class HooliganVisitor implements Visitor{

    @Override
    public void visit(BodyElement bodyElement) {
        System.out.println("Завел двигатель");
    }

    @Override
    public void visit(EngineElement bodyElement) {
        System.out.println("Постучал по корпусу");
    }

    @Override
    public void visit(CarElement carElement) {
        System.out.println("Покурил внутри мащины");
    }

    @Override
    public void visit(WheelElement wheelElement) {
        System.out.println("Пнул " + wheelElement.getName() + " колесо");
    }
}

class MechanicVisitor implements Visitor{

    @Override
    public void visit(BodyElement bodyElement) {
        System.out.println("Проверил двигатель");
    }

    @Override
    public void visit(EngineElement bodyElement) {
        System.out.println("Отполировал по корпусу");
    }

    @Override
    public void visit(CarElement carElement) {
        System.out.println("Проверил внешний вид авто");
    }

    @Override
    public void visit(WheelElement wheelElement) {
        System.out.println("Подкчал " + wheelElement.getName() + " колесо");
    }
}