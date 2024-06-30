class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();


        for (int row = 1; row <= numRows; row++) {
            List<Integer> tempLst = new ArrayList<>(); // temporary list
            for (int col = 1; col <= row; col++) {
                tempLst.add(nCr(row - 1, col - 1));
            }
            ans.add(tempLst);
        }
        return ans;
        
    }
    public static int nCr(int n,int r){
        long res = 1;
        for(int i=0;i<r;i++){
            res = res * (n-i);
            res = res/(i+1);
        }
        return (int) res;
    }
    
}