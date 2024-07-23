class Solution {
    public int missingNumber(int[] a,int n) {
        int total;
        total = n * (n+1) / 2;
        for(int i=0;i<n-1;i++)
            total= total - array[i];
            return total;
    }

}