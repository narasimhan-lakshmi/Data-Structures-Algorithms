
class Solution {
    // Function to count the number of possible triangles.
    static int countTriangles(int arr[]) {
        int n = arr.length;
        int count = 0;

        // Sort the array to simplify the checking of triangle inequality
        Arrays.sort(arr);

        // Iterate through the array to fix the largest side of the triangle
        for (int i = n - 1; i >= 2; i--) {
            int left = 0, right = i - 1;

            // Use two pointers to find pairs (arr[left], arr[right])
            while (left < right) {
                if (arr[left] + arr[right] > arr[i]) {
                    // All indices from left to right - 1 will form valid triangles
                    count += (right - left);
                    right--; // Move the right pointer to explore smaller values
                } else {
                    left++; // Move the left pointer to explore larger values
                }
            }
        }
        return count;
    }
}

/* 
nput: arr[] = [4, 6, 3, 7]
Output: 3
Explanation: There are three triangles possible [3, 4, 6], [4, 6, 7] and [3, 6, 7]. 
Note that [3, 4, 7] is not a possible triangle.  
*/
