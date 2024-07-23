class Solution {
    public static long findPages(int n, int[] arr, int m) {
        if(m > n) return -1; 
        int low = Arrays.stream(arr).max().orElseThrow(); 
        int high = Arrays.stream(arr).sum(); 
        
        while(low <= high) {
            int mid = (low + high) / 2;
            int students = count(arr, mid);
            
            if (students > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return low; 
    }
    
    static int count(int[] arr, int pages) {
        int students = 1;
        int pagesPerStudent = 0;
        
        for(int i = 0; i < arr.length; i++) {
            if(pagesPerStudent + arr[i] <= pages) {
                pagesPerStudent += arr[i];
            } else {
                students++;
                pagesPerStudent = arr[i];
            }
        }
        
        return students;
    }
}