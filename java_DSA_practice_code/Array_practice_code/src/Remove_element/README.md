# 移除元素
## 题目描述
给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。

假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作：

更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。nums 的其余元素和 nums 的大小并不重要。
返回 k。
用户评测：

评测机将使用以下代码测试您的解决方案：
```
int[] nums = [...]; // 输入数组
int val = ...; // 要移除的值
int[] expectedNums = [...]; // 长度正确的预期答案。
// 它以不等于 val 的值排序。

int k = removeElement(nums, val); // 调用你的实现

assert k == expectedNums.length;
sort(nums, 0, k); // 排序 nums 的前 k 个元素
for (int i = 0; i < actualLength; i++) {
assert nums[i] == expectedNums[i];
}
如果所有的断言都通过，你的解决方案将会 通过。
```


示例 1：
```
输入：nums = [3,2,2,3], val = 3
输出：2, nums = [2,2,_,_]
解释：你的函数应该返回 k = 2, 并且 nums 中的前两个元素均为 2。
你在返回的 k 个元素之外留下了什么并不重要（因此它们并不计入评测）。
```
示例 2：
```
输入：nums = [0,1,2,2,3,0,4,2], val = 2
输出：5, nums = [0,1,4,0,3,_,_,_]
解释：你的函数应该返回 k = 5，并且 nums 中的前五个元素为 0,0,1,3,4。
注意这五个元素可以任意顺序返回。
你在返回的 k 个元素之外留下了什么并不重要（因此它们并不计入评测）。
```

提示：
```
0 <= nums.length <= 100
0 <= nums[i] <= 50
0 <= val <= 100
 ```
## 解题思路

### 方法一：双指针法（快慢指针）- 推荐(Solution2)

**核心思想：**
使用快慢两个指针，快指针遍历整个数组，慢指针指向下一个不等于 val 的元素应该放置的位置。

**算法步骤：**
1. 初始化 `slow = 0`, `fast = 0`
2. 快指针遍历数组：
   - 如果 `nums[fast] != val`，说明该元素需要保留，将其赋值给 `nums[slow]`，然后 `slow++`
   - 如果 `nums[fast] == val`，说明该元素需要移除，跳过
3. 返回 `slow`，即为新数组的长度

**时间复杂度：** O(n)  
**空间复杂度：** O(1) - 原地修改

**代码实现：**
```
java
public int removeElement(int[] nums, int val) {
int slow = 0;
for (int fast = 0; fast < nums.length; fast++) {
if (nums[fast] != val) {
nums[slow] = nums[fast];
slow++;
}
}
return slow;
}
```
### 方法二：ArrayList 辅助法 - Solution.java (Solution)

**核心思想：**
使用 ArrayList 临时存储不等于 val 的元素，然后再复制回原数组。

**算法步骤：**
1. 创建 ArrayList 用于存储结果
2. 遍历数组：
   - 如果 `nums[i] != val`，加入 ArrayList
   - 否则跳过
3. 将 ArrayList 中的元素复制回原数组的前 k 个位置
4. 返回 ArrayList 的大小

**时间复杂度：** O(n)  
**空间复杂度：** O(n) - 需要额外的 ArrayList

**代码实现：**
```
java
public int removeElement(int[] nums, int val) {
int n = nums.length;
ArrayList<Integer> result = new ArrayList<>();
int i = 0;
while(i < n) {
if(nums[i] != val) {
result.add(nums[i]);
i++;
} else {
i++;
}
}
int size = result.size();
for(int j = 0; j < size; j++) {
nums[j] = result.get(j);
}
return size;
}
```
## 两种方法对比

| 特性 | 方法一（双指针） | 方法二（ArrayList） |
|------|----------------|-------------------|
| 时间复杂度 | O(n) | O(n) |
| 空间复杂度 | O(1) | O(n) |
| 是否原地修改 | 是 | 否（需要额外空间） |
| 代码简洁度 | 简洁 | 较简单 |
| 推荐程度 | ⭐⭐⭐⭐⭐ | ⭐⭐⭐ |

## 进阶优化：双向指针法

**核心思想：**
如果要移除的元素在数组末尾较少出现，可以使用双向指针优化，将等于 val 的元素与数组末尾元素交换。

**算法步骤：**
1. 初始化 `left = 0`, `right = n-1`
2. 当 `left <= right` 时：
   - 如果 `nums[left] == val`，将 `nums[right]` 赋值给 `nums[left]`，`right--`
   - 否则 `left++`
3. 返回 `left`

**优点：** 避免了不必要的元素移动，适合 val 在数组末尾较少的情况。

**总结：** 推荐使用双指针法（方法一），既满足原地修改要求，代码也最简洁优雅。
```
