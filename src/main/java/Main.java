import databaseConfig.Const;
import databaseConfig.DBHandler;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DBHandler db = new DBHandler();

        System.out.println(db.getDBConnection());
        db.insertIntoDataBase(3,"BMW", 231, 17899.69);
        System.out.println(db.getDbValues());
        System.out.println(db.selectWithCondition("id > 1"));
        System.out.println(db.selectWithCondition("car_name = 'BMW'"));
        System.out.println(db.selectWithCondition("car_name LIKE 'T%'"));
    }
}
