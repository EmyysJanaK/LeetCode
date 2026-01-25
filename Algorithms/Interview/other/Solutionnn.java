
public class Solutionnn {
   
    // 1. Initialize two variables: minPrice to track the lowest price seen so far
    //    and maxProfit to track the maximum profit that can be achieved.
    // 2. Iterate through each price in the prices array: 
    //    a. If the current price is lower than minPrice, update minPrice.
    //    b. Otherwise, calculate the potential profit by subtracting minPrice from the current price.
    //       If this potential profit is greater than maxProfit, update maxProfit.
        // 3. After iterating through all prices, return maxProfit as the result.
    public static int maxProfit (int[] prices) {
        int minPrice = Integer.MAX_VALUE;  // Initialize minPrice to the highest possible value
        int maxProfit = 0;
        for (int price: prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            else if (price - minPrice > maxProfit) {
            maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    
    //give an array of size 10 with 6 elements and another array of size 4 with 4 elements. both are sorted.
    // merger them while preserving the sorted order.
    //arr1 = [1,3,5,7,9,11,0,0,0,0] 
    //arr2 = [2,4,6,8]
    public static void mergeIntoFirstArray(int[] arr1, int elementsInArr1, int[] arr2) {
        // Start from the end of both arrays
        int i = elementsInArr1 - 1; // Last valid element in arr1 
        int j = arr2.length - 1;    // Last element in arr2
        int k = arr1.length - 1;    // Last position in arr1 
        
        // Merge from the end to avoid shifting
        while (i >= 0 && j >= 0) {
            if (arr1[i] > arr2[j]) {
                arr1[k--] = arr1[i--];
            } else {
                arr1[k--] = arr2[j--];
            }
        }
        
        // Copy remaining elements from arr2, if any
        while (j >= 0) {
            arr1[k--] = arr2[j--];
        }
        
        // Note: We don't need to copy remaining elements from arr1 
        // because they're already in the correct positions
    }
    
    public static int[] sortedMerge(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] mergedArray = new int[n1 + n2];
        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                mergedArray[k++] = arr1[i++];
            } else {
                mergedArray[k++] = arr2[j++];
            }
        }
        while (i < n1) {
            mergedArray[k++] = arr1[i++];
        }
        while (j < n2) {
            mergedArray[k++] = arr2[j++];
        }
        return mergedArray;

    }

   
    //[1,2,3,4,5] -> [2,3,4,5,1] 
    public static void leftRotateArray(int[] arr) {
        int n = arr.length;
        int firstElement = arr[0];
        for (int i = 0; i < n - 1; i++) {
            arr[i] =  arr[i + 1];
            arr[n - 1] = firstElement;
        }

    }

    

    
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,9,4};
        
        //time to run
        long startTime = System.nanoTime();
        //print the time taken to run the function
        System.out.println("Max Profit: " + maxProfit(prices));
        // System.out.println("Max Profit using Map: " + maxProfitMap(prices));
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Time taken to run maxProfit: " + duration + " nanoseconds");

        int[] arr = {1,2,3,4,5}; 
        leftRotateArray(arr);
      }
}