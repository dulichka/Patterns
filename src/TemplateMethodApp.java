public class TemplateMethodApp {
    public static void main(String[] args){
        Cc a = new Aa();
        a.templateMethod();
        System.out.println();

        Cc b = new Bb();
        b.templateMethod();
    }
}

abstract class Cc{
    void templateMethod(){
        System.out.print("1");
        differ();
        System.out.print("3");
        differ2();
    }

    abstract void differ();
    abstract void differ2();
}

class Aa extends Cc{

    @Override
    void differ() {
        System.out.print("2");
    }

    @Override
    void differ2() {
        System.out.print("5");
    }
}

class Bb extends Cc{

    @Override
    void differ() {
        System.out.print("4");
    }

    @Override
    void differ2() {

    }
}
