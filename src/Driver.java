
import java.util.*;
import java.time.Duration;
import java.io.*;

public class Driver {
    //public static final int COUNT = 100000;

    public static void main(String[] args) throws FileNotFoundException 
    {
        System.out.print("Please input number of elements in array: ");
        Scanner nInput = new Scanner(System.in);
        int COUNT = nInput.nextInt();
        Random random = new Random();
        //List toSort = new ArrayList();
        PrintWriter unsorted = new PrintWriter("src/unsorted.txt");
        PrintWriter sorted = new PrintWriter("src/sorted.txt");
        int[] toSort1 = new int[COUNT];
        int[] toSort2 = new int[COUNT];
        int[] toSort3 = new int[COUNT];
        int[] toSort4 = new int[COUNT];
        

        // random numbers generated for array of integers
        for (int i = 0; i < COUNT; ++i) {
            int num = random.nextInt();
            toSort1[i] = num;
            toSort2[i] = num;
            toSort3[i] = num;
            toSort4[i] = num;
            unsorted.println(" " + num + ", ");
        }
        //start timer for first element pivot
        long sT = System.nanoTime();
        SortOp.quicksort(toSort1, 1);
        long fT = System.nanoTime(); //end timer
        Duration eT = Duration.ofNanos(fT-sT);//calculate total time spent sorting
        System.out.println("Time for First Element Quicksort: " + eT);
        
        //start timer for median of 3 pivot
        long sT2 = System.nanoTime();
        SortOp.quicksort(toSort2, 2);
        long fT2 = System.nanoTime(); //end timer
        Duration eT2 = Duration.ofNanos(fT2-sT2);//calculate total time spent sorting
        System.out.println("Time for Median of Three Quicksort: " + eT2);
        
        long sT3 = System.nanoTime();
        SortOp.quicksort(toSort3, 3);
        long fT3 = System.nanoTime();
        Duration eT3 = Duration.ofNanos(fT3-sT3);
        System.out.println("Random Integer Quicksort: " + eT3);
        if(COUNT < 130){
            long sT4 = System.nanoTime();
            SortOp.quicksort(toSort4, 4);
            long fT4 = System.nanoTime();
            Duration eT4 = Duration.ofNanos(fT4-sT4);
            System.out.println("Three Random Integer Quicksort: " + eT4);
            
            sorted.println("ThreeMedian | FirstElement | RandomInt | 3RandomInts");
            for(int i = 0; i < COUNT; i++)
            {
                sorted.println( toSort1[i] + " | " + toSort2[i] + " | " + toSort3[i] + " | " + toSort4[i]);
            }
        }
        else{
            sorted.println("ThreeMedian | FirstElement | RandomInteger");
            for(int i = 0; i < COUNT; i++)
            {
                sorted.println( toSort1[i] + " | " + toSort2[i] + " | " + toSort3[i]);
            }
        }   
        
        
        
        unsorted.close();
        sorted.close();
    }
}
