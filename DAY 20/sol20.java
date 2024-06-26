class Solution {
    public void merge(int[] arr1, int m, int[] arr2, int n)
    {
           int left = n-1;
        int right = 0;
        //long temp;
        while(left>=0 && right<m){
            if(arr1[left]>arr2[right]){
                 int temp = arr1[left];
                arr1[left]=arr2[right];
                arr2[right]=temp;
                left--;
                right++;
            }
            
            else break;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}