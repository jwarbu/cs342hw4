/**
 * Created by jwartick on 2/25/17.
 */
public class StudentObj
{
    private String studentName;
    private String studentId;
    private GDList<CourseRecord> courses = new GDList<CourseRecord>();

    public StudentObj()
    {
        this.studentName = "n/a";
        this.studentId = "n/a";
    }
    public StudentObj(String name, String id)
    {
        studentName = name;
        studentId = id;
    }

    public String getName()
    {
        return studentName;
    }
    public void setName(String s)
    {
        studentName = s;
    }

    public String getId()
    {
        return studentId;
    }
    public void setId(String s)
    {
        studentId = s;
    }

    public void addCourse(String name, int credits, String grade)
    {
        courses.addToHead(new CourseRecord(name, credits, grade));
        //courses.printList();
    }

    public void removeCourse(String coName)
    {
        CourseRecord temp = courses.findData(coName);
        courses.deleteNode(temp);
    }

    public void displayStudent()
    {
        System.out.print("Name: " + studentName + "\nID: " + studentId + "\nCourse List:\n ");
        courses.prettyPrint();
    }

}
