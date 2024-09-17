class Solution {
    public boolean canJump(int[] nums) { //nums = [2,3,1,1,4]
        // if (nums.length <= 1){
        //     return false;
        // }
        // for (int i = 0; i < nums.length; i++){
        //     if ( i > 0 ){
        //         int c = nums [i]; //c=3 when i=1
        //         if (c == (nums.length-i-1)){
        //             return true;
        //         }
        //     }
        // }
        // return false;
        // My approach is not working as i was accouting for an exact match rather than incremental value
        // and so it values of arrays like [0]
        // Method - 2 : using maxReach
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++){

            if (i > maxReach){
                return false;
            }
            // Update maxReach
            maxReach = Math.max(maxReach, i + nums[i]);
            // maxReach = 0, Math.max finds the larger among the two and updates accordingly

            // If we can reach or go beyond the last index, return true
            if (maxReach >= nums.length - 1) {
                return true;
            }

        }
        return false;
    }
}

// If at any point i > maxReach, it means we are stuck at an index we can't jump beyond, so we return false.
// At each step, we update maxReach to be the farthest index that can be reached from the current position.
// If maxReach ever reaches or exceeds the last index (nums.length - 1), we return true early.