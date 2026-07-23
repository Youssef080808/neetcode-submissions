class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] prefix = new int[len];
        int[] suffix = new int[len];
        int[] output = new int[len];
        int save = 1;
        prefix[0] = 1;
        suffix[len-1] = 1;
        for (int i = 1; i < len; i++){
            prefix[i] = save * nums[i-1];
            save = prefix[i];
        }
        save = 1;
        for (int i = len-2; i >= 0; i--){
            suffix[i] = save * nums[i+1];
            save = suffix[i];
        }
        for (int i = 0; i < len; i++){
            output[i] = prefix[i]*suffix[i];
        }
        return output;
    }
}  
