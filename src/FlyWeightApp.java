import java.util.*;

public class FlyWeightApp {
    public static void main(String[] args){
        ShapeFactory shapeFactory = new ShapeFactory();

        List<Shaape> shapes = new ArrayList<>();

        shapes.add(shapeFactory.getShape("square"));
        shapes.add(shapeFactory.getShape("circle"));
        shapes.add(shapeFactory.getShape("circle"));
        shapes.add(shapeFactory.getShape("point"));
        shapes.add(shapeFactory.getShape("square"));
        shapes.add(shapeFactory.getShape("circle"));

        Random random = new Random();
        for(Shaape shaape: shapes){
            int x = random.nextInt(100);
            int y = random.nextInt(100);
            shaape.draw(x, y);
        }
    }
}

interface Shaape{
    void draw(int x, int y);
}

class Point implements Shaape{

    @Override
    public void draw(int x, int y) {
        System.out.println("("+x+","+y+")"+": drawing point"  );
    }
}

class Cirrcle implements Shaape{
    int r = 5;
    @Override
    public void draw(int x, int y) {
        System.out.println("("+x+","+y+")"+": drawing a circle with radius "+r);
    }
}

class Squuare implements Shaape{
    int a = 10;
    @Override
    public void draw(int x, int y) {
        System.out.println("("+x+","+y+")"+": drawing a circle with a side "+a);
    }
}

class ShapeFactory{
    private static final Map<String, Shaape> shapes = new HashMap<>();
    public Shaape getShape(String shapeName){
        Shaape shaape = shapes.get(shapeName);
        if(shaape == null){
            switch (shapeName){
                case "circle":
                    shaape = new Cirrcle();
                    break;
                case "square":
                    shaape = new Squuare();
                    break;
                case "point":
                    shaape = new Point();
                    break;
            }
            shapes.put(shapeName, shaape);
        }
        return shaape;
    }
}
