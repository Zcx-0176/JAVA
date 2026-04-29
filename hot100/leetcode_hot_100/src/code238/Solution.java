package code238;
/*
    除了自身以外数组的乘积
    因为需要O(n)的时间复杂度，并且不能用除法
    所以就不能双重循环，或者先把总乘积乘完再挨个除

    所以可以把这个数组看成一个n*n的矩阵乘积表
    对角线就是当前元素与当前元素的交点
    因为除了自身以外，所以这里被划分为1，我用空格代替
    其他的地方还是那样

    比如 1 2 3 4 5
    乘积矩阵为
       1   2   3   4   6
    1      2   3   4   5
    2  1       3   4   5
    3  1   2       4   5
    4  1   2   3       5
    5  1   2   3   4
    可以清晰的看出这个分为上三角和下三角

    可以先从上到下求出每一行下三角的乘积，放入结果集中
    再从下到上求出每一行上三角的乘积，与对应的结果集中的数据相乘，就是最终的结果

    那么为了O(n)，不可能在求上下三角的时候还用双重循环遍历求出
    可以声明一个变量temp = 1
    先初始化结果集每一个都是1
    比如说从第二行开始，因为第一行第一列就是对角线，结果集不会有任何变化
    temp *= 1，结果集对应索引的结果赋值为temp
    第三行 temp *= 2 ，结果集对应索引的结果赋值为temp
    以此类推，每次temp都累乘对应索引的前一个索引的值
    这样就可以在O(n)内完成

    上三角也是一样的
    先把temp重置为1
    从倒数第二行开始，temp累乘当前索引的后一个索引的值
    然后把下三角的结果集中当前索引的数据乘上temp即可

    最终获得了结果集

 */
import java.util.*;
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for(int i=0;i<n;i++){
            result[i] = 1;
        }
        int temp = 1;
        for(int i=1;i<n;i++){
            temp *= nums[i-1];
            result[i] = temp;
        }
        temp = 1;
        for(int i=n-2;i>=0;i--){
            temp *= nums[i+1];
            result[i] *= temp;
        }
        return result;
    }
}
