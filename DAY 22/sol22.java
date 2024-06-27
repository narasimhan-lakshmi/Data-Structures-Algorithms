class Solution {
    public int longestConsecutive(int[] arr) {
        int longest = 1;
        if(arr.length == 0)
        return 0;

    Set<Integer> set = new HashSet<>();
    for(int i=0;i<arr.length;i++){
        set.add(arr[i]);
    }

    for(int it:set){
        if(!set.contains(it-1)){
            int cnt = 1;
            int x = it;
            
            while(set.contains(x+1)){
                x = x+1;
                cnt = cnt + 1;

            }
        
        longest = Math.max(longest,cnt);
        }
    }
    return longest;
        
    }
}