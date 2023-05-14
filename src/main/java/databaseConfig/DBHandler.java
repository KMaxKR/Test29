package databaseConfig;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DBHandler extends Config{
    Connection dbconnection;
    public Connection getDBConnection() throws SQLException, ClassNotFoundException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        dbconnection = DriverManager.getConnection(connectionString, dbUser, dbPassword);
        return dbconnection;
    }

    public List<Cars> getDbValues() throws SQLException {
        String getValues = "SELECT * FROM " + Const.USER_TABLE;
        PreparedStatement prSt = dbconnection.prepareStatement(getValues);
        ResultSet resultSet = prSt.executeQuery();
        List<Cars> list =  new ArrayList<>();
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String car_name = resultSet.getString(2);
            int hp = resultSet.getInt(3);
            double price = resultSet.getDouble(4);
            list.add(new Cars(id, car_name, hp, price));
        }
        prSt.close();
        return list;
    }

    public void insertIntoDataBase(int id, String car_name, int hp, double price) throws SQLException {
        String insertInto = "INSERT INTO " + Const.USER_TABLE + "("+ Const.ID_DATABASE + ", " + Const.CAR_NAME + ", " + Const.CAR_HP + ", " + Const.CAR_PRICE +") VALUES(?, ?, ?, ?);";
        try {
            PreparedStatement prSt = dbconnection.prepareStatement(insertInto);
            prSt.setInt(1, id);
            prSt.setString(2, car_name);
            prSt.setInt(3, hp);
            prSt.setDouble(4, price);
            prSt.execute();
            prSt.close();
        }catch (Exception e){
            e.getStackTrace();
        }
    }
    public List<Cars> selectWithCondition(String condition) throws SQLException {
        List<Cars> list = new ArrayList<>();
        String query = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + condition;
        PreparedStatement prSt = dbconnection.prepareStatement(query);
        ResultSet resultSet = prSt.executeQuery();
        while(resultSet.next()){
            int id = resultSet.getInt(1);
            String car_name = resultSet.getString(2);
            int hp = resultSet.getInt(3);
            double price = resultSet.getDouble(4);
            list.add(new Cars(id, car_name, hp, price));
        }
        prSt.close();
        return list;
    }

}
