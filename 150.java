// 150. Evaluate Reverse Polish Notation
// You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

// Approach - Stack (Work with the only two top-most visited numbers)

class Solution {
    public int evalRPN(String[] tokens) {

        int res = 0;

        Stack<Integer> stk = new Stack<>();

        for(String str : tokens){
            if(isNumeric(str)){
                int num = Integer.parseInt(str);
                stk.push(num);
                //System.out.println(stk);
            }else{
                int a = stk.pop();
                int b = stk.pop();
                if(str.equals("+")){
                    stk.push(b + a);
                }else if(str.equals("-")){
                    stk.push(b - a);
                }else if(str.equals("*")){
                    stk.push(b * a);
                }else{
                    stk.push(b / a);
                }
            }
        }

        return stk.pop();
        
    }

    public static boolean isNumeric(String str){

        if(str.charAt(0) == '-' && str.length() > 1){
            return true;
        }

        for(char c : str.toCharArray()){
            if(!Character.isDigit(c)){
                return false;
            }
        }

        return true;
    }
}
