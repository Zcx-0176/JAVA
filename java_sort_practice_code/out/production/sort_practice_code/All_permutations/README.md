## 全排列
给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。

示例 1：

输入：nums = [1,1,2]
输出：
[[1,1,2],
[1,2,1],
[2,1,1]]
示例 2：

输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]


提示：

1 <= nums.length <= 8
-10 <= nums[i] <= 10

## 解题思路

本题使用**回溯算法 + 剪枝去重**来解决全排列问题：

### 核心思想

1. **回溯框架**：通过递归遍历所有可能的排列组合
2. **状态标记**：使用 `used` 数组记录每个元素是否已被使用
3. **剪枝去重**：对重复元素进行剪枝，避免生成重复排列

### 关键步骤

1. **排序预处理**：先对数组排序，使相同元素相邻，便于去重判断
2. **选择与回溯**：
   - 每次选择一个未使用的元素加入当前排列
   - 递归进入下一层
   - 回溯时撤销选择，尝试其他可能
3. **去重逻辑**：当 `nums[j] == nums[j-1]` 且前一个元素未被使用时，跳过当前元素

### 终止条件

当排列长度等于原数组长度时，说明找到了一个完整排列，加入结果集。

## 代码实现

```
java
package All_permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
public List<List<Integer>> allpermutations(int[] nums) {
List<List<Integer>> result = new ArrayList<>();
Arrays.sort(nums); // 排序，为去重做准备
int n = nums.length;

        for(int i = 0; i < n; i++){
            // 跳过重复的起始元素
            if(i < n-1 && nums[i] == nums[i+1]) {
                continue;
            }
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[i]);
            boolean[] used = new boolean[n];
            used[i] = true;
            permutation(nums, temp, used, result);
        }
        return result;
    }
    
    public void permutation(int[] nums, List<Integer> temp, boolean[] used, List<List<Integer>> result){
        // 终止条件：排列已完成
        if(temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for(int j = 0; j < nums.length; j++){
            // 跳过已使用的元素
            if(used[j]){
                continue;
            }
            // 去重剪枝：同一层不使用重复元素
            if(j > 0 && nums[j] == nums[j-1] && !used[j-1]){
                continue;
            }
            
            // 做选择
            temp.add(nums[j]);
            used[j] = true;
            // 递归
            permutation(nums, temp, used, result);
            // 撤销选择（回溯）
            used[j] = false;
            temp.remove(temp.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> result = s.allpermutations(nums);
        System.out.println(result);
    }
}
```
## 复杂度分析

- **时间复杂度**：O(n × n!)
  - 最坏情况下有 n! 个排列，每个排列需要 O(n) 的时间复制到结果集
  
- **空间复杂度**：O(n)
  - 递归栈深度为 O(n)
  - `used` 数组占用 O(n)
  - 临时列表 `temp` 占用 O(n)

## 测试用例

```
java
// 测试 1：无重复元素
输入：[1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

// 测试 2：包含重复元素
输入：[1,1,2]
输出：[[1,1,2],[1,2,1],[2,1,1]]

// 测试 3：单个元素
输入：[1]
输出：[[1]]

// 测试 4：全部重复
输入：[1,1,1]
输出：[[1,1,1]]
```
## 注意事项

1. **必须先排序**：确保相同元素相邻，才能正确去重
2. **区分树层与树枝**：
   - `!used[j-1]` 表示同一树层（横向）的去重
   - `used[j-1]` 表示同一树枝（纵向）可以使用重复元素
3. **回溯三要素**：
   - 做选择
   - 递归
   - 撤销选择
```
