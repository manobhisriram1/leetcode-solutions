class Solution {
    public List<Integer> majorityElement(int[] nums) {
      
       int num1 = 0, num2 = 0, count1 = 0, count2 = 0;

        // Find potential majority elements
        for (int num : nums) {
            if (num == num1) {
                count1++;
            } else if (num == num2) {
                count2++;
            } else if (count1 == 0) {
                num1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                num2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Reset counters
        count1 = 0;
        count2 = 0;

        // Count actual occurrences of potential majority elements
        for (int num : nums) {
            if (num == num1) {
                count1++;
            } else if (num == num2) {
                count2++;
            }
        }

        // Find elements appearing more than n/3 times
        List<Integer> result = new ArrayList<>();
        if (count1 > nums.length / 3) {
            result.add(num1);
        }
        if (count2 > nums.length / 3) {
            result.add(num2);
        }

        return result;
    }
}