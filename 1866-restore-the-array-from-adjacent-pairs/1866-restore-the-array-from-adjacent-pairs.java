
class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        // Find minimum and maximum for nums values.
        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;
        for (int[] pair : adjacentPairs) {
            if (pair[0] < minNum)  minNum = pair[0];
            if (pair[0] > maxNum)  maxNum = pair[0];
            if (pair[1] < minNum)  minNum = pair[1];
            if (pair[1] > maxNum)  maxNum = pair[1];
        }
        minNum--;   // One less for min to reserve adjusted 0 as "unused".
        
        // Fill-in the links for all of the pairs, using the adjusted 
        // nums valued.  For each pair, get the nums[] values, then adjust 
        // to make possible negative nums[] be positive integers.  Save 
        // the links from each pair.
        final int[] links1 = new int[maxNum - minNum + 1];
        final int[] links2 = new int[maxNum - minNum + 1];
        for (int[] pair : adjacentPairs) {
            int u = pair[0] - minNum;   
            int v = pair[1] - minNum;
            if (links1[u] == 0)  links1[u] = v;  else  links2[u] = v;
            if (links1[v] == 0)  links1[v] = u;  else  links2[v] = u;
        }
        
        // Scan for first num, in links for the pairs, looking for a nums[] 
        // value that only has only one link.  There should only be two 
        // nums[] values with one link.  These two should be the start and 
        // end values for the nums[] array.  Which of these two is the start 
        // and which is the end, does not matter.
        int num = 0;
        for (num = links1.length - 1; num > 0; num--) 
            if (links1[num] != 0 && links2[num] == 0)
                break;
        
        // Fill in the nums[] array by following the links between nums[] 
        // values.
        int[] nums = new int[adjacentPairs.length + 1];
        int prev = 0;
        int idx = 0;
        while (num != 0) {
            nums[idx++] = num + minNum;
            int next = (links1[num] == prev) ? links2[num] : links1[num];
            prev = num;
            num = next;
        }
        
        return nums;
    }
}