package Valid_sudoku;

import java.util.HashMap;
import java.util.Map;
/**
 * 思路：
 * 暴力遍历三种情况，使用哈希表看是否重复
 * 注意数组如何遍历，创建的哈希表应放在哪里才能有效记录
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean bl = true;
        for(int i=0;i<9;i++){
            Map<Character,Integer> map1 = new HashMap<>();
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    if(!map1.containsKey(board[i][j])){
                        map1.put(board[i][j],1);
                    }else{
                        bl = false;
                    }
                }
            }
        }
        for(int i=0;i<9;i++){
            Map<Character,Integer> map2 = new HashMap<>();
            for(int j=0;j<9;j++){
                if(board[j][i]!='.'){
                    if(!map2.containsKey(board[j][i])){
                        map2.put(board[j][i],1);
                    }else{
                        bl = false;
                    }
                }
            }
        }
        int left=0;
        int right=2;
        int top=0;
        int bottom=2;
        while(bottom<9){
            Map<Character,Integer> map3 = new HashMap<>();
            if(right>9){
                left = 0;
                right = 2;
                top +=3;
                bottom +=3;
            }else{
                for(int i=left;i<=right;i++){
                    for(int j=top;j<=bottom;j++){
                        if(board[i][j]!='.'){
                            if(!map3.containsKey(board[i][j])){
                                map3.put(board[i][j],1);
                            }else{
                                bl = false;
                            }
                        }
                    }
                }
                left+=3;
                right+=3;
            }
        }
        return bl;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] board = {{'.','.','.','.','5','.','.','1','.'},
                          {'.','4','.','3','.','.','.','.','.'},
                          {'.','.','.','.','.','3','.','.','1'},
                          {'8','.','.','.','.','.','.','2','.'},
                          {'.','.','2','.','7','.','.','.','.'},
                          {'.','1','5','.','.','.','.','.','.'},
                          {'.','.','.','.','.','2','.','.','.'},
                          {'.','2','.','9','.','.','.','.','.'},
                          {'.','.','4','.','.','.','.','.','.'}};
        System.out.println(s.isValidSudoku(board));
    }
}
