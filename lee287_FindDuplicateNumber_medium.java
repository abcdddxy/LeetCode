import java.util.HashSet;
import java.util.Set;

public class lee287_FindDuplicateNumber_medium {
    // Set
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (!set.add(n)) return n;
        }
        return 0;
    }

    //暴力搜索
    public int findDuplicate2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[i]) return nums[j];
            }
        }
        return 0;
    }

    // 链表环路判断
    public int findDuplicate3(int[] nums) {
        int tor = nums[0], hare = nums[0];
        do {
            tor = nums[tor];
            hare = nums[nums[hare]];
        } while (tor != hare);
        System.out.println(tor + " " + hare);
        int ptr1 = nums[0];
        int ptr2 = tor;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        return ptr1;
    }
}
