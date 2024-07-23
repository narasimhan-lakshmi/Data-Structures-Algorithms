class Solution {
    public int maxProduct(int[] arr) {
        int pre = 1;
        int suf = 1;
        int ans = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++){
            if(pre==0) pre = 1;
            if(suf==0) suf = 1;
            pre *= (int) arr[i];
            suf *= (int)arr[arr.length-1-i];
            if(suf<(Integer.MAX_VALUE)/2 || pre<(Integer.MAX_VALUE)/2)
            ans = Math.max(ans, Math.max(pre, suf));
        }
       return ans; 
    }
}