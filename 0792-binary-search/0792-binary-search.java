class Solution {
    public int search(int[] nums, int target) {
      
      int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid; // Return the index where the target is found.
            } else if (nums[mid] < target) {
                left = mid + 1; // Search the right half.
            } else {
                right = mid - 1; // Search the left half.
            }
        }
        
        return -1; // Return -1 if the target is not found in the array.
    }
}

