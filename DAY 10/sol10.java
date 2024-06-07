class Solution {
    public int findMaxConsecutiveOnes(int[] arr) {
        int streak=0;
        int cnt = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==1){
                cnt ++;
            }
            else{
                cnt =0;
            }
            
            streak = Math.max(cnt , streak);
        } 
        return streak;
    }
}