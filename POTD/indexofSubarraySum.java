class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;
        int sum = 0;
        int start = 0;

        for (int end = 0; end < n; end++) {
            
            sum += arr[end];

            // Remove elements from the start to maintain the target sum
            while (sum > target && start <= end) {
                sum -= arr[start];
                start++;
            }

            // Check if the current sum equals the target
            if (sum == target) {
                result.add(start + 1); 
                result.add(end + 1);  
                return result;
            }
        }

    
        result.add(-1);
        return result;
    }
}

/*
Input: arr[] = [1, 2, 3, 7, 5], target = 12
Output: [2, 4]
Explanation: The sum of elements from 2nd to 4th position is 12.
 */