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
