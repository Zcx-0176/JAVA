package code146;
/*
    简单LRU实现

    注意！！！！！！！！！！！
    LRU实现就用双向链表+哈希表数据结构
    即
    LinkedHashMap

    我们要做LRU缓存，
    即快速查(O (1) 时间 get)
    快速增 / 改（O (1) 时间 put）
    快速删最久没用的（O (1) 时间淘汰数据）

    hashmap每次插入删除和修改都是O(1)
    双向链表记录使用顺序，头部是最近使用，尾部是最久未使用

    哈希表通过key直接找到当前链表节点
    因为是双向链表，存储了当前节点的左右指针
    直接就可以断开
    然后指针重新赋值，把当前节点移动到链表头
    哈希表和链表移动都是O (1)

    为什么可以这样操作
    这个数据结构内部存的是这样
    prev ｜ key ｜ value ｜ next
    即哈希表的键值是key = prev ｜ key ｜ value ｜ next
    每次根据key，直接找到链表的左右指针和key和value
    然后根据左右指针断开这个节点，直接重构头节点

    首先继承双向链表父类
    调用父类构造方法，三个参数
    容量，负载因子，是否按照访问顺序排序

    get方法
    调用父类的getOrDefault方法
    找不到key返回-1，找到key自动把这个key移动到链表头部

    put方法
    调用父类的put方法
    新数据：插入+移动到头部
    旧数据：更新+移动到头部
    插入后自动触发下面的removeEldestEntry 判断

    需要重写父类的removeEldestEntry方法
    这个数据结构自动在每次put后调用这个方法
    当内部元素个数大于容量时
    返回true
    开始删除最老数据

 */
import java.util.*;
public class LRUCache extends LinkedHashMap<Integer,Integer>{
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity,0.75f,true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
        super.put(key,value);
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
        return size()>capacity;
    }
}
