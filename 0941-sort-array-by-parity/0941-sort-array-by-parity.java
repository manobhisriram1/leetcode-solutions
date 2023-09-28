class Solution {
    
    public int[] sortArrayByParity(int[] nums) {
    int left = 0;  // Initialize the left pointer to the beginning of the array.
    int right = nums.length - 1;  // Initialize the right pointer to the end of the array.

    while (left < right) {  // Continue until the left and right pointers meet or cross.
        // Move left pointer to find the first odd number from the left
        while (left < right && nums[left] % 2 == 0) {
            left++;
        }

        // Move right pointer to find the first even number from the right
        while (left < right && nums[right] % 2 != 0) {
            right--;
        }

        // Swap the even and odd numbers if left < right
        if (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;  // Move the left pointer one step to the right
            right--;  // Move the right pointer one step to the left
        }
    }

    return nums;  // Return the modified array.
}
}
