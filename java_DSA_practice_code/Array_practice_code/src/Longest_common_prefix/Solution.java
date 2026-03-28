package Longest_common_prefix;
/**
 * 思路：
 * 1. 找到数组中最短的字符串
 * 2. 遍历最短的字符串，判断每个字符在各个字符串中是否都相同
 * 3. 如果相同，则将字符添加到结果中
 * 4. 如果不相同，则已经找到了公共前缀，直接结束循环即可
 * break是为了类似：{"cat","cit"}这种输入，预期结果应为"c"
 * 但如果没写break，则会输出“ct"，这不是最长公共前缀了
 * 注意：
 *     字符串的长度如何获取：strs[i].length()，有括号
 *     如何把字符串换成char数组：strs[i].toCharArray()
 *     如何在字符串中加入新的字符：result += minstrs[i];，result是字符串，+=是字符串的拼接，minstrs[i]是char字符
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        String minstr = strs[0];
        for(int i=1;i<n;i++){
            if(strs[i].length()<minstr.length()){
                minstr = strs[i];
            }
        }
        String result = "";
        int minn = minstr.length();
        char[] minstrs = minstr.toCharArray();
        for(int i=0;i<minn;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                char[] chars = strs[j].toCharArray();
                if(chars[i]==minstrs[i]){
                    count++;
                }
            }
            if(count==n){
                result += minstrs[i];
            }else{
                break;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String[] strs = {"cir","car"};
        Solution s = new Solution();
        System.out.println(s.longestCommonPrefix(strs));
    }
}
