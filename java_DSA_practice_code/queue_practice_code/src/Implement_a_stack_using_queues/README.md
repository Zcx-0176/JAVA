# 用两个队列实现栈

## 题目描述

请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（`push`、`top`、`pop` 和 `empty`）。

## 要求

实现 `MyStack` 类：

- `void push(int x)` - 将元素 x 压入栈顶。
- `int pop()` - 移除并返回栈顶元素。
- `int top()` - 返回栈顶元素。
- `boolean empty()` - 如果栈是空的，返回 `true`；否则，返回 `false`。

## 注意事项

1. 你只能使用队列的标准操作 —— 也就是 `push to back`、`peek/pop from front`、`size` 和 `is empty` 这些操作。
2. 你所使用的语言也许不支持队列。你可以使用 `list`（列表）或者 `deque`（双端队列）来模拟一个队列，只要是标准的队列操作即可。

## 示例

**输入：**
```
json
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
```
**输出：**
```
json
[null, null, null, 2, 2, false]
```
**解释：**
```
java
MyStack myStack = new MyStack();
myStack.push(1);
myStack.push(2);
myStack.top();    // 返回 2
myStack.pop();    // 返回 2
myStack.empty();  // 返回 false
```
## 提示

- `1 <= x <= 9`
- 最多调用 `100` 次 `push`、`pop`、`top` 和 `empty`
- 每次调用 `pop` 和 `top` 都保证栈不为空

## 进阶

你能否仅用一个队列来实现栈？

## 解题思路

### 方法一：双队列实现

使用两个队列，通过倒换元素来实现栈的 LIFO 特性。

### 方法二：单队列实现（进阶）

使用一个队列，在每次 `push` 操作后将前面的所有元素依次重新入队，使新元素位于队首。

## 复杂度分析

- **时间复杂度：**
  - `push`: O(n)
  - `pop`: O(1)
  - `top`: O(1)
  - `empty`: O(1)

- **空间复杂度：** O(n)

## 相关题目

- LeetCode 225. Implement Stack using Queues
```
