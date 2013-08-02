package gradebook.model;

/** Represents a course that is possible to exist as
*   a class depending on the semseter.
*   contains a subject, name, course number
*   description, and a list of preRequisites.
*/
public class Course {
    /*
    Subjects should be formatted all caps
    and in their short form e.g. "CS"
    */
    private String subject;
    private String name;
    private int courseNumber;
    private String description;
    private GradebookStorage preRequesites;
    private GradebookStorage classes;

//  BEGIN CONSTRUCTORS
    public Course(String subject , String name , int courseNumber) {
        this.subject      = subject;
        this.name         = name;
        this.courseNumber = courseNumber;
        classes = new GradebookStorage();
        preRequesites = new GradebookStorage();

    }
    public Course(String subject , String name , int courseNumber ,
        String description) {
        this.subject       = subject;
        this.name          = name;
        this.courseNumber  = courseNumber;
        this.description   = description;
        classes = new GradebookStorage();
        preRequesites = new GradebookStorage();
    }
    public Course(String subject , String name , int courseNumber ,
        GradebookStorage preRequesites) {
        this.subject       = subject;
        this.name          = name;
        this.courseNumber  = courseNumber;
        this.preRequesites = preRequesites;
        classes = new GradebookStorage();

    }
    public Course(String subject , String name , int courseNumber ,
        GradebookStorage preRequesites , String description) {
        this.subject       = subject;
        this.name          = name;
        this.courseNumber  = courseNumber;
        this.preRequesites = preRequesites;
        this.description   = description;
        classes = new GradebookStorage();
    }
//  END CONSTRUCTORS

    public void addClass(Class aClass) {
        classes.add(aClass);
    }
    public String getSubject() {
        return subject;
    }
    public String getName() {
        return name;
    }
    public int getCourseNumber() {
        return courseNumber;
    }
    public String getDescription() {
        if (description == null) {
            return "none";
        }
        return description;
    }
    public GradebookStorage getPreRequisites() {
        return preRequesites;
    }
    public GradebookStorage getClasses() {
        return classes;
    }
    public double getAverageScore() {
        return (new GradingScheme()).findAverage(this);
    }
    public char getAverageLetterGrade() {
        return (new GradingScheme()).determineLetter(getAverageScore());
    }
}
