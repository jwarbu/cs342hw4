import java.util.ArrayList;
import java.util.Scanner;
import java.util.jar.Pack200;

public class Main {

    public static void main(String[] args) throws Exception
    {
        ArrayList<StudentObj> studentCollection = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);
        Menu menuDisplay = new Menu();

        while (true)
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

                if (menuDisplay.isListed(studentCollection, stuId))
                {
                    System.out.println("Enter the information for the NEW course you are adding ");

                    System.out.print("Course Name: ");
                    String coName = keyboard.nextLine();
                    System.out.print("Credits: ");
                    int coCredits = keyboard.nextInt();
                    keyboard.nextLine();
                    System.out.print("Grade: ");
                    String coGrade = keyboard.nextLine();
                    System.out.println();

                    for (StudentObj temp : studentCollection)
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
                if (menuDisplay.isListed(studentCollection, stuId))
                {
                    int index = -1;
                    for (StudentObj temp : studentCollection)
                    {
                        if (temp.getId().equals(stuId))
                        {
                            index = studentCollection.indexOf(temp);
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
                if (menuDisplay.isListed(studentCollection, stuId))
                {
                    System.out.print("Enter name of course to be deleted: ");
                    String coName = keyboard.nextLine();
                    System.out.println();


                    for (StudentObj temp : studentCollection)
                    {
                        if (temp.getId().equals(stuId))
                        {
                            temp.removeCourse(coName);
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
                            temp.displayStudent();
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
                System.out.println("Current number of recorded students: "+ studentCollection.size());
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
