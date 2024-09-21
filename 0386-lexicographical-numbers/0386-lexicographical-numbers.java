class Solution {
    public List<Integer> lexicalOrder(int n) {
    List<Integer> ans = new ArrayList<>();
    backtrack(1, n, ans);
    return ans;
    }
  
  public void backtrack(int cur, int n, List<Integer> ans) {
    if (cur > n) return;
    ans.add(cur);
    backtrack(cur * 10, n, ans);
    if (cur % 10 != 9)
      backtrack(cur + 1, n, ans);
    }
}