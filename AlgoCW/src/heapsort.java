import java.util.Scanner;

/**edited from:
 * https://www.geeksforgeeks.org/java-program-for-heap-sort/
 */
public class heapsort {
    public static int comparisons = 0;
    public void sort(int arr[])
    {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(int arr[], int n, int i)
    {
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
        {
            largest = l;
            comparisons++;
        }

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
        {
            largest = r;
            comparisons++;
        }

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
            comparisons++;
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Driver program
    public static void main(int[] arr)
    {
        int n = arr.length;
        long startTime = System.nanoTime();

        heapsort ob = new heapsort();
        ob.sort(arr);
        long endTime = System.nanoTime();

        //System.out.println("Heapsorted array is");
        //printArray(arr);
        System.out.print("Heapsort runtime: " + (endTime - startTime)/1000000 +"ms\n");
        System.out.print("Heapsort number of comparisons: " + comparisons + "\n");
    }
}
