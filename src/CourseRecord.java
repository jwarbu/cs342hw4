/**
 * Created by jwartick on 2/25/17.
 */
public class CourseRecord
{
    public String courseName;
    public int courseCredits;
    public String courseGrade;

    // constructor

    public CourseRecord(String s, int i, String s2)
    {
        courseName = s;
        courseCredits = i;
        courseGrade = s2;
    }



    public String getName()
    {
        return courseName;
    }

    public void setName(String s)
    {
        courseName = s;
    }

    public int getCredits()
    {
        return courseCredits;
    }

    public void setCredits(int i)
    {
        courseCredits = i;
    }

    public String getGrade()
    {
        return courseGrade;
    }

    public void setGrade(char c)
    {
        courseCredits = c;
    }

    public void displayCourse()
    {
        System.out.println("Name: " + courseName + "\nCredits: " + courseCredits + "\nGrade: " + courseGrade);
    }

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

    public int hashCode()
    {
        return 0;
    }

}
