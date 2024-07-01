class Solve {
    Pair getFloorAndCeil(int[] arr, int n, int x) {
        // code here
        Arrays.sort(arr);
        int start=0;
        int end= arr.length-1;
        int mid=0;
        int floor=-1,ceil=-1;
        while(start<=end)
        {
            mid=(start+end)/2;
            if(arr[mid]==x)
            {
                floor=arr[mid];
                ceil=arr[mid];
                break;
            }
            else if(arr[mid]<x)
            {
                floor=arr[mid];
                start=mid+1;
            }
            else
            {
                ceil=arr[mid];
                end=mid-1;
            }
        }
        return new Pair(floor,ceil);
    }
}