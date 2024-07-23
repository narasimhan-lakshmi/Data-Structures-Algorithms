class Solution {
    public boolean check(int[] a) {
        if(a.length <= 1)
            return true;
        for(int i=0;i<a.length-1;i++){
            if(a[i]>a[i+1])
                return false;
        }
        return true;
    }
}