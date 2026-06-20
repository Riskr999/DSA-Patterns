class Solution {
    public int[] asteroidCollision(int[] asteroids) {
    Deque<Integer> stack = new ArrayDeque<>();

    for (int a : asteroids) {
        if (a > 0) {
            stack.push(a);
        } else {
            // pop all smaller right-movers
            while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -a) {
                stack.pop();
            }

            if (stack.isEmpty() || stack.peek() < 0) {
                stack.push(a);              // nothing blocking, current survives
            } else if (stack.peek() == -a) {
                stack.pop();                // equal size — both explode
            }
            // else: stack.peek() > -a → current explodes, do nothing
        }
    }

    int[] result = new int[stack.size()];
    for (int i = result.length - 1; i >= 0; i--)
        result[i] = stack.pop();

    return result;
}
}
