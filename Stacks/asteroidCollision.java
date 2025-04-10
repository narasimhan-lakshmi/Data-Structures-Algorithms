// LC 735


    class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            // If the asteroid is positive,  dded to the stack
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                // Handle collision for negative asteroids
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
                    stack.pop(); // Pop smaller positive asteroids
                }
                // Check for collision with the same size asteroid
                if (!stack.isEmpty() && stack.peek() == Math.abs(asteroid)) {
                    stack.pop(); // Both asteroids destroy each other
                } else if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid); // No collision or a negative asteroid
                }
                // If the current negative asteroid is smaller than the top of the stack, it will be destroyed
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
    }

    /* 
    Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
    */