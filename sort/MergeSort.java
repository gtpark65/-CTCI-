public class MergeSort {
   

   static void mergesort(int[] array) {
      int[] helper = new int[array.length];
      mergesort(array, helper, 0, array.length - 1);
      
   }
   
   static void mergesort(int[] array, int[] helper, int low, int high) {
      if(low < high) {
         int middle = (low + high) / 2;
         mergesort(array, helper, low, middle);
         mergesort(array, helper, middle+1, high);
         merge(array, helper, low, middle, high);
      }
   }
   
   static void merge(int[] array, int[] helper, int low, int middle, int high) {
      for(int i = low; i <= high; i++) {
         helper[i] = array[i];
      }
      
      int helperLeft = low;
      int helperRight = middle + 1;
      int current = low;
      
      while (helperLeft <= middle && helperRight <= high) {
         if(helper[helperLeft] <= helper[helperRight]) {
            array[current] = helper[helperLeft];
            helperLeft++;
         } else {
            array[current] = helper[helperRight];
            helperRight++;
         }
         current++;
      }

      int remaining = middle - helperLeft;
      
      for(int i = 0; i <= remaining; i++) {
         array[current + i] = helper[helperLeft + i];
      }
   }
   
   
   public static void main(String[] args) {
      int[] arr = {1,7,2,4,6,9,3,5,8};
      mergesort(arr);

      for(int i = 0; i < arr.length; i++) {
         System.out.print(arr[i]);
      }
      System.out.println();
   }
   
  
}