package malov.serg;

import java.sql.*;

/**
 * Created by Admin on 26.03.2017.
 */
public class Apartments {

    static Connection connection;
    static double price;
    static double area;
    static double number_rooms;



    public static void viewApartments(double area_price_numbers_of_rooms, String x)throws SQLException {

        String s = String.format("SELECT * FROM Apartment WHERE %s ?", x);
        PreparedStatement ps = connection.prepareStatement(s);
        try {
            ps.setDouble(1,area_price_numbers_of_rooms);


            ResultSet rs = ps.executeQuery();
            try {
                // can be used to get information about the types and properties of the columns in a ResultSet object
                ResultSetMetaData md = rs.getMetaData();

                for (int i = 1; i <= md.getColumnCount(); i++)
                    System.out.print(md.getColumnName(i) + "\t\t\t");
                System.out.println();

                while (rs.next()) {
                    for (int i = 1; i <= md.getColumnCount(); i++) {
                        System.out.print(rs.getString(i) + "\t\t\t");
                    }
                    System.out.println();
                }
            } finally {
                rs.close(); // rs can't be null according to the docs
            }
        } finally {
            ps.close();
        }
    }


    public static double getArea() {
        return area;
    }

    public static void setArea(double area) {
        Apartments.area = area;
    }

    public static double getNumber_rooms() {
        return number_rooms;
    }

    public static void setNumber_rooms(double number_rooms) {
        Apartments.number_rooms = number_rooms;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        Apartments.connection = connection;
    }


    public static double getPrice() {
        return price;
    }

    public static void setPrice(double price) {
        Apartments.price = price;
    }


}
