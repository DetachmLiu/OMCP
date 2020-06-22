package dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author hesenbai
 */
public class DatabaseConnection {

    private static final String URL="jdbc:mysql://localhost:3306/register?serverTimezone = GMT%2B8&useSSL=false";

    /**登录名
     *
     */
    private static final String NAME="root";

    /**密码
     *
     */
    private static final String PASSWORD="Hkb20177642.";


    private Connection conn=null;
    public DatabaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn= DriverManager.getConnection(URL, NAME, PASSWORD);
        }catch(Exception e) {
            System.out.println("未能成功加载驱动程序，请检查是否导入驱动程序！");
            e.printStackTrace();
        }
    }
    public Connection getConnection() {
        return this.conn;
    }
    public void close()throws Exception{
        if(this.conn!=null) {
            try {
                this.conn.close();
            }catch(Exception e) {

                e.printStackTrace();
            }
        }
    }
    public Statement createStatement() {

        try {
            return this.conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
