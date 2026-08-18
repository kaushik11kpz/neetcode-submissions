class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        HashSet<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        for(String token : tokens){
            if(set.contains(token)){
                int oper1=st.pop();
                int oper2=st.pop();
                int value=0;
                if(token.equals("+")){
                    value=oper2 + oper1;
                }else if(token.equals("-")){
                    value=oper2 - oper1;
                }else if(token.equals("*")){
                    value=oper2 * oper1;
                }else{
                    value=oper2/oper1;
                }
                st.push(value);
            }else{
                int value = Integer.parseInt(token);
                st.push(value);
            }
        }
        return st.pop();
    }
}
