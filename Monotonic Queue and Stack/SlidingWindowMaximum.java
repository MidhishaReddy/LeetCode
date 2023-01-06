class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
      
       // [1 3 -1 -3 5 3 6 7] n = 8-3 = 5
      //               |   i 
        // dqueue= 7
        //res = [3 3 5 5 6 7]  

    int n = nums.length;

    //resultant array index :
    int ri =0;
    //result array:
    int[] res = new int[n-k+1];
    //edge case : array is empty 
    if(nums.length == 0 || k>nums.length){
        return new int[0];
    }
    //actual solution:
    //we need a dqueue to maintian the window:
    //dqueue stores the elements in decending order:
        
   Deque<Integer> dq = new ArrayDeque<>();

    for(int i=0;i<n;i++){
        //dqueue adding and checking to maintain the window size:
        
        //1.Any numbers in the deque are getting out of the window:
        while(!dq.isEmpty() && dq.peekFirst() == i-k){
            dq.pollFirst();
        }
        //2. removing smaller elements:
        while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
            //pop it off
            dq.pollLast();
        }
        //we need to add elements to the Deque:
        dq.offer(i);

        //when the window size id reached:
        if(i>= k-1){
            //add the dq to the res[]
            res[ri++] = nums[dq.peekFirst()];
        }
    }
        return res;

    }
}
