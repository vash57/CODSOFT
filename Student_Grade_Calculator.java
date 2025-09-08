/*
* PROJECT: STUDENT GRADE CALCULATOR
* Internship:CODSOFT
* Task: 2
* Description: 
* This program is a for a student grade calulator
* where we take a no of each subject between (0-100) and after 
* we calculate the average and Declare thier Grade.......
* Author: DEV KUMAR CHAUBEY
* Date : 29 Aug 2025
*/
import java.util.Scanner;
public class Task_2_Student_Grade_Calculator {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Taking input form the user for no of subjects.
        System.out.print("Enter the number of subjects: ");
        int n = sc.nextInt();

        int[] marks = new int[n];
        int totalMarks = 0;

        // Taking marks input
        for (int i = 0; i < n; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            marks[i] = sc.nextInt();

            // Validation (0-100 only)
            if (marks[i]<0 || marks[i]>100) {
                System.out.println("Invalid marks! Please enter between 0 and 100.");
                i--; // repeat for same subject
                continue;
            }
            totalMarks += marks[i];
        }

        // Calculate average percentage
        double averagePercentage=(double) totalMarks/n;

        // Grade Define for each student
        String grade;
        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Result of Stuedent
        System.out.println("\n----- STUDENT RESULT -----");
        System.out.println("Total Marks Obtained: " + totalMarks + " / " + (n * 100));
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        sc.close();
    }
}



