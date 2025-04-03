// LC 2206

class Solution {
    public boolean divideArray(int[] nums) {
        int vis[] = new int[510];
        //count occurence 
        //each element
        for(int no:nums){
            vis[no]++;
        }
        for(int cnt:vis){
            //cnt even na
            //elements will occur in pairs
            if(cnt % 2 != 0) return false;
        }
        return true;
    }
}