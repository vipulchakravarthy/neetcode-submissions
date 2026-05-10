class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // counting sort
        ArrayList<Integer>[] freq = new ArrayList[nums.length+1];
        for(int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;
        for(int i = freq.length - 1; i > 0 && index < k; i--) {
            for(int num: freq[i]) {
                res[index++] = num;
                if(index == k) {
                    return res;
                }
            }
        }
        return res;
    }
}
