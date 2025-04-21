// LC 781

class Solution {
    public int numRabbits(int[] answers) {
        int total = 0;
        Map<Integer,Integer> mpp = new HashMap<>();
        for(int ans:answers){
            mpp.put(ans,mpp.getOrDefault(ans,0)+1);
        }
        for(Map.Entry<Integer,Integer>entry : mpp.entrySet()){
            int x = entry.getKey();
            int cnt = entry.getValue();
            int size = x + 1;
            int groups = (cnt + x) / size;
            total +=  groups * size;
        }
        return total;
    }
}

/* 
Example 1:

Input: answers = [1,1,2]
Output: 5
Explanation:
The two rabbits that answered "1" could both be the same color, say red.
The rabbit that answered "2" can't be red or the answers would be inconsistent.
Say the rabbit that answered "2" was blue.
Then there should be 2 other blue rabbits in the forest that didn't answer into the array.
The smallest possible number of rabbits in the forest is therefore 5: 3 that answered plus 2 that didn't.
Example 2:

Input: answers = [10,10,10]
Output: 11
*/