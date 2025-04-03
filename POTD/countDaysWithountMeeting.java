//LC 3169

class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings ,(a,b)-> a[0]-b[0] ); //sort meetings
        int last = 0;
        int ans = 0;

        for(int[]meeting : meetings){
            int start = meeting[0];
            int end = meeting[1];

            if(last<start){
                ans+= start-last-1;
            }
            last = Math.max(last,end);
        }
        ans += days - last;
        return ans;

    }
}
/* 
Example 1:

Input: days = 10, meetings = [[5,7],[1,3],[9,10]]

Output: 2

Explanation:

There is no meeting scheduled on the 4th and 8th days.

Example 2:

Input: days = 5, meetings = [[2,4],[1,3]]

Output: 1

Explanation:

There is no meeting scheduled on the 5th day.
*/