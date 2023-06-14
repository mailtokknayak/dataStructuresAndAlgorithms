package leetcode;

import java.util.HashMap;

public class Top100EasyQuestions {

    public int[] twoSum(int[] arr, int target) {

        HashMap<Integer, Integer> map = new HashMap();
        int[] output = new int[0];
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                output = new int[]{i, map.get(arr[i])};
                return output;
            } else {
                map.put(target - arr[i], i);
            }
        }
        return output;
    }

}
