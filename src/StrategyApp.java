import org.omg.CORBA.ARG_IN;

import java.util.Arrays;

public class StrategyApp {
    public static void main(String[] args){
        StrategyClient strategyClient = new StrategyClient();

        int[] arr0 = {1, 3, 2, 1};
        strategyClient.setStrategy(new SelectionSort());
        strategyClient.executeStrategy(arr0);

        int[] arr1 = {11, 4, 2, 7, 8, 54};
        strategyClient.setStrategy(new InsertingSort());
        strategyClient.executeStrategy(arr1);

        int[] arr2 = {3, -8, 2, 0, 33, 1, 3, 2};
        strategyClient.setStrategy(new BubbleSort());
        strategyClient.executeStrategy(arr2);
    }
}

interface Sorting{
    void sort(int[] arr);
}

class StrategyClient{
    Sorting strategy;

    public void setStrategy(Sorting strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(int[] arr){
        strategy.sort(arr);
    }
}

class BubbleSort implements Sorting{

    @Override
    public void sort(int[] arr) {
        System.out.println("Bubble sort");
        System.out.println("Before:\t" + Arrays.toString(arr));
        for (int barier = arr.length-1; barier >= 0; barier--){
            for (int i = 0; i < barier; i++){
                if(arr[i] > arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
        System.out.println("After:\t" + Arrays.toString(arr));
    }
}

class SelectionSort implements Sorting{

    @Override
    public void sort(int[] arr) {
        System.out.println("Selection sort");
        System.out.println("Before:\t" + Arrays.toString(arr));
        for (int barier = 0; barier < arr.length - 1; barier++){
            for (int i = barier+1; i < arr.length; i++){
                if(arr[i] < arr[barier]){
                    int temp = arr[i];
                    arr[i] = arr[barier];
                    arr[barier] = temp;
                }
            }
        }
        System.out.println("After:\t" + Arrays.toString(arr));
    }
}

class InsertingSort implements Sorting{

    @Override
    public void sort(int[] arr) {
        System.out.println("Inserting sort");
        System.out.println("Before:\t" + Arrays.toString(arr));
        for (int barier = 1; barier < arr.length - 1; barier++){
            int index = barier;
            while (index-1>=0 && arr[index]< arr[index-1]){
                int temp = arr[index];
                arr[index] = arr[index-1];
                arr[index-1] = temp;
                index--;
            }
        }
        System.out.println("After:\t" + Arrays.toString(arr));
    }
}
