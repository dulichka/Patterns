import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ObserverApp {
    public static void main(String[] args){
        MeteoStation meteoStation = new MeteoStation();

        meteoStation.addObserver(new ConsoleObserver());
        meteoStation.addObserver(new FileObserver());
        meteoStation.setMessurements(25, 760);
        meteoStation.setMessurements(-5, 827);
    }
}

interface Observer{
    void handleEvent(int temp, int pressure);
}

interface Observed{
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

class MeteoStation implements Observed{
    int temperature;
    int pressure;

    List<Observer> observers = new ArrayList<>();

    public void setMessurements(int t, int p){
        temperature = t;
        pressure = p;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer o: observers){
            o.handleEvent(temperature, pressure);
        }
    }
}

class ConsoleObserver implements Observer{
    @Override
    public void handleEvent(int temp, int pressure) {
        System.out.println("Weather changed. Temperature: " + temp + " Pressure: " + pressure);
    }
}

class FileObserver implements Observer{

    @Override
    public void handleEvent(int temp, int pressure) {
        File f;
        try {
            f = File.createTempFile("Temp_pressure", "_txt");
            PrintWriter pw = new PrintWriter(f);
            pw.write("Weather changed. Temperature = " + temp + ", Pressure" + pressure);
            pw.println();
            pw.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
