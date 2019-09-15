package ua.training;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
      int[]  array = {1,4,3,6,7,8,3,4};
      for (int i = 0; i <array.length-1; i++){
          for (int j = 0; j<array.length - 1 - i; j++){
              conditionalSwap(array, j);
          }
      }
      System.out.println(Arrays.toString(array));
    }

    private static void conditionalSwap(int[] array, int i) {
        if(array[i]>array[i+1]){
            swap(array, i);
        }
    }

    private static void swap(int[] array, int i) {
        int tmp = array[i];
        array[i] = array[i+1];
        array[i+1] = tmp;
    }
}
