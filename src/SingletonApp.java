public class SingletonApp {
    public static void main(String[] args) throws InterruptedException {
        final int SIZE = 1000;
        Singleton arr[] = new Singleton[SIZE];

        Thread t[] = new Thread[SIZE];

        for (int i = 0; i < SIZE; i++){
            //arr[i] = Singleton.getInstance();
            t[i] = new Thread(new R());
            t[i].start();
        }

        for (int i = 0; i < SIZE; i++){
            t[i].join();
        }
        System.out.println(Singleton.counter);
    }
}

class R implements Runnable{

    @Override
    public void run() {
        Singleton.getInstance();
    }
}

class Singleton{
    private static volatile Singleton instance = null;
    public static int counter = 0;
    private Singleton(){
        counter++;
    }

    public static Singleton getInstance(){
        if(instance==null){
            synchronized (Singleton.class){
                if(instance==null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

//    public static synchronized Singleton getInstance(){
//        if(instance==null){
//            instance = new Singleton();
//        }
//        return instance;
//    }

//    public static Singleton getInstance(){ //предполагает инициадизацию при объявлении поля
//        return instance;
//    }
//    public static Singleton getInstance(){ //не работает при многопоточности
//        if(instance==null){
//            instance = new Singleton();
//        }
//        return instance;
//    }
}
