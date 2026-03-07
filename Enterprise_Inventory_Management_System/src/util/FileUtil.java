package util;

import entity.Product;
import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件工具类，处理IO流
 * 用文件字符输出流，将数据写入文件和加载文件中的数据
 * 现在写入和文件路径为相对路径，但是需要设置，在IDEA配置运行时工作目录
 * IntelliJ IDEA: Run → Edit Configurations → Working directory 设置为 E:\Java_project\Enterprise_Inventory_Management_System
 * 也就是设置为项目这个目录下，这样相对路径创建的文件才会在项目目录下，而不是在项目文件夹外面
 * 目前只用到了 saveInventory()，还是追加模式，只需要在FileWriter writer = new FileWriter(FILE_PATH, true);加个true即可
 * loadInventory()方法，从指定路径文件中读取数据，目前还没有用到
 * 每次打印好像都需要打印一行内容并换行，好像也可以修改为打印流
 */
public class FileUtil {
    // 保存的文件路径，这个是绝对路径
    private static final String FILE_PATH = "data\\inventory.txt";
    //写入数据到对应路径的文件
    public static void saveInventory(Map<String, Product> ProductMap) throws IOException {
        File file = new File(FILE_PATH);   //创建文件对象
        File parentFile = file.getParentFile();   //获取文件父目录
        if(!parentFile.exists()&&parentFile!=null){   //判断父目录是否存在
            parentFile.mkdirs();    //创建父目录
        }
        FileWriter writer = new FileWriter(FILE_PATH, true);   //创建文件字符输出流
        for(Product product:ProductMap.values()){    //遍历ProductMap中的所有商品对象
            //创建一个字符串，格式为id|name|category|price|quantity
            String line = product.getId()+"|"+product.getName()+"|"+product.getCategory()+"|"+product.getPrice()+"|"+product.getQuantity();
            writer.write(line+"\n");   //把字符串和换行符写入文件中
        }
        writer.close();
    }
    //从指定路径文件中读取数据
    public static Map<String ,Product> loadInventory() throws IOException {
        Map<String,Product> ProductMap = new HashMap<>();  //创建一个HashMap对象，用于存储数据
        File file = new File(FILE_PATH);
        if(!file.exists()){
            return ProductMap; //文件不存在，返回一个空的HashMap对象
        }
        BufferedReader reader = new BufferedReader(new FileReader(file));  //创建一个缓冲字符输入流
        String line;  //读取一行数据
        while((line=reader.readLine())!=null){   //循环读取每一行数据
            String[] parts = line.split("\\|");   //用|分割每一行数据
            if(parts.length==5){   //判断数组长度是否为5
                String id = parts[0];   //获取id
                String name = parts[1];   //获取name
                String category = parts[2];   //获取category
                double price = Double.parseDouble(parts[3]);   //获取price
                int quantity = Integer.parseInt(parts[4]);   //获取quantity
                Product product = new Product(id,name,category,price,quantity);   //创建一个商品对象，综合这些属性
                ProductMap.put(id,product);   //添加到HashMap对象中
            }
        }
        reader.close();   //关闭缓冲字符输入流
        return ProductMap;   //返回生成的，综合每个属性的整体HashMap对象
    }
}
