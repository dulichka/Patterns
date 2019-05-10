public class DecoratorApp {

    public static void main(String[] args){
        //PrinterInerface printer = new Printer("Hello");
        //PrinterInerface printer = new QouteDecorator(new Printer("Hello"));
        PrinterInerface printer = new QouteDecorator(new LeftBracketDecorator(new RightBracketDecorator(new Printer("Hello"))));
        printer.print();
    }
}

interface PrinterInerface{
    void print();
}

class Printer implements PrinterInerface{
    String value;

    Printer(String value){
        this.value = value;
    }
    @Override
    public void print() {
        System.out.print(value);
    }
}

abstract class Decorator implements PrinterInerface{
    PrinterInerface component;
    public Decorator(PrinterInerface component){
        this.component = component;
    }
    public void print(){
        component.print();
    }
}

class QouteDecorator extends Decorator{
    QouteDecorator(PrinterInerface component){
        super(component);
    }
    @Override
    public void print() {
        System.out.print("\"");
        super.print();
        System.out.print("\"");
    }
}

class LeftBracketDecorator extends Decorator{
    LeftBracketDecorator(PrinterInerface component){
        super(component);
    }
    @Override
    public void print() {
        System.out.print("(");
        super.print();
    }
}

class RightBracketDecorator extends Decorator{
    RightBracketDecorator(PrinterInerface component){
        super(component);
    }
    @Override
    public void print() {
        super.print();
        System.out.print(")");
    }
}
