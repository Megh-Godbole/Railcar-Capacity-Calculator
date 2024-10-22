/*
 * Author: Megh Godbole
 * Date: October 18, 2024
 * Purpose: This program calculates the number of railcars needed to transport automobiles from London to Ottawa based on their size and quantity.
 */

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        // Multiple times used strings variables and starter outputs. 
        final String SEPERATOR_STRING = "------------------------------------------------------------------------------------------------------------------------------";
        final String MY_NAME = "Megh Godbole";
        System.out.println("Welcome to " + MY_NAME + "'s\nTrain Master Railcar Capacity Analysis\n" + SEPERATOR_STRING);
        System.out.println("Description:\nWelcome to the Railcar Shipment Calculator! As the train master,\nyou can use this tool to determine the number of railcars needed to transport automobiles from London to Ottawa.\nSimply enter the shipment details, and let us handle the calculations to ensure smooth and efficient operations.\n" + SEPERATOR_STRING);

        // User Inputs.
        Scanner inputs = new Scanner(System.in);
        
        // Get railway company name.
        System.out.print("Name of the railway company: ");
        String railwayCompanyName = inputs.nextLine();
        
        // Get numbers of automobiles.
        System.out.print("Number of automobiles to be shipped by " + railwayCompanyName + ": ");
        int numberOfAutomobiles = inputs.hasNextInt() ? inputs.nextInt() : 0;
        inputs.nextLine(); // Buffer, write from the new line.
        
        // Check while the entered Automobiles number is greater then 36.
        while (numberOfAutomobiles < 36) {
            // Print a valid error message. 
            System.out.print("Error: Number of automobiles must be at least 36. Try again: ");
            numberOfAutomobiles = inputs.hasNextInt() ? inputs.nextInt() : 0;
        }
        
        // Get maximum count of automobile per railcars.
        System.out.print("Maximum number of automobiles per railcar: ");
        int maxNumOfAutomobilesPerRailCar = inputs.hasNextInt() ? inputs.nextInt() : 0;
        inputs.nextLine(); // Buffer, write from the new line.
        
        // Check while the entered maximum count of automobile is greater then 36 and less then 48.
        while (maxNumOfAutomobilesPerRailCar < 36 || maxNumOfAutomobilesPerRailCar > 48 ) {
            // Print a valid error message. 
            System.out.print("Error: No railcars have that " + (maxNumOfAutomobilesPerRailCar < 36 ? "low" : "high") + " capacity. Try again: ");
            maxNumOfAutomobilesPerRailCar = inputs.hasNextInt() ? inputs.nextInt() : 0;
        }
        
        // Get available railcars count.
        System.out.print("Number of railcars available at " + railwayCompanyName + ": ");
        int numberOfRailcars = inputs.hasNextInt() ? inputs.nextInt() : 0;
        inputs.nextLine(); // Buffer, write from the new line.
        
        // Check while the user enter atleast one count.
        while (numberOfRailcars <= 0) { 
            // Print a valid error message. 
            System.out.print("Error: Number of railcars that are available must at least 1. Try again: ");
            numberOfRailcars = inputs.hasNextInt() ? inputs.nextInt() : 0;
        }
        inputs.close();

        // Calculation (Main Logic).
        int requiredRailcars = (int) Math.ceil((double) numberOfAutomobiles / maxNumOfAutomobilesPerRailCar); // Calculate the minimum number of railcars required to ship all automobiles.
        int maxAutomobilesShipped = numberOfRailcars * maxNumOfAutomobilesPerRailCar; // Calculate the maximum total number of automobiles that can be shipped with available railcars.
        int automobilesShipped = Math.min(numberOfAutomobiles, maxAutomobilesShipped); // Calculate how many automobiles are shipped and how many are left behind.
        int automobilesLeftBehind = numberOfAutomobiles > maxAutomobilesShipped ? numberOfAutomobiles - maxAutomobilesShipped : 0;

        // Calculate the percentage of automobiles shipped.
        double percentageShipped = ((double) automobilesShipped / numberOfAutomobiles) * 100;
        double percentageLeftBehind = ((double) automobilesLeftBehind / numberOfAutomobiles) * 100;

        // Final output.
        System.out.println(SEPERATOR_STRING);
        System.out.println(MY_NAME + "'s, Train Master Report for CP Rail\n" + SEPERATOR_STRING);
        System.out.printf("%-50s%10d\n", "Required number of automobiles to ship:", numberOfAutomobiles);
        System.out.printf("%-50s%10d\n", "Minimum number of railcars required:", requiredRailcars);
        System.out.printf("%-50s%10d\n", "Number of railcars available:", numberOfRailcars); 
        System.out.printf("%-50s%10d%c%6.1f%%\n", "Number of automobiles that can be shipped:", automobilesShipped, ',', percentageShipped);
        System.out.printf("%-50s%10d%c%6.1f%%\n", "Number of automobiles left behind:", automobilesLeftBehind, ',', percentageLeftBehind);
        if (automobilesLeftBehind == 0 && maxAutomobilesShipped > numberOfAutomobiles) {
            System.out.println("There would be room for an extra " + (maxAutomobilesShipped - numberOfAutomobiles) + " automobiles on the railcars.");
        } 
    }
}
