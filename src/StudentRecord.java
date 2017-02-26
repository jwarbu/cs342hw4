/**
 * created by Jennifer Wartick (jwartick@gmail.com)
 * submitted on 2/26/17
 */

import java.util.ArrayList;
import java.util.Scanner;

public class StudentRecord {

    public static void main(String[] args) throws Exception
    {
        ArrayList<StudentObj> studentCollection = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);
        Menu menuDisplay = new Menu();

        while (true) // infinite return to menu until program exit
        {
            menuDisplay.displayMenu();

            if (menuDisplay.getMenuChoice() == 1) // add a student
            {
                System.out.println("Enter the following information for the NEW student you are adding. ");
                System.out.print("Name: ");
                String stuName = keyboard.nextLine();
                System.out.print("Student ID: ");
                String stuId = keyboard.nextLine();
                studentCollection.add(new StudentObj(stuName, stuId));
                System.out.println();

            }

            if (menuDisplay.getMenuChoice() == 2) // add a course
            {
                System.out.print("Enter student's ID: ");
                String stuId = keyboard.nextLine();

                if (menuDisplay.isListed(studentCollection, stuId)) // checks if ID is in our records
                {
                    System.out.println("Enter the information for the NEW course you are adding "); // TODO: check if course is already in records

                    System.out.print("Course Name: ");
                    String coName = keyboard.nextLine();
                    System.out.print("Credits: ");
                    double coCredits = keyboard.nextDouble();
                    keyboard.nextLine(); // weird stuff happens if this isn't here??
                    System.out.print("Grade: ");
                    String coGrade = keyboard.nextLine();
                    System.out.println();

                    for (StudentObj temp : studentCollection) // loops through record until matching ID is found
                    {
                        if (temp.getId().equals(stuId))
                        {
                            temp.addCourse(coName, coCredits, coGrade);
                            break;
                        }
                    }
                }

                else
                {
                    System.out.println("Sorry, we have no records for a student with that ID.");
                }
            }

            if (menuDisplay.getMenuChoice() == 3) // delete a record
            {
                System.out.print("Enter ID of student to be deleted: ");
                String stuId = keyboard.nextLine();
                if (menuDisplay.isListed(studentCollection, stuId)) // check if ID is in our records
                {
                    int index = -1;
                    for (StudentObj temp : studentCollection)
                    {
                        if (temp.getId().equals(stuId)) // find student with matching ID
                        {
                            index = studentCollection.indexOf(temp); // get index of student
                        }
                    }

                    studentCollection.remove(index);
                }

                else
                {
                    System.out.println("Sorry, we have no records for a student with that ID.");
                }

            }

            if (menuDisplay.getMenuChoice() == 4) // delete course
            {
                System.out.print("Enter student's ID: ");
                String stuId = keyboard.nextLine();
                if (menuDisplay.isListed(studentCollection, stuId)) // ID in record?
                {
                    System.out.print("Enter name of course to be deleted: ");
                    String coName = keyboard.nextLine();
                    System.out.println();

                    for (StudentObj temp : studentCollection) // find matching student
                    {
                        if (temp.getId().equals(stuId))
                        {
                            temp.removeCourse(coName); // remove course
                        }
                    }
                }
                else
                {
                    System.out.println("Sorry, we have no records for a student with that ID.");
                }

            }

            if (menuDisplay.getMenuChoice() == 5) // print single student record
            {
                System.out.println("Enter student's ID: ");
                String stuId = keyboard.nextLine();
                if (menuDisplay.isListed(studentCollection, stuId))
                {
                    for (StudentObj temp : studentCollection)
                    {
                        if (temp.getId().equals(stuId))
                        {
                            temp.displayStudent(); // Displays student name, id, courses, and cumulative GPA
                        }
                    }
                }
                else
                {
                    System.out.println("Sorry, we have no records for a student with that ID.");
                }

            }

            if (menuDisplay.getMenuChoice() == 6) // print summary
            {
                System.out.println("Current number of recorded students: "+ studentCollection.size()); // displays number of student objects in the student collection array
                System.out.println("Student ID | Student Name");
                for (StudentObj temp: studentCollection)
                {
                    System.out.println(temp.getId() + " | " + temp.getName());
                }
            }

            if (menuDisplay.getMenuChoice() == 7) // Quit
            {
                System.out.println("Exiting Program... Goodbye!");
                System.exit(0);
            }
        }
    }
}
