import java.util.*;
public class SortOp {
    private static final int CUTOFF = 3;
    public static void quicksort( int [ ] a, int n)
    {
        //no random variables
        if(n < 3){        
            quicksort(a,0,a.length-1,n);
        }
        else if(n == 3)
            rQuicksort(a,0,a.length-1);
        else
        {
            threeRQuicksort(a,0,a.length-1);
        }
        
    }
    /*
    *** it chooses between two senarios, first pivot and median of three pivot
    ***  then takes the pivot developed based on what the integer n is 
    ***  and sorts the array recurrsively until it is completely sorted
    ***  by calling on the fEPartitioning for first element
    ***  and med3Partitioning for median of three elements
    */
    private static void quicksort( int [ ] a, int left, int right, int n )
    {
        int pivotIndex;
        if( left + CUTOFF <= right )
        {
            if(n == 1) //gets the pivot for first element and partitions array
            {
                int pivot = a[left];
                pivotIndex = fEPartitioning(a,left,right,pivot);
            }
            else //gets the pivot for median of 3 elements and partitions array
            {
                int pivot = median3( a, left, right );//median of three pivot
                pivotIndex = med3Partitioning(a,left,right,pivot);
            }
            
            
            quicksort( a, left, pivotIndex - 1,n);    // Sort small elements
            quicksort( a, pivotIndex + 1, right,n );   // Sort large elements
        }
        else  // Do an insertion sort on the subarray
            insertionSort( a, left, right );
    }
    //takes the 3 median pivot and uses it to sort some of the array
    private static int med3Partitioning(int [] a, int left, int right, int pivot)
    {
        int i = left, j = right - 1;
            for( ; ; )
            {
                while( a[ ++i ] < pivot ) { }
                while( a[ --j ] > pivot ) { }
                if( i < j )
                    swapReferences( a, i, j );
                else
                    break;
            }

            swapReferences( a, i, right - 1 );   // Restore pivot
            return i;
    }
    //takes the first element which was chosen to act as the pivot point
    // and uses that to go through and sort some of the array but not all
    private static int fEPartitioning(int [] a, int left, int right, int pivot)
    {
        int j = left + 1;
        for(int i = left + 1; i <= right; i++)
        {
            if(a[i] < pivot)
            {
                if(i != j)
                {
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
                j++;
            }
        }
        a[left] = a[j-1];
        a[j-1] = pivot;
        return j-1;
    }
    //creates a random integer to find the random pivot point within the array
    // and recursively sorts the array until it is sorted
    private static void rQuicksort( int [ ] a, int left, int right )
    {
        Random rand = new Random();
        int pivot = a[left + rand.nextInt(right-left)];
        int pivotIndex = oneRPartition(a,left,right,pivot);
        if(left < pivotIndex -1)
            rQuicksort(a,left,pivotIndex-1);
        if(pivotIndex < right)
            rQuicksort(a,pivotIndex,right);
    }
    //takes the random integer chosen to act as the pivot point for the quicksort
    // and uses that to go through and sort some of the array but not all
    private static int oneRPartition(int [] a,int left, int right,int pivot)
    {
        int i = left;
        int j = right;
        while(i <= j)
        {
            while (a[i] < pivot)
                i++;
            while(a[j] > pivot)
                j--;
            if(i <= j)
            {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        return i;
    }
    private static void threeRQuicksort(int [] a, int left, int right)
    {
        int i = left;
        int j = right;
        //generate three random integers to create the pivot point from their median
        Random rand = new Random();
        int f = rand.nextInt(a.length-1);
        int s = rand.nextInt(a.length-1);
        int t = rand.nextInt(a.length-1);
        
        int pivot = Math.max(Math.min(a[f],a[s]), Math.min(Math.max(a[f],a[s]),a[t]));
        
        while(i <= j){
            while(a[i] < pivot){ i++; }
            while(a[j] > pivot){ j--; }
            if(i <= j){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++; j--;
            }
        }
        if(left < j){ threeRQuicksort(a,left,j);}
        if(right > i){ threeRQuicksort(a,i,right);}
    }
    private static int median3( int[ ] intArray, int left, int right )
    {
        int center = ( left + right ) / 2;
        if( intArray[left] > intArray[center])
            swapReferences( intArray, left, center );
        if( intArray[left] > intArray[right])
            swapReferences( intArray, left, right );
        if( intArray[center] > intArray[right])
            swapReferences( intArray, center, right );

            // Place pivot at position right - 1
        swapReferences(intArray, center, right - 1 );
        return intArray[ right - 1 ];
    }
    public static void swapReferences( int[] intArray, int index1, int index2 )
    {
        int tmp = intArray[ index1 ];
        intArray[ index1 ] = intArray[ index2 ];
        intArray[ index2 ] = tmp;
    }
    private static void insertionSort( int[ ] a, int left, int right )
    {
        for( int p = left + 1; p <= right; p++ )
        {
            int tmp = a[ p ];
            int j;

            for( j = p; j > left && tmp < a[ j - 1 ]; j-- )
                a[ j ] = a[ j - 1 ];
            a[ j ] = tmp;
        }
    }
}
