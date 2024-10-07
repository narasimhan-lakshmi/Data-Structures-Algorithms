
class Solution {
    static long count(int n) {
    // code here
    int edges = (n*(n-1)) / 2;
    return (long) Math.pow(2, edges);

  }
}