package stripe;

import java.util.Stack;

public class simplifyPath {
    public String simplifyPath(String path) {
        String[] paths= path.split("/");
        Stack<String> stack = new Stack<>();
        for(String p:paths){
            if(p.equals(".") || p.equals("")){continue;}
            else if(p.equals("..")){
                if (!stack.isEmpty()){
                    stack.pop();
                }
            }
            else {
                stack.push(p);
            }
        }
        return "/"+String.join("/",stack);
    }
}
