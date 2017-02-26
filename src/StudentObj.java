/**
 * created by Jennifer Wartick (jwartick@gmail.com)
 * submitted on 2/26/17
 */
public class StudentObj
{
    private String studentName;
    private String studentId;
    private GDList<CourseRecord> courses = new GDList<CourseRecord>();

    /**
     * default constructor for this class
     */
    public StudentObj()
    {
        this.studentName = "n/a";
        this.studentId = "n/a";
    }

    /**
     * constructor
     * @param name
     *      student name
     * @param id
     *      student ID
     */
    public StudentObj(String name, String id)
    {
        studentName = name;
        studentId = id;
    }

    /**
     * access student's name
     * @return
     *      name of student
     */
    public String getName()
    {
        return studentName;
    }

    /**
     * set student's name
     * @param s
     *      student's name
     */
    public void setName(String s)
    {
        studentName = s;
    }

    /**
     * access student's id
     * @return
     *      student's id
     */
    public String getId()
    {
        return studentId;
    }

    /**
     * set student's id
     * @param s
     *      id for student
     */
    public void setId(String s)
    {
        studentId = s;
    }

    /**
     * Adds a course to the student's record
     * @param name
     *      name of course
     * @param credits
     *      number of credits for the course (hw valid credits: 1, 2, 3, 4)
     *      TODO
     *          check validity of credit number
     * @param grade
     *      letter grade received by student for the course
     */
    public void addCourse(String name, double credits, String grade)
    {
        courses.addToHead(new CourseRecord(name, credits, grade));
        //courses.printList(); // for debugging
    }

    /**
     * removes a course from the student's record:
     * searches linkedlist of course records for a node containing a CourseRecord object with the specificed course name

     * @param coName
     *      name of course to be removed
     */
    public void removeCourse(String coName)
    {
        CourseRecord temp = courses.findData(coName);
        courses.deleteNode(temp);
    }

    /**
     * displays student name and ID from this class and calls prettyPrint method from GDList
     * which lists each course & calculates the cumulative GPA for all courses in the linkedlist
     */
    public void displayStudent()
    {
        System.out.println("Name: " + studentName + "\nID: " + studentId);
        System.out.println("---------------");
        System.out.println("Course List");
        System.out.println("---------------");
        courses.prettyPrint();
    }

}
