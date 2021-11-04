import java.sql.*;

public class Main {

    private static Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;

    public static void main(String[] args) {

        try {
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/lightbox?user=root&password=&characterEncoding=UTF-8"
                // ▼ PostgreSQL
                // "jdbc:postgresql://localhost:5432/lightbox?user=postgres&password=trustno1&charSet=utf-8;"
            );

            // ステートメント
            stmt = conn.createStatement();
            // SQL 実行
            rs = stmt.executeQuery("select * from 社員マスタ");

            // 一行取り出し
            rs.next();
            System.out.println( rs.getString(2) );
            System.out.println( rs.getString("氏名") );
            // 整数
            int seibetu = rs.getInt("性別");
            if ( seibetu == 0 ) {
                System.out.println("男性");
            }
            else {
                System.out.println("女性");
            }

            // 文字列
            String seibetu2 = String.format("%d", seibetu);
            if ( seibetu2.equals("0") ) {
                System.out.println("男性");
            }
            else {
                System.out.println("女性");
            }

            while( rs.next() ) {
                
                System.out.println(rs.getString("社員コード"));
                System.out.println(rs.getString("氏名"));
                System.out.println(rs.getString("フリガナ"));
                System.out.println(rs.getString("所属"));
                System.out.println(rs.getString("性別"));
                System.out.println(rs.getString("作成日"));
                System.out.println(rs.getString("更新日"));
                System.out.println(rs.getString("給与"));
                System.out.println(rs.getString("手当"));
                System.out.println(rs.getString("管理者"));
                System.out.println(rs.getString("生年月日"));
 
            }            

            rs.close();
            stmt.close();
            conn.close();
            
        }
        catch (Exception e) {
            System.out.println( e.getMessage() );
            e.printStackTrace();
        }

    }

}
