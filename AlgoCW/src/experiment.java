import java.util.Random;
import java.util.Scanner;

public class experiment {
    public static int[] array(int arraySize){
        int[] arr = new int[arraySize];
        Random rand = new Random();
        for(int i = 0; i < arraySize; i++){
            arr[i] = rand.nextInt();
        }
        return arr;
    }
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int arr[] = experiment.array(x);
        quicksort.main(arr);
        heapsort.main(arr);
    }
}
