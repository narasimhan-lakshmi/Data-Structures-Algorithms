class Solve {
    int[] findTwoElement(int arr[], int n) {
        
       long N  = n;
        long sn = (N * (N + 1)) / 2;
          long s2n = (N * (N + 1) * (2 * N + 1)) / 6;
        
         long  s = 0;
        long  s2 = 0;

       
        for (int i = 0; i < n; i++) {
            s += arr[i];
            s2 += (long)arr[i] * (long)arr[i];
        }

       
         long  diff1 = s - sn;       //  R - M
         long diff2 = s2 - s2n;     // TR^2 - M^2

        
        long  sum = diff2 / diff1;  //  R + M

        
         long  R = (diff1 + sum) / 2;
        long  M = R - diff1;

        
        int[] ans = { (int)R, (int)M };
        return ans;
    }
}