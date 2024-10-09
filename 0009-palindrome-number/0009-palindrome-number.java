class Solution {
    public boolean isPalindrome(int x) {
        int c=x;
        int a;
        int b=0;
        while (c>0){
            a = c % 10;
            b = 10*b + a;
            c = c/10;
        }
        if (b==x){
            return true;
        }
        else {
            return false;
        }
    }
}