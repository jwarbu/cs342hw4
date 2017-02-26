/**
 * created by Jennifer Wartick (jwartick@gmail.com)
 * submitted on 2/26/17
 */
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jwartick on 2/25/17.
 */
public class Menu
{
    /**
     * stores the user's menu selection
     */
    int menu_choice;

    /**
     * Displays menu of options to manipulate Student Collection
     *
     * @returns
     *      menu displayed on user's screen, prompting user to input a selection
     */
    public void displayMenu()
    {
        System.out.println();
        System.out.println("Choose an option: ");
        System.out.println("1. Add a student record");
        System.out.println("2. Add a single course to a student's record");
        System.out.println("3. Delete a student's record");
        System.out.println("4. Delete a single course from a student's record");
        System.out.println("5. Print a student's record.");
        System.out.println("6. Print summary and index of current students.");
        System.out.println("7. Exit");

        Scanner keyboard = new Scanner(System.in);
        menu_choice = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println();
    }

    /**
     * checks which option was selected by the user
     *
     * @return
     *      int chosen by user corresponding with menu options
     */
    public int getMenuChoice()
    {
        return menu_choice;
    }

    /**
     * Checks if given id is contained in given arraylist
     * TODO
     *      this method (?this entire class) should probably be nested within the main method
     * @param a
     *      Arraylist to be searched
     * @param id
     *      id to search for
     * @return
     *      true/false depending on whether the specified ID can be found within the provided arraylist
     */
    public boolean isListed(ArrayList<StudentObj> a, String id) // accepts student registry
    {
        boolean flag = false;
        for (StudentObj temp: a)
        {
            if (temp.getId().equals(id))
            {
                flag = true;
            }
        }

        return flag;
    }


}
