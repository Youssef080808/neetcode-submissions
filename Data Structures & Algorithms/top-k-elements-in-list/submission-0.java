class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer>[] buckets = new List[nums.length+1];
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            int num = entry.getKey();
            int freq = entry.getValue();
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(num);
        }
        int[] arr = new int[k];
        int c = k;
        for (int i = buckets.length-1; i >= 0; i--){
            if (c == 0) break;
            if (buckets[i] == null) buckets[i] = new ArrayList<>();
            for (int j = 0; j < buckets[i].size(); j++){
                if (c==0) break;
                arr[c-1] = buckets[i].get(j);
                c--;
            }
        }
        return arr;
    }
}
