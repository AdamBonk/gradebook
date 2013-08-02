package gradebook.model;

import java.util.Iterator;


/** Handles creation of and dealing with sections. uses the
*   Delegation design pattern by knowing the class which
*   holds an individual section.
*/


public class Section {

    private String name;
    private GradebookStorage students;
    private GradebookStorage gradingCategories;
    private Class ownerClass;


//  BEGIN CONSTRUCTORS
    public Section(Class owner , GradebookStorage students) {
        ownerClass    = owner;
        owner.addSection(this);
        this.students = students;
        this.gradingCategories = new GradebookStorage();
    }
    public Section(Class owner , String name , GradebookStorage students) {
        ownerClass    = owner;
        owner.addSection(this);
        this.name     = name;
        this.students = students;
        this.gradingCategories = new GradebookStorage();
    }
    public Section(Class owner , String name) {
        ownerClass    = owner;
        owner.addSection(this);
        this.name     = name;
        this.students = new GradebookStorage();
        this.gradingCategories = new GradebookStorage();
    }

//  END CONSTRUCTORS



/*  Add error catching for student that already exists*/
    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            if (!student.isEnrolled(ownerClass , this)) {
                student.enroll(ownerClass , this);
            }
        }
    }

    public void addGradebookCategory(GradebookCategory category) {
        gradingCategories.add(category);
        Iterator studentIterator = students.iterator();
        while (studentIterator.hasNext()) {
            Student currentStudent = (Student) studentIterator.next();
            currentStudent.addGradebookCategoryBySection(this , category);
        }

    }

    public GradebookStorage getCategories() {
        return gradingCategories;
    }

    public int getSize() {
        return students.size();
    }

    public GradebookStorage getStudents() {
        return students;
    }

    public double getAverageScore() {
        return (new GradingScheme()).findAverage(this);
    }

    public char getAverageLetterGrade() {
        return (new GradingScheme()).determineLetter(getAverageScore());
    }

    public boolean hasStudent(Student student) {
        return students.contains(student);
    }

}
