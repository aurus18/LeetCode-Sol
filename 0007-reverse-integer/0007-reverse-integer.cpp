class Solution {
public:
    int reverse(int x) {
        int l;
        long long s;
        s=0;
        while(x!=0)
        {
            l=x%10;
            s=s*10+l;
            x=x/10;
        }
        if (s>(-2147483648) && s<2147483647)
        {
            return s;
        }
        else 
        {
            return 0;
        }
    }
};