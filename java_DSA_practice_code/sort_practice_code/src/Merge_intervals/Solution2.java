package Merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public int[][] merge(int[][] intervals) {
        // 先将区间按照左区间排序
        Arrays.sort(intervals, (arr1, arr2) -> arr1[0] - arr2[0]);
        int len = intervals.length;
        List<int[]> ans = new ArrayList<>();
        int leftLimit = intervals[0][0];
        int rightLimit = intervals[0][1];
        for (int i = 1; i < len; i++) {
            int nextLeft = intervals[i][0];
            int nextRight = intervals[i][1];
            // 说明可以合并
            if (nextLeft <= rightLimit) {
                rightLimit = Math.max(rightLimit, nextRight);
            } else {
                // 说明无法合并，确定了区间
                ans.add(new int[]{leftLimit, rightLimit});
                leftLimit = nextLeft;
                rightLimit = nextRight;
            }
        }
        // 处理结束后，将剩余还没放入的区间放入结果中，兼容原数组长度为1的情况
        ans.add(new int[]{leftLimit, rightLimit});
        return ans.toArray(new int[ans.size()][]);
    }
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        Solution2 s = new Solution2();
        int[][] result = s.merge(intervals);
        System.out.println( Arrays.deepToString(result));
    }
}
