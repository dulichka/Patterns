public class FacadeApp {
    public static void main(String[] args) throws InterruptedException{
//        Power power = new Power();
//        power.on();
//
//        DVDROm dvdrOm = new DVDROm();
//        dvdrOm.unload();
//
//        HDD hdd = new HDD();
//        hdd.copyFromDVD(dvdrOm);

        Computer computer = new Computer();
        computer.copy();
    }
}

class Computer{
    Power power = new Power();
    DVDROm dvdrOm = new DVDROm();
    HDD hdd = new HDD();

    void copy(){
        power.on();
        dvdrOm.load();
        hdd.copyFromDVD(dvdrOm);
    }
}

class Power{
    void on(){
        System.out.println("power on");
    }
    void off(){
        System.out.println("Power off");
    }
}

class DVDROm{
    private boolean data = false;
    public boolean hasData(){
        return data;
    }
    void load(){
        data = true;
    }
    void unload(){
        data = false;
    }
}

class HDD{
    void copyFromDVD(DVDROm dvdrOm){
        if(dvdrOm.hasData()){
            System.out.println("Copying data from the disk");
        }
        else {
            System.out.println("Insert a disk with data");
        }
    }
}
