/*
Author: Jesus Arias
GitHub username: ariasje1
Date: 09/08/2024
Description: It displays the cost of the chosen package and potential savings if the customer switches to another package.
*/

package mobileserviceprovider;

import javax.swing.JOptionPane;

public class MobileServiceProvider {

    public static void main(String[] args) {
        boolean repeat = true;  // Variable to control the loop

        while (repeat) {  // Start loop for repeating the process

            // Display package information to the user
            JOptionPane.showMessageDialog(null, """
                                                Package A: For $9.95 per month 10 hours of access are provided.
                                                Additional hours are $2.00 per hour.

                                                Package B: For $13.95 per month 20 hours of access are provided.
                                                Additional hours are $1.00 per hour.

                                                Package C: For $19.95 per month unlimited access is provided.""");

            // Get user's package choice
            String packageChoice = JOptionPane.showInputDialog("Please enter the package (A/B/C): ");

            // Validate package choice input
            if (packageChoice == null || (!packageChoice.equalsIgnoreCase("A") &&
                    !packageChoice.equalsIgnoreCase("B") &&
                    !packageChoice.equalsIgnoreCase("C"))) {
                JOptionPane.showMessageDialog(null, "Invalid package choice. Please enter A, B, or C.");
            } else {

                // Get user's internet usage hours
                String usageInput = JOptionPane.showInputDialog("Enter the hours of internet usage: ");

                // Validate if the input is a number
                boolean isValidNumber = true;
                if (usageInput.isEmpty()) {
                    isValidNumber = false;
                } else {
                    for (int i = 0; i < usageInput.length(); i++) {
                        if (!Character.isDigit(usageInput.charAt(i))) {
                            isValidNumber = false;
                            break;
                        }
                    }
                }

                if (!isValidNumber) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number for hours.");
                } else {

                    // Convert input to integer
                    int internetUsage = Integer.parseInt(usageInput);

                    // Check for negative hours
                    if (internetUsage < 0) {
                        JOptionPane.showMessageDialog(null, "Invalid input. Hours cannot be negative.");
                    } else {

                        // Calculate costs for each package
                        double totalCostA = (internetUsage > 10) ? (9.95 + 2.00 * (internetUsage - 10)) : 9.95;
                        double totalCostB = (internetUsage > 20) ? (13.95 + 1.00 * (internetUsage - 20)) : 13.95;
                        double totalCostC = 19.95;

                        // Determine cost and potential savings
                        String message = "";
                        if (packageChoice.equalsIgnoreCase("A")) {
                            message = "The monthly bill for the customer using Package A is $" + String.format("%.2f", totalCostA) + ".\n";

                            // Calculate savings if switching to Package B or C
                            if (totalCostA > totalCostB) {
                                message += "If the customer switched to package B, the savings would be $" + String.format("%.2f", totalCostA - totalCostB) + ".\n";
                            }
                            if (totalCostA > totalCostC) {
                                message += "If the customer switched to package C, the savings would be $" + String.format("%.2f", totalCostA - totalCostC) + ".\n";
                            }
                        } else if (packageChoice.equalsIgnoreCase("B")) {
                            message = "The monthly bill for the customer using Package B is $" + String.format("%.2f", totalCostB) + ".\n";

                            // Calculate savings if switching to Package C
                            if (totalCostB > totalCostC) {
                                message += "If the customer switched to package C, the savings would be $" + String.format("%.2f", totalCostB - totalCostC) + ".\n";
                            }
                        } else if (packageChoice.equalsIgnoreCase("C")) {
                            message = "The monthly bill for the customer using Package C is $" + String.format("%.2f", totalCostC) + ".\n";
                        }

                        // Display the message with calculated costs and potential savings
                        JOptionPane.showMessageDialog(null, message);
                    }
                }
            }

            // Ask if the user wants to perform another calculation
            String anotherCalculation = JOptionPane.showInputDialog("Would you like to calculate another bill? (yes/no): ");
            if (!"yes".equalsIgnoreCase(anotherCalculation)) {
                repeat = false;  // Exit the loop if the user does not want to continue
            }
        }
    }
}


