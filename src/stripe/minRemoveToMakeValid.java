package stripe;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class minRemoveToMakeValid {
    public String minRemoveToMakeValid(String s) {

        Set<Integer> remove = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        //pass1: identify unmatched paranthesis
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(i);
            }
            else if(c == ')'){
                if (stack.isEmpty()){
                    remove.add(i);
                }
                else{
                    stack.pop();
                }
            }
        }
        while(!stack.isEmpty()){
            remove.add(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            if(!remove.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();

    }
}
