class Solution {
    public int removeElement(int[] nums, int val) {
        // 双指针
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (val != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 3};
        int val = 5;
        System.out.println(solution.removeElement(nums, val));
    }
}
