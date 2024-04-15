package LKTest;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: Boot3
 * @description:
 * @author:
 * @create: 2024-01-29 16:00
 **/
public class Test {
    @org.junit.Test
    public void test3() {
        System.out.println("sss");
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int over = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (over == nums[j]) {
                    int[] result = new int[2];
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            List<String> orDefault = map.getOrDefault(key, new ArrayList<>());
            orDefault.add(str);
            map.put(key, orDefault);
        }
        return new ArrayList<>(map.values());
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num - 1, num);
        }
        Arrays.sort(nums);
        HashMap<Integer, Integer> keyMap = new HashMap<>();
        for (int num : nums) {
            Integer i = map.getOrDefault(num, null);
            if (i != null) {
                Integer l = keyMap.getOrDefault(num, 0);
                keyMap.put(i, l + 1);
            }
        }
        if (keyMap.values().size() == 0) {
            return 1;
        } else {
            List<Integer> ids = keyMap.values().stream().sorted().collect(Collectors.toList());
            return ids.get(ids.size() - 1);
        }

    }

    public static void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[] row1 = new boolean[row];
        boolean[] col1 = new boolean[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (0 == matrix[i][j]) {
                    row1[i] = col1[j] = true;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (row1[i] || col1[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int crow = row - 2;
        int ccol = col - 2;
        ArrayList<Integer> list = new ArrayList<>();
        int j = 0;
        int i = 0;
        while (row != crow && col != ccol) {
            for (; i < row - 1; i++) {
                list.add(matrix[i][j]);
            }
            i = row - 1;
        }
        return null;
    }

    public static void main(String[] args) {
/*//        int[] nums = {100, 4, 200, 1, 3, 2};
        int[][] array = {{1, 2, 3}, {4, 5, 6}};
//        moveZeroes(nums);
//        for (int num : nums) {
//            System.out.println(num);
//        }
//        int[][] matrix={}
        setZeroes(array);*/
        int[] nums = {0,0,1,2,1,0,1,3,2,1,2,1};
        int trap = trap(nums);
        System.out.println(trap);

    }

    public static int trap(int[] height) {
        List<Integer> realHeight = new ArrayList<>();
        Integer j=0;
        if (0==height[0]){
            for (int i = 0; i < height.length; i++) {
                int value = height[i];
                if (0 == value) {
                    if ((i+1)<height.length-1){
                        if (0!=height[i+1]){
                            j=i+1;
                            break;
                        }
                    }
                }else {
                    j=null;
                }
            }
        }
        if (null==j){
            return 0;
        }
        if (j>=height.length){
            return 0;
        }

        return j;
    }

}
