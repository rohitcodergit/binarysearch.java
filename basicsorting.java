public class main {
    public int search(int[] nums, int target) {
        // Find index of minimum element in nums
        int min = findMinIndex(nums);

        // Check if target is in left or right of minimum element
        if (nums[min] <= target && target <= nums[nums.length - 1]) {
            // Search in sorted left portion
            return binarySearch(nums, min, nums.length - 1, target);
        } else {
            // Search in sorted right portion
            return binarySearch(nums, 0, min - 1, target);
        }
    }

    // Binary search to find target in nums from index left to right
    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // Find index of minimum element in nums
    private int findMinIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        main solution = new main();
        int index = solution.search(nums, target);
        if (index != -1) {
            System.out.println("Found " + target + " at index " + index);
        } else {
            System.out.println("Target not found");
        }
    }

}


\
