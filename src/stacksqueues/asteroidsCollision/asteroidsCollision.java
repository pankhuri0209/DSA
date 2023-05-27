package stacksqueues.asteroidsCollision;

import java.util.Arrays;
import java.util.Stack;

public class asteroidsCollision {
    public static void main(String[] args) {
        int[] arr = new int[]{10,-10};
        System.out.println(Arrays.toString(asteroidCollision(2,arr)));
    }
    public static int[] asteroidCollision(int n, int[] asteroids) {
        // code here
        Stack<Integer> s = new Stack<Integer>();
        for(int i=0; i<asteroids.length;i++){
            int curr = asteroids[i];
            boolean flag = false;
            while(!s.empty() && (curr<0 && s.peek()>0)){
                int abs = (-1)*curr;
                if(abs>s.peek()){
                    s.pop();
                }
                else if(abs<s.peek()){
                    flag = true;
                    break;

                }
                else if(abs==s.peek()){
                    s.pop();
                    flag=true;
                    break;
                }
            }
            if(!flag){
                s.push(curr);
            }

        }
        int[] ans = new int[s.size()];
        for(int i=ans.length-1; i>=0; i--){
            ans[i] = s.pop();
        }
        return ans;
    }
}
