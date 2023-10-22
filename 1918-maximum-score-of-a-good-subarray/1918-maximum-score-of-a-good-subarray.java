class Solution {
    public int maximumScore(int[] nums, int k) {
          int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                int poppedIndex = stack.pop();
                right[poppedIndex] = i - 1;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int poppedIndex = stack.pop();
            right[poppedIndex] = nums.length - 1;
        }

        stack.clear();

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                int poppedIndex = stack.pop();
                left[poppedIndex] = i + 1;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int poppedIndex = stack.pop();
            left[poppedIndex] = 0;
        }

        int maxScore = 0;
        for (int i = 0; i < nums.length; i++) {
            if (left[i] <= k && right[i] >= k) {
                int score = nums[i] * (right[i] - left[i] + 1);
                maxScore = Math.max(maxScore, score);
            }
        }

        return maxScore;
    }
    }
