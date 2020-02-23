import java.util.*;
import java.io.*;

public class collectData {
   
   public static void main(String[] args) {
      
      SortingAlgorithms sortingAlgorithms = new SortingAlgorithms();
   
      Random random = new Random();
      int L = 10000; // Length of array G.
      int loops = (L - 4000) / 1000;
      
      ArrayList<Long> timeArray = new ArrayList();
      ArrayList<Long> timeArray2 = new ArrayList(); 
      ArrayList<Long> timeArray3 = new ArrayList(); 
   
      ArrayList<Integer> G = new ArrayList<Integer>(L); // Set up the huge array G with length L.
      /** Fill in the array G with random integers from 1 to 1000 */
      int maxElementValue = 2000000000; // Max value for the array elements.
      for (int i = 0; i < L; i++) {
         G.add(random.nextInt(maxElementValue));
      }
      System.out.println("Array G:");
      System.out.println(G);
      
   //master loop for determining if it will be sorted by mergeSort, insertionSort, or quickSort
      for(int master = 1; master <= 3; master++) {
       
       /** Create 16 increasing sizes of array A and sort all of them. */
         for (int n = 4000; n <= L; n = n + 1000) {
            ArrayList<Integer> A = new ArrayList<Integer>(n); // Set up the array A with length n.
         /** Add random values in array A, which will take the values of array G later on. */
            for (int x = 0; x < n; x++) {
               A.add(random.nextInt(maxElementValue));
            }
         /** Copy over the values from array G. */
            for (int y = 0; y < n; y++) {
               A.set(y, G.get(y)); 
            }
         
         
         //MergeSort
            if(master == 1) { 
            
               System.out.println("Unsorted Array A (MergeSort) with " + n + " values:");
               System.out.println(A);
            
               long startTime = System.nanoTime();
               sortingAlgorithms.mergeSort(A, 0, A.size() - 1);
                 
               long endTime = System.nanoTime(); // End the timer.
               long totalTime = endTime - startTime; // Get the total execution time.
               timeArray.add(totalTime); // Fill in the standard execution time array T(n).
            
               System.out.println("Sorted Array A (MergeSort) with " + n + " values:");
               System.out.println(A);
            }
         
         //InsertionSort
            if(master == 2) {
            
               System.out.println("Unsorted Array A (InsertionSort) with " + n + " values:");
               System.out.println(A);
            
               long startTime2 = System.nanoTime();
               sortingAlgorithms.insertionSort(A);
                 
               long endTime2 = System.nanoTime(); // End the timer.
               long totalTime2 = endTime2 - startTime2; // Get the total execution time.
               timeArray2.add(totalTime2); // Fill in the standard execution time array T(n).
            
               System.out.println("Sorted Array A (InsertionSort) with " + n + " values:");
               System.out.println(A);
            }
         
         //QuickSort
            if(master == 3) {
            
               System.out.println("Unsorted Array A (QuickSort) with " + n + " values:");
               System.out.println(A);
            
               long startTime3 = System.nanoTime();
               sortingAlgorithms.quickSort(A, 0, A.size() - 1);
                 
               long endTime3 = System.nanoTime(); // End the timer.
               long totalTime3 = endTime3 - startTime3; // Get the total execution time.
               timeArray3.add(totalTime3); // Fill in the standard execution time array T(n).
            
               System.out.println("Sorted Array A (QuickSort) with " + n + " values:");
               System.out.println(A);
            }
         
         }
      
         
      
      
      
      
      /** Print all of the execution time arrays into "F.txt" */
         try {
            PrintWriter printWriter = new PrintWriter("F.txt");
            printWriter.println("Runtimes for mergeSort");
            printWriter.println(timeArray);
            printWriter.println("Runtimes for insertionSort");
            printWriter.println(timeArray2);
            printWriter.println("Runtimes for quickSort");
            printWriter.println(timeArray3);
            printWriter.close();
         }
         catch (FileNotFoundException e) {
            System.out.println("Unable to print to file.");
         }
      
      }
   }
}
   
