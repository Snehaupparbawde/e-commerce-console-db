package UserDb;

public class User {
	String firstName;
	String lastName;
	String gender;
	int age;
	String email;
	String password;
	String confirmPassword;

	public void printUser() {
		System.out.println("FirstName:" + firstName);
		System.out.println("FirstName:" + lastName);
		System.out.println("FirstName:" + gender);
		System.out.println("FirstName:" + age);
		System.out.println("FirstName:" + email);
		System.out.println("FirstName:" +confirmPassword);
	}

}
