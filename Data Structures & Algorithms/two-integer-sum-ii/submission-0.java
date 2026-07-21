class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int p1 = 0;
        int p2 = len-1;
        for (int i = 0; i < len; i++){
            int sum = numbers[p1] + numbers[p2];
            if (sum == target) return new int[]{p1+1, p2+1};
            if (sum > target) {
                p2--;
            } else {
                p1++;
            }
        }
        return null;
    }
}
