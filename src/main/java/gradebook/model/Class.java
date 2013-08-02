package gradebook.model;


/** Class represents one instance of an instance of a course
*   and implements the delegation pattern by accepting a
*   course in as some stock information, but allowing certain
*   information to be
*   changed (such as the description, if the class is a
*   special kind of one course)
*/
public class Class {
/*
    formatting of semester can be formatted as
    "SPRING2013"
*/
    private String semester;
    private Course courseInfo;
    private String description;
    private GradebookStorage sections;
//  INSTRUCTOR



//  BEGIN CONSTRUCTORS
    public Class(Course course , String semester) {
        courseInfo    = course;
        courseInfo.addClass(this);
        this.semester = semester;
        sections      = new GradebookStorage();
    }
    public Class(Course course , String semester ,
        GradebookStorage sections) {
        courseInfo    = course;
        courseInfo.addClass(this);
        this.semester = semester;
        this.sections = sections;
    }
    public Class(Course course , String semester ,
        GradebookStorage sections , String newDescription) {
        courseInfo       = course;
        courseInfo.addClass(this);
        this.semester    = semester;
        this.sections    = sections;
        this.description = newDescription;
    }
//  END CONSTRUCTORS


/*  Add error catching for section that already exists*/
    public void addSection(Section section) {
        sections.add(section);
    }

    public GradebookStorage getSections() {
        return sections;
    }

    public double getAverageScore() {
        return (new GradingScheme()).findAverage(this);
    }

    public char getAverageLetterGrade() {
        return (new GradingScheme()).determineLetter(getAverageScore());
    }

    public String getDescription() {
        if (description == null) {
            return courseInfo.getDescription();
        } else {
            return description;
        }
    }

}
