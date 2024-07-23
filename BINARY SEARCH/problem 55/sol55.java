class Solution {
    int median(int matrix[][], int R, int C) {
         
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

      
        for (int i = 0; i < R; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][C - 1]);
        }

        
        int totalElements = R * C;
       
        int medianPosition = (totalElements + 1) / 2;

       
        while (low < high) {
            int mid = (low + high) / 2;
            int count = 0;

           
            for (int i = 0; i < R; i++) {
                count += countSmallerOrEqual(matrix[i], mid);
            }


            if (count < medianPosition) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }