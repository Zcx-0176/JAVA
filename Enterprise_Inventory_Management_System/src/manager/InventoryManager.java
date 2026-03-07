package manager;

import entity.Product;
import exception.InventoryException;

import java.io.IOException;
import java.util.*;

import static util.FileUtil.saveInventory;

/**
 * 库存管理类
 * 要求是单例模式，定义懒汉式单例对象，并私有化构造器
 *这里面的方法实现，都是以Product整体考虑
 * 而主函数内的方法，都是要挨个输入Product的每个属性，然后综合成一个Product对象
 * 再调用InventoryManager类中的方法，完成对商品信息的各种操作
 * 然后再被作为参数，传入到ProductMap数据结构中去存储
 * 跟文件IO操作有关的方法，都是以ProductMap为整体进行操作
 * 文件IO流方法封装在FileUtil类中
 */
public class InventoryManager {
    //构建懒汉式单例对象，用final修饰，避免被修改
    public static final InventoryManager instance = new InventoryManager();
    private Map<String, Product> ProductMap; //存储商品信息，key为商品id
    private List<String> Operationlogs;  //存储操作日志
    private InventoryManager(){  //私有化构造器
        ProductMap = new HashMap<>(); //哈希表，//无序、不可重复、无索引，多态
        Operationlogs = new ArrayList<>();  //列表，有序、可重复、有索引，多态
    }
    //添加商品
    public void addProduct(Product product) throws InventoryException, IOException {
        //判断商品id是否已存在，应用了HashMap数据结构的containsKey(Object key)方法，取得键值
        if(ProductMap.containsKey(product.getId())){
            throw new InventoryException("商品已存在，ID为：" + product.getId());
        }
        ProductMap.put(product.getId(),product);  //把商品对象，添加到ProductMap中去
        Operationlogs.add("添加商品："+product.getName()+" ID："+product.getId());  //添加活动日志信息
        saveInventory(ProductMap);   //把ProductMap数据结构中的数据写入文件
    }
    //更新商品
    public void updateProduct(String id,Product product,Product newproduct) throws InventoryException, IOException {
        if(!ProductMap.containsKey(id)){
            throw new InventoryException("该商品不存在，无法更新");
        }
        ProductMap.remove(id,product);     //先移除旧id的商品对象
        ProductMap.put(id,newproduct);     //再添加同样的id的新商品对象
        Operationlogs.add("更新商品："+product.getName()+" ID："+product.getId());  //添加活动日志信息
        saveInventory(ProductMap);   //把ProductMap数据结构中的数据写入文件
    }
    //删除商品
    public void deleteProduct(String id) throws InventoryException, IOException {
        if(!ProductMap.containsKey(id)){
            throw new InventoryException("该商品不存在，无法删除");
        }
        ProductMap.remove(id);   //移除指定id的商品对象
        Operationlogs.add("删除商品："+ProductMap.get(id).getName()+" ID："+id);  //添加活动日志信息
        saveInventory(ProductMap);  //把ProductMap数据结构中的数据写入文件
    }
    //查询商品
    public Product getProduct(String id) throws InventoryException {
        if(!ProductMap.containsKey(id)){
            throw new InventoryException("该商品不存在");
        }
        return ProductMap.get(id); //获取指定id的商品对象
    }
    //查询所有商品
    public List<Product> getAllProducts(){
        return new ArrayList<>(ProductMap.values()); //创建一个新列表，将ProductMap的所有值复制到新列表中
    }   //Map集合的values()方法，返回一个Collection对象，包含Map集合中的所有值
    //查询操作日志
    public List<String> getOperationlogs(){

        return new ArrayList<>(Operationlogs);   //创建一个新列表，将Operationlogs复制到新列表中
    }
    //库存统计，统计商品总数量、总价格、商品种类数，商品品类数
    public Map<String ,Object> getInventoryStatistics(){
        Map<String,Object> statistics = new HashMap<>();  //创建一个HashMap集合statistics，用来存储统计结果,参数一是String，参数二是Object对象
        int totalQuantity = 0;
        double totalPrice = 0;
        int categoryCount = 0;
        Set<String> categories = new HashSet<>();   //创建一个HashSet集合categories，参数是String
        for(Product product:ProductMap.values()){   //遍历ProductMap中的所有商品对象
            totalQuantity += product.getQuantity();
            totalPrice += product.getTotalPrice();
            categories.add(product.getCategory());   //用来存储商品品类，重复的品类不会被添加
        }
        statistics.put("商品种类数：",ProductMap.size());   //有两个参数，第一个参数是String，第二个参数是Object对象
        statistics.put("商品总数量：",totalQuantity);
        statistics.put("商品总价格：",totalPrice);
        statistics.put("商品品类数：",categories.size());
        return statistics;
    }
    //入库操作
    public void addInventory(String id,int quantity) throws InventoryException, IOException {
        Product product = getProduct(id);  //调用了本类中查询商品的方法，返回商品对象
        if(product==null){
            throw new InventoryException("该商品不存在，无法进行入库操作");
        }
        if(quantity<=0){
            throw new InventoryException("入库数量不应小于等于0");
        }
        product.setQuantity(product.getQuantity()+quantity);   //调用了Product类中的setQuantity()方法，设置商品数量
        Operationlogs.add("入库商品ID："+id+" 入库了："+quantity+"件");  //添加活动日志信息
        saveInventory(ProductMap);  //把ProductMap数据结构中的数据写入文件
    }
    //出库操作
    public void removeInventory(String id,int quantity) throws InventoryException, IOException {
        Product product = getProduct(id);  //调用了本类中查询商品的方法，返回商品对象
        if(product==null){
            throw new InventoryException("该商品不存在，无法进行出库操作");
        }
        if(quantity<=0){
            throw new InventoryException("出库数量不应小于等于0");
        }
        if(product.getQuantity()<quantity){
            throw new InventoryException("该商品库存不足，无法进行出库操作，当前库存："+product.getQuantity());
        }
        product.setQuantity(product.getQuantity()-quantity);  //调用了Product类中的setQuantity()方法，设置商品数量
        Operationlogs.add("出库商品ID："+id+" 出库了："+quantity+"件");  //添加活动日志信息
        saveInventory(ProductMap);  //把ProductMap数据结构中的数据写入文件
    }
}
