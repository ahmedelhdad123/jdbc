package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try ( Connection connection= DriverManager.getConnection("jdbc:h2:mem:;INIT=RUNSCRIPT FROM 'classpath:users.sql';")){
            System.out.println("connection.isValid(0)= " + connection.isValid(0));

            // CRUD

            // SELECT
            PreparedStatement ps=connection.prepareStatement("select * from USERS where name = ?");
            ps.setString(1,"ahmed");
            ResultSet resultSet= ps.executeQuery();
            while (resultSet.next())
            {
                System.out.println(resultSet.getInt("id")+ " - " + resultSet.getString("name"));
            }
            // INSERT
            PreparedStatement insertPS=connection.prepareStatement("insert into USERS (name) values (?)");
            insertPS.setString(1,"mohamed");
            int insertCount=insertPS.executeUpdate();
            System.out.println("insertCount = " + insertCount);
            // UPDATE
            PreparedStatement updatePS=connection.prepareStatement("update USERS set name=? where name=?");
            updatePS.setString(1,"eslam");
            updatePS.setString(2,"ahmed");
            int updateCount=updatePS.executeUpdate();
            System.out.println("updateCount = " + updateCount);
            // DELETES
            PreparedStatement deletesPS=connection.prepareStatement("delete from USERS where name = ?");
             deletesPS.setString(1,"eslam");
             int deletesCount=deletesPS.executeUpdate();
            System.out.println("deletesCount = " + deletesCount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}