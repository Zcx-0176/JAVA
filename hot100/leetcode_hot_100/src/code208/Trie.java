package code208;
/*
    实现前缀树的构造，新增，查询，查询前缀
    如何构建树
    比如一个小写字母组成的字符串
    其实就是树的每一层从根节点往下存储每一个字符
    也就是说从树的根节点开始
    一开始根节点是26个位置，数据类型是Trie，一开始全为null
    获取第一个字符，转为对应索引，在根节点对应索引处创建新的Trie对象，有了对象就不为null了
    这个对象同样有26个位置，每个位置的数据类型还是Trie
    这就获取第二个字符，在第二层上对应索引出创建新的Trie对象

    依次类推

    所以说每次创建Trie对象都是调用构造函数
    所以说构造函数内应该new一个以Trie为数据类型的26长度的数组
    也就是说Trie的私有成员变量应有一个Trie类型的数组

    当然每一个Trie对象都要有一个isEnd值判断当前节点是否是传入的单词结尾
    比如传入了app  和apple两个单词
    如果要查询是否传入了app，那如果没有isEnd标识，我就没法判断是否传入
    只能是认为app是apple前缀但没有传入

    插入方法中
    用for循环，获取每一个字符
    从根节点往下开始找字符对应的索引是否为空
    所以树的层数是移动的，每次都要新的层找其新创建的children数组的对应索引是否为空
    故声明一个Trie对象
    这个对象的私有成员就是children数组和isEnd
    即树上的一层节点和isEnd
    所以就可以从根节点往下移动，在这一层节点找对应的索引是否为空

    查找是否传入单词
    还是依照以前的流程
    声明Trie对象，获取索引，声明一个布尔值为true，开始for循环
    如果当前对象的对应索引为null，证明没传入，布尔值置为false，直接退出循环
    否则对象 = 对象的索引处的对象，就是接着往下找
    找到单词的n完事后
    如果最后的这个位置的isEnd为false，证明没有传入这个单词
    同样把布尔值置为false
    return 布尔值

    查找是否有这个前缀
    就是比传入单词少一步，不需要判断最后对象的isEnd值
 */

import java.util.*;

class Trie {
    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie current = this;
        int n = word.length();
        for(int i=0;i<n;i++){
            int index = word.charAt(i)-'a';
            if(current.children[index]==null){
                current.children[index] = new Trie();
            }
            current = current.children[index];
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        Trie current = this;
        boolean isSearch = true;
        int n = word.length();
        for(int i=0;i<n;i++){
            int index = word.charAt(i)-'a';
            if(current.children[index]==null){
                isSearch = false;
                break;
            }
            current = current.children[index];
        }
        if(!current.isEnd){
            isSearch = false;
        }
        return isSearch;
    }

    public boolean startsWith(String prefix) {
        Trie current = this;
        boolean isSearch = true;
        int n = prefix.length();
        for(int i=0;i<n;i++){
            int index = prefix.charAt(i)-'a';
            if(current.children[index]==null){
                isSearch = false;
                break;
            }
            current = current.children[index];
        }

        return isSearch;
    }
}
