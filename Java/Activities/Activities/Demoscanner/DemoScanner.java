package Activities.Demoscanner;
import java.util.Scanner;
public class DemoScanner {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter username");

        // Read user input
        String userName = myObj.nextLine();
        // Output user input
        System.out.println("Username is: " + userName);
}
}