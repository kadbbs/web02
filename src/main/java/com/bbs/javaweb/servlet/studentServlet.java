package com.bbs.javaweb.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class studentServlet extends k {

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {


        //设置响应的内容类型
        servletResponse.setContentType("text/html;charset=UTF-8");
        PrintWriter out =servletResponse.getWriter();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String url="jdbc:mysql://152.136.245.231:3306/mybatis?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user= "root";
        String password="hkk85n5z";

        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            conn= DriverManager.getConnection(url,user,password);

            //获取预编译
            String sql = "select id,name,birth from student";
            ps =conn.prepareStatement(sql);
            //执行sql
            rs = ps.executeQuery();
            //处理结果集
            while (rs.next()){

                String id=rs.getString("id");
                String name=rs.getString("name");
                String birth=rs.getString("birth");
                out.print("id:"+id+"  name:"+name+"  birth:"+birth+"<br>");
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //释放资源
            if(rs !=null){
                try {
                    rs.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
