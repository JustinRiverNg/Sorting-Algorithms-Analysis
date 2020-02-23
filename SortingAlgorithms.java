import java.util.ArrayList;

public class SortingAlgorithms {

      //insertion sort
   public void insertionSort(ArrayList<Integer> A) {
      
      for(int j = 1; j < A.size(); j++) {
         
         int key = A.get(j);
         int i = j - 1;
            
         while (i >= 0 && A.get(i) > key) {
            A.set(i + 1, A.get(i));
            i = i - 1;
         }
            
         A.set(i + 1, key);
      
      }
   }
     
     //partition for QuickSort
   public int partition(ArrayList<Integer> A, int p, int r) {
   
      int x = A.get(r);
      int i = p - 1;
      
      for(int j = p; j <= r - 1;  j++) {
         if (A.get(j) <= x) {
            i = i + 1;
            //swap integers
            int placeHolder = A.get(i);
            A.set(i, A.get(j));
            A.set(j, placeHolder);
         }
      }
      
      int placeHolder = A.get(i + 1);
      A.set(i + 1, A.get(r));
      A.set(r, placeHolder);
      
      int pivot = i + 1;
      return pivot;
   }
   
   //Quicksort
   public void quickSort(ArrayList<Integer> A, int p, int r) {
   
      if (p < r) {
         
         int q = this.partition(A, p, r);
         quickSort(A, p, q - 1);
         quickSort(A, q + 1, r);
      }
   
   }
  
   
   
   //mergeSort
   public void mergeSort(ArrayList<Integer> A, int p, int r) {
             
      if (p < r) {
         int q = Math.abs((p + r) / 2);
         this.mergeSort(A, p, q);
         this.mergeSort(A, q + 1, r);
         this.merge(A, p, q, r);
      }
   } 
   
    //merge
   public void merge(ArrayList<Integer> A, int p, int q, int r) {
         
      int n1 = q - p + 1;
      int n2 = r - q;
        
      ArrayList<Integer> left = new ArrayList<Integer>(n1);
      ArrayList<Integer> right = new ArrayList<Integer>(n2);
         
      for (int i = 0; i < n1; i++) {
         left.add(i, A.get(p + i));
      }
      for (int j = 0; j < n2; j++) {
         right.add(j, A.get(q + j + 1));
      }
      
      left.add(Integer.MAX_VALUE);
      right.add(Integer.MAX_VALUE);
         
      int i = 0;
      int j = 0;
      
      for (int k = p; k <= r; k++) {
         if (left.get(i) <= right.get(j)) {
            A.set(k, left.get(i));
            i = i + 1;
         }
         else {
            A.set(k, right.get(j));
            j = j + 1;
         }
      }
   }
 
}  
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
















