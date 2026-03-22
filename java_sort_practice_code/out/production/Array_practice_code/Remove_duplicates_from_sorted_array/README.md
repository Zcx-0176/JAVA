# 删除有序数组中的重复项

## 题目描述

给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。

考虑 nums 的唯一元素的数量为 k。去重后，返回唯一元素的数量 k。

nums 的前 k 个元素应包含 排序后 的唯一数字。下标 k - 1 之后的剩余元素可以忽略。

### 判题标准:

系统会用下面的代码来测试你的题解:
```
int[] nums = [...]; // 输入数组
int[] expectedNums = [...]; // 长度正确的期望答案

int k = removeDuplicates(nums); // 调用

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
assert nums[i] == expectedNums[i];
}
如果所有断言都通过，那么您的题解将被 通过。
```


示例 1：
```
输入：nums = [1,1,2]
输出：2, nums = [1,2,_]
解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
```
示例 2：
```
输入：nums = [0,0,1,1,1,2,2,3,3,4]
输出：5, nums = [0,1,2,3,4,_,_,_,_,_]
解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
```

提示：
```
1 <= nums.length <= 3 * 104
-100 <= nums[i] <= 100
nums 已按 非递减 顺序排列。
```
## 解题思路

### 方法一：双指针法（快慢指针）- Solution2.java

**核心思想：**
使用快慢两个指针，快指针遍历整个数组，慢指针指向下一个不重复元素应该放置的位置。

**算法步骤：**
1. 初始化 `fast = 1`, `slow = 1`
2. 快指针遍历数组：
   - 如果 `nums[fast] == nums[fast-1]`，说明是重复元素，快指针继续前进
   - 否则，将 `nums[fast]` 赋值给 `nums[slow]`，然后两个指针都向前移动
3. 返回 `slow`，即为去重后的数组长度

**时间复杂度：** O(n)  
**空间复杂度：** O(1)

**代码实现：**
```
java
public int removeDuplicates(int[] nums) {
int n = nums.length;
if(n == 1) {
return 1;
}
int fast = 1;
int slow = 1;
while(fast < n) {
if(nums[fast] == nums[fast-1]) {
fast++;
continue;
} else {
nums[slow] = nums[fast];
fast++;
slow++;
}
}
return slow;
}
```
### 方法二：左右指针 + 排序法 - Solution.java

**核心思想：**
使用左右两个指针从两端向中间遍历，收集不重复的元素到临时列表，最后排序并复制回原数组。

**算法步骤：**
1. 初始化 `left = 0`, `right = n-1`
2. 使用 ArrayList 存储结果
3. 左右指针向中间移动：
   - 如果左指针遇到重复元素，左指针右移
   - 如果右指针遇到重复元素，右指针左移
   - 否则将两端元素加入结果集
4. 处理中间剩余元素
5. 对结果排序并复制回原数组
6. 返回新数组长度

**时间复杂度：** O(n log n) - 因为需要排序  
**空间复杂度：** O(n) - 需要额外的 ArrayList 存储

**代码实现：**
```
java
public int removeDuplicates(int[] nums) {
int n = nums.length;
ArrayList<Integer> result = new ArrayList<>();
int left = 0;
int right = n - 1;
if(n == 1) {
return 1;
}
while(left < right) {
if(left < n-1 && nums[left] == nums[left+1]) {
left++;
continue;
} else if(right >= 0 && nums[right] == nums[right-1]) {
right--;
continue;
}
result.add(nums[left]);
result.add(nums[right]);
left++;
right--;
}
if(left == right) {
result.add(nums[left]);
}
int newsize = result.size();
int[] newnums = new int[newsize];
for(int i = 0; i < newsize; i++) {
newnums[i] = result.get(i);
}
Arrays.sort(newnums);
for(int i = 0; i < newsize; i++) {
nums[i] = newnums[i];
}
return newsize;
}
```
## 两种方法对比

| 特性 | 方法一（快慢指针） | 方法二（左右指针 + 排序） |
|------|------------------|------------------------|
| 时间复杂度 | O(n) | O(n log n) |
| 空间复杂度 | O(1) | O(n) |
| 是否原地修改 | 是 | 否（需要额外空间） |
| 代码简洁度 | 简洁 | 较复杂 |
| 推荐程度 | ⭐⭐⭐⭐⭐ | ⭐⭐ |

**总结：** 方法一（快慢指针）是最优解，时间复杂度和空间复杂度都更优，且符合题目"原地"修改的要求。
```
