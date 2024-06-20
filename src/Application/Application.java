package Application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import ProductDb.ProductManagementMain;
import UserDb.UserManagementMain;

public class Application {
	public static void main(String[] args) throws IOException, SQLException {

		System.out.println(" *** Welcome to E-Commerce Project*** ");

		Scanner sc = new Scanner(System.in);
		boolean shallIKeepRunningCode = true;

		while (shallIKeepRunningCode) {
			System.out.println("What would you like to do today ?");
			System.out.println("1.Product Management");
			System.out.println("2.User Management");
			System.out.println("9.Exit");
			int option = sc.nextInt();

			System.out.println(option);

			switch (option) {
			case 1:
				ProductManagementMain.productManagement();
				break;
			case 2:
				UserManagementMain.userManagement();

				break;

			case 9:
				System.out.println("Exiting the application...");
				shallIKeepRunningCode = false;
				break;
			default:
				System.out.println("Unknown option");
			}
		}
	}

}
