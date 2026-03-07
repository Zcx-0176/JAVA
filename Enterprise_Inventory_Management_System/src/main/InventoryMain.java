package main;

import entity.Product;
import manager.InventoryManager;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class InventoryMain {
    private static Scanner sc = new Scanner(System.in);  //输入对象
    private static InventoryManager manager = InventoryManager.instance;  // 单例模式，获取管理类对象
    public static void main(String[] args) throws Exception {
        System.out.println("欢迎使用库存管理系统");
        System.out.println("1.添加商品");
        System.out.println("2.更新商品");
        System.out.println("3.删除商品");
        System.out.println("4.查询商品");
        System.out.println("5.查询所有商品");
        System.out.println("6.查询操作日志");
        System.out.println("7.库存统计");
        System.out.println("8.入库");
        System.out.println("9.出库");
        System.out.println("10.退出");
        while(true){
            System.out.print("请选择操作：");
            System.out.println();
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    getProduct();
                    break;
                case 5:
                    getAllProducts();
                    break;
                case 6:
                    getOperationlogs();
                    break;
                case 7:
                    getInventoryStatistics();
                    break;
                case 8:
                    addInventory();
                    break;
                case 9:
                    removeInventory();
                    break;
                case 10:
                    System.out.println("退出系统");
                    return;
                default:
                    System.out.println("无效的选择，请重新选择");
                    break;
            }
        }
    }
    private static void addProduct() throws Exception {
        System.out.println("请输入商品ID：");
        String id = sc.next();
        System.out.println("请输入商品名称：");
        String name = sc.next();
        System.out.println("请输入商品类别：");
        String category = sc.next();
        System.out.println("请输入商品价格：");
        double price = sc.nextDouble();
        System.out.println("请输入商品数量：");
        int quantity = sc.nextInt();
        Product product = new Product(id,name,category,price,quantity);
        manager.addProduct(product);
    }
    private static void updateProduct() throws Exception {
        System.out.println("请输入要更新的商品ID：");
        String id = sc.next();
        Product product = manager.getProduct(id);
        if(product==null){
            System.out.println("该商品不存在");
            return;
        }
        System.out.println("请输入新的商品名称：");
        String name = sc.next();
        System.out.println("请输入新的商品类别：");
        String category = sc.next();
        System.out.println("请输入新的商品价格：");
        double price = sc.nextDouble();
        System.out.println("请输入新的商品数量：");
        int quantity = sc.nextInt();
        Product newproduct = new Product(id,name,category,price,quantity);
        manager.updateProduct(id,product,newproduct);
    }
    private static void deleteProduct() throws Exception {
        System.out.println("请输入要删除的商品ID：");
        String id = sc.next();
        manager.deleteProduct(id);
    }
    private static void getProduct() throws Exception {
        System.out.println("请输入要查询的商品ID：");
        String id = sc.next();
        Product product = manager.getProduct(id);
        if(product==null){
            System.out.println("该商品不存在");
            return;
        }
        System.out.println("商品ID："+product.getId());
        System.out.println("商品名称："+product.getName());
        System.out.println("商品类别："+product.getCategory());
        System.out.println("商品价格："+product.getPrice());
        System.out.println("商品数量："+product.getQuantity());
    }
    private static void getAllProducts() throws Exception {
        List<Product> products = manager.getAllProducts();
        for(Product product:products){
            System.out.println("商品ID："+product.getId());
            System.out.println("商品名称："+product.getName());
            System.out.println("商品类别："+product.getCategory());
            System.out.println("商品价格："+product.getPrice());
            System.out.println("商品数量："+product.getQuantity());
        }
    }
    private static void getOperationlogs() throws Exception {
        List<String> logs = manager.getOperationlogs();
        for(String log:logs){
            System.out.println(log);
        }
    }
    private static void getInventoryStatistics() throws Exception {
        Map<String ,Object> statistics = manager.getInventoryStatistics();
        System.out.println("商品种类数："+statistics.get("商品种类数："));
        System.out.println("商品总数量："+statistics.get("商品总数量："));
        System.out.println("商品总价格："+statistics.get("商品总价格："));
        System.out.println("商品品类数："+statistics.get("商品品类数："));
    }
    private static void addInventory() throws Exception {
        System.out.println("请输入要入库的商品ID：");
        String id = sc.next();
        System.out.println("请输入入库数量：");
        int quantity = sc.nextInt();
        manager.addInventory(id,quantity);
    }
    private static void removeInventory() throws Exception {
        System.out.println("请输入要出库的商品ID：");
        String id = sc.next();
        System.out.println("请输入出库数量：");
        int quantity = sc.nextInt();
        manager.removeInventory(id,quantity);
    }
}
