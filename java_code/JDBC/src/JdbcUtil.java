import java.sql.*;

public class JdbcUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_demo?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    //加载驱动
    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    //获取连接
    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(URL,USER,PASSWORD);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    //关闭资源
    public static void  close(ResultSet rs,Statement stmt,Connection conn){
        try{
            if(rs!=null) rs.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        try{
            if(stmt!=null) stmt.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        try{
            if(conn!=null) conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}







