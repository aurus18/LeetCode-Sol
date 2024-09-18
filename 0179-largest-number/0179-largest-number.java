class Solution {
    public String largestNumber(int[] nums) {
        String[] st = new String[nums.length]; // Initialize a new string 
        
        for (int i = 0; i < nums.length; i++){
            st[i] = String.valueOf(nums[i]); // Convert the array elements to string
        }

        Arrays.sort(st, (s1,s2) -> (s2+s1).compareTo(s1+s2)); 
        // Here we're sorting on the basis of 
        // when two adjacent numbers are joined which combination makes the larger no.
        // In [3,30,34,5,9]
        // 330 or 303
        // s1 = 3 & s2 = 30

        return st[0].equals("0")?"0":String.join("",st); 
        //Returns 0 if the first element of the string is 0 otherwise joins string without any spaces

    }
}