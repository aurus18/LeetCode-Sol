class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList<>(); // Make a new list to store the result

        for (int i = 0; i < expression.length(); ++i){
            char opr = expression.charAt(i); // Stores the string element at i as char

            if ( opr == '+' || opr == '-' || opr == '*' ){ // Checks if the char is a operator

                List<Integer> s1 = diffWaysToCompute(expression.substring(0,i)); // Adds a bracket between 0 and i
                List<Integer> s2 = diffWaysToCompute(expression.substring(i+1)); // Adss a bracket after i + 1

                for (int a : s1){
                    for(int b : s2){
                        if (opr == '+') {
                            ans.add(a + b);
                        }
                        else if (opr == '-'){
                            ans.add(a - b);
                        }
                        else if (opr == '*'){
                            ans.add(a * b);
                        }
                    }
                }
            }
        }
        if (ans.isEmpty()){
            ans.add(Integer.parseInt(expression)); 
        }
        return ans;
    }
}