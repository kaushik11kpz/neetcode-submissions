class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String token : tokens){
            if(!"+-*/".contains(token)){
                int value = Integer.parseInt(token);
                st.push(value);
                continue;
            }
            int oper1=st.pop();
            int oper2=st.pop();
            int value=0;
            switch(token){
                case "+":
                    value=oper2+oper1;
                    break;
                case "-":
                    value=oper2-oper1;
                    break;
                case "*":
                    value=oper2*oper1;
                    break;
                case "/":
                    value=oper2/oper1;
                    break;
            }
            st.push(value);
        }
        return st.pop();
    }
}
