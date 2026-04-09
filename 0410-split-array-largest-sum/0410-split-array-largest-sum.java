class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0;
        
        for (int num : nums) {
            low = Math.max(low, num); // max element
            high += num;              // total sum
        }
        
        int ans = high;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canSplit(nums, k, mid)) {
                ans = mid;
                high = mid - 1; // try smaller
            } else {
                low = mid + 1;  // need bigger
            }
        }
        
        return ans;
    }
    
    private boolean canSplit(int[] nums, int k, int maxSum) {
        int count = 1;
        int currentSum = 0;
        
        for (int num : nums) {
            if (currentSum + num > maxSum) {
                count++;
                currentSum = num;
                
                if (count > k) return false;
            } else {
                currentSum += num;
            }
        }
        
        return true;
    }
}
