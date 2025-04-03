// LC 2523

class Solution {
    public int[] closestPrimes(int left, int right) {
  boolean[] prime = new boolean[right+1];
        seive( prime, right);

        int i, j ;
        j = left;
        int num1 = -1, num2 = -1;
        int dist = right+1;

        while( j <= right && !prime[j]) j++;
        // no prime exist
        if( j > right ) return new int[] { num1, num2};
        i = j++;
        while( j <= right && !prime[j]) j++;
        // only one  prime exist
        if( j > right ) return new int[] { num1, num2};
        
        while( j<= right){
           
            if( j-i < dist){
                dist  = j-i;
                num1 = i;
                num2 = j;
            }
            i =j;
            j++;
            while( j <= right && !prime[j]) j++;
        }

        return new int[]{ num1, num2};
    }
    void seive( boolean[] prime, int n){
        Arrays.fill( prime, true);
        prime[0] = prime[1 ] = false;
        for( int i =2; i<= n; i++ ){
            if( prime[i])
                for(int j = i+i; j<= n; j+= i)
                    prime[j] = false;
        }
    }
}

/* 
Example 1:

Input: left = 10, right = 19
Output: [11,13]
Explanation: The prime numbers between 10 and 19 are 11, 13, 17, and 19.
The closest gap between any pair is 2, which can be achieved by [11,13] or [17,19].
Since 11 is smaller than 17, we return the first pair.
Example 2:

Input: left = 4, right = 6
Output: [-1,-1]
Explanation: There exists only one prime number in the given range, so the conditions cannot be satisfied.
*/