/**
 * created by Jennifer Wartick (jwartick@gmail.com)
 * submitted on 2/26/17
 */
public class CourseRecord
{
    private String courseName;
    private double courseCredits;
    private String courseGrade;
    private double courseGPA;

    // constructor

    /**
     * Constructor
     * @param name
     *      course name
     * @param credits
     *      # of credits
     * @param grade
     *      letter grade for course
     *      TODO
     *          error handling for non accepted letter grades (acceptable: A+/-, B+/-, C+/-, D/+, F)
     */

    public CourseRecord(String name, double credits, String grade)
    {
        courseName = name;
        courseCredits = credits;
        courseGrade = grade;
    }

    /**
     * accesses course name
     * @return
     *      returns stored course name
     */
    public String getName()
    {
        return courseName;
    }

    /**
     * sets the course name
     * @param s
     *      user specified course name
     */
    public void setName(String s)
    {
        courseName = s;
    }

    /**
     * allows access to course credits
     * @return
     *      returns number of credit for courses
     */
    public double getCredits()
    {
        return courseCredits;
    }

    /**
     * sets the # of credits for the course
     * @param i
     *      # of credits for the course
     */
    public void setCredits(int i)
    {
        courseCredits = i;
    }

    /**
     * allows access of the letter grade for the course
     * @return
     *      letter grade of the course
     */
    public String getGrade()
    {
        return courseGrade;
    }

    /**
     * sets letter grade for course
     * @param s
     *      letter grade of course
     *      TODO
     *          see constructor above re: handling non-valid letter grades
     */
    public void setGrade(String s)
    {
        courseGrade = s;
    }

    /**
     * converts letter grade into 'honor points' (per BU's website)
     * @return
     *      double conversion of letter grade
     */
    public double getGPA()
    {
        switch (courseGrade)
        {
            case "A+":
            {
                courseGPA = 4.0;
                break;
            }
            case "A":
            {
                courseGPA = 4.0;
                break;
            }
            case "A-":
            {
                courseGPA = 3.7;
                break;
            }
            case "B+":
            {
                courseGPA = 3.3;
                break;
            }
            case "B":
            {
                courseGPA = 3.0;
                break;
            }
            case "B-":
            {
                courseGPA = 2.7;
                break;
            }
            case "C+":
            {
                courseGPA = 2.3;
                break;
            }
            case "C":
            {
                courseGPA = 2.0;
                break;
            }
            case "C-":
            {
                courseGPA = 1.7;
                break;
            }
            case "D+":
            {
                courseGPA = 1.3;
                break;
            }
            case "D":
            {
                courseGPA = 1.0;
                break;
            }
            case "F":
            {
                courseGPA = 0.0;
                break;
            }

            default:
            {
                courseGPA = -1.0;
            }
        }
        return courseGPA;
    }

    /**
     * Prints Name, credits, and letter grade of the course
     */
    public void displayCourse()
    {
        System.out.println("Name: " + courseName + "\nCredits: " + courseCredits + "\nGrade: " + courseGrade);
    }

    /**
     * equals method
     * @param o
     *      CourseRecord object
     * @return
     *      true/false depending on whether compared objects are equal
     */
    public boolean equals(CourseRecord o)
    {
        if(o == null)
        {
            return false;
        }

        if(o==this)
        {
            return true;
        }

        if(o.getClass() != getClass())
        {
            return false;
        }

        CourseRecord record = (CourseRecord)o;
        if(record.getName().equals(courseName) && record.getCredits() == getCredits() && record.getGrade().equals(courseGrade))
        {
            return true;
        }

        else
        {
            return false;
        }
    }

    /**
     * TODO
     *      figure out how equals method and hashCode relate to each other??
     * @return
     *      THIS IS NOT FINAL
     */
    public int hashCode()
    {
        return 0;
    }

}
