import java.util.concurrent.*;

class Solution {
    public int search(int[] nums, int target) {
        int res = -1;
        int n = nums.length;
        int i = 0, j = n - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else{
                i = mid + 1;
            }
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(() -> {
            Solution solution = new Solution();
            int[] nums = {-1, 0, 3, 5, 9, 12};
            int target = 2;
            return solution.search(nums, target);
        });
        
        try {
            Integer result = future.get(1, TimeUnit.SECONDS);
            System.out.println(result);
        } catch (TimeoutException e) {
            System.out.println("执行超时（1秒）");
            future.cancel(true);
        } catch (Exception e) {
            System.out.println("执行出错: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }
}
