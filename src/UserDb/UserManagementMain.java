package UserDb;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Common.DbUtils;

public class UserManagementMain {
	public static void userManagement() throws IOException, SQLException {
		System.out.println(" *** Welcome to User Management*** ");

		Scanner sc = new Scanner(System.in);

		boolean shallIKeepRunningCode = true;

		User user = new User();

		while (shallIKeepRunningCode) {

			System.out.println("What would you like to do today ?");
			System.out.println("1. Add User");
			System.out.println("2.Update User ");
			System.out.println("3.Search User");
			System.out.println("4.Delete User");
			System.out.println("5.Print User");
			System.out.println("9.Exit");

			int option = sc.nextInt();

			switch (option) {
			case 1:
				System.out.println("Add User");
				System.out.println("Enter the User details: ");

				System.out.println("Enter the first name : ");
				user.firstName = sc.next();

				System.out.println("Enter the last name : ");
				user.lastName = sc.next();

				System.out.println("Enter the age : ");
				user.age = sc.nextInt();

				System.out.println("Enter the gender : ");
				user.gender = sc.next();

				System.out.println("Enter the email : ");
				user.email = sc.next();

				System.out.println("Enter the  Password : ");
				user.password = sc.next();

				System.out.println("Enter the confirm password : ");
				user.confirmPassword = sc.next();
				System.out.println("User added succefully!!!");

				String insertQuery = "INSERT INTO user (First_name, last_name, age, gender, Email, Password) VALUES ( '"
						+ user.firstName + "','" + user.lastName + "'," + user.age + ",'" + user.gender + "', ' "
						+ user.email + "','" + user.password + "')";
				DbUtils.executeQuery(insertQuery);

				break;

			case 2:
				System.out.print("Enter new Firstname: ");
				String newName = sc.next();

				System.out.print("Enter new lastname: ");
				String newlastName = sc.next();

				System.out.print("Enter new age: ");
				int newage = sc.nextInt();

				System.out.print("Enter new gender: ");
				String newgender = sc.next();

				System.out.print("Enter new email: ");
				String newemail = sc.next();

				System.out.print("Enter new password: ");
				String newpassword = sc.next();

				String updateQuery = "UPDATE user SET  First_name='" + newName + "', last_name='" + newlastName
						+ "', age=" + newage + ", gender='" + newgender + "', Email='" + newemail + "', Password='"
						+ newpassword;

				DbUtils.executeQuery(updateQuery);

				System.out.println("User updated successfully.");
				break;
			case 3:
				System.out.print("Enter Name to search: ");
				user.firstName = sc.next();
				String searchQuery = "SELECT * FROM user WHERE user_name = " + user.firstName;

				ResultSet result = DbUtils.executeSelectQuery(searchQuery);
				if (result.next()) {
					System.out.println(", First Name: " + result.getString("First_name") + ", last Name: "
							+ result.getString("last_name") + ", Age: " + result.getInt("age") + ", Gender: "
							+ result.getString("gender") + ", Password: " + result.getString("Password"));
				} else {
					System.out.println("User search failed..");
				}
				break;

			case 4:
				System.out.print("Enter Name to delete: ");
				user.firstName = sc.next();
				String deleteQuery = "DELETE FROM user WHERE user_name = " + user.firstName;

				DbUtils.executeQuery(deleteQuery);

				System.out.println("User deleted successfully.");
				break;

			case 5:
				String viewAllQuery = "SELECT * FROM user";
				ResultSet result1 = DbUtils.executeSelectQuery(viewAllQuery);
				while (result1.next()) {
					System.out.println(", First Name: " + result1.getString("First_name") + ", last Name: "
							+ result1.getString("last_name") + ", Age: " + result1.getInt("age") + ", Gender: "
							+ result1.getString("gender") + ", Password: " + result1.getString("Password"));
				}
				break;

			case 9:
				System.out.println("Exiting the user Management...");
				shallIKeepRunningCode = false;
				break;

			default:
				System.out.println("Unknown option Selected...");
			}
		}
	}

}
