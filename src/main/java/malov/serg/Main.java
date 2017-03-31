package malov.serg;

import java.sql.*;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) throws SQLException {

        DbProperties props = new DbProperties();
        Scanner sc = new Scanner(System.in);

        try  {
            Apartments.connection = DriverManager.getConnection(props.getUrl(), props.getUser(), props.getPassword());


            while (true) {
                System.out.println("Click 1 to select an apartment by price:");
                System.out.println("Click 2 to select an apartment by area:");
                System.out.println("Click 3 to select an apartment by the number of rooms:");

                switch (sc.nextInt()) {
                    case 1:
                        System.out.println("Enter the price of the apartment that suits you");
                        Apartments.setPrice(sc.nextDouble());
                        Apartments.viewApartments(Apartments.getPrice(), "price <=");
                        break;
                    case 2:
                        System.out.println("Enter the area of the apartment you buy");
                        Apartments.setArea(sc.nextDouble());
                        Apartments.viewApartments(Apartments.getArea(), "area <=");
                        break;
                    case 3:
                        System.out.println("Enter the number of rooms of the apartment you buy");
                        Apartments.setNumber_rooms(sc.nextDouble());
                        Apartments.viewApartments(Apartments.getNumber_rooms(), "count_rooms =");
                        break;
                }
            }


        }finally {
            if(Apartments.connection != null) {

                Apartments.connection.close();
            }
        }

    }
}
