package exception;
/**
 * 自定义异常类
 */
public class InventoryException extends Exception{
    public InventoryException(String message){  //构造方法1
        super(message);
    }
    public InventoryException(String message, Throwable cause){  //构造方法2
        super(message, cause);
    }
}
