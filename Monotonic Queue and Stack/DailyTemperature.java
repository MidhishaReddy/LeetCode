class Solution {
    public int[] dailyTemperatures(int[] t) {
        
        //stack problem :
        Stack<Integer> stack = new Stack<>();
        
        //output array:
        int res[] = new int[t.length];
        
        //go thru the array and store the values:
        for(int i=0;i<t.length;i++){
            
            while(!stack.isEmpty() && t[stack.peek()]<t[i]){
                int idx = stack.pop();
                res[idx] = i-idx;
            }
            stack.push(i);
        }
        return res;
        
    }
}
