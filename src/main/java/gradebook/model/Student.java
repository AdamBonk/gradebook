package gradebook.model;

/** This class uses a mix of the singleton and flyweight design
*   patterns. Each student object represents a true "student"
*   that can be in multiple classes and multiple sections.
*   Thereby reducing the number of instances that need to
*   be made, as well as allowing access by many things
*/

public class Student {

    private String name;

    /* using the associate method I can associate classes with sections */
    private GradebookStorage enrolledClasses;
    private GradebookStorage categoriesBySection;

    // For prerequisites later.
    private GradebookStorage completedClasses;

//  BEGIN CONSTRUCTORS

    public Student(String name) {
        this.name           = name;
        enrolledClasses     = new GradebookStorage();
        categoriesBySection = new GradebookStorage();
        completedClasses    = new GradebookStorage();
    }
    public Student(String name , GradebookStorage completedClasses) {
        this.name             = name;
        this.completedClasses = completedClasses;
        enrolledClasses       = new GradebookStorage();
        categoriesBySection   = new GradebookStorage();
        completedClasses      = new GradebookStorage();
    }
//  END CONSTRUCTORS

    /**
    *       enrolls student in a single section class. section still stored in
    *       gradebook storage
    *
    */
    public void enroll(Class aClass , Section section) {
        enrolledClasses.add(aClass);
        enrolledClasses.associate(aClass , section);
        section.addStudent(this);
    }

    /* each section has associated with it a group of gradebookCategories */
    public void addGradebookCategoryBySection(Section section ,
        GradebookCategory category) {
        if (categoriesBySection.getAssociated(section) != null) {
            ((GradebookStorage) (categoriesBySection.
            getAssociated(section))).add(category);
        } else {
            GradebookStorage categories = new GradebookStorage();
            categories.add(category);
            categoriesBySection.associate(section , categories);
        }

    }

    public void replaceCategoriesBySection(Section section ,
        GradebookStorage categories) {
        categoriesBySection.associate(section , categories);
    }

    public Section getClassSection(Class aClass) {
        return (Section) enrolledClasses.getAssociated(aClass);
    }

    public GradebookStorage getGradebookCategoriesForSection(Section section) {
        GradebookStorage returnVal =
        (GradebookStorage) (categoriesBySection.getAssociated(section));
        return returnVal;
    }

     public void addGrade(Section section , String categoryName ,
        GradebookItem grade) {

        GradebookStorage categoriesForSection =
        (GradebookStorage) categoriesBySection.getAssociated(section);
        GradebookCategory studentsCategory = (GradebookCategory)
        categoriesForSection.getItemByName("CATEGORY" , categoryName);
        studentsCategory.addItem(grade);

    }
    public boolean isEnrolled(Class aClass) {
        return enrolledClasses.contains(aClass);
    }
    public boolean isEnrolled(Class aClass , Section section) {
        if (isEnrolled(aClass)) {
        Section enrolledSect =
        (Section) enrolledClasses.getAssociated(aClass);
        return enrolledSect == section;
        } else {
            return false;
        }
    }
    public double getAverageScore(Class aClass) {
        return (new GradingScheme()).findAverage(this , aClass);

    }
    public char getAverageLetterGrade(Class aClass) {
        return (new GradingScheme()).determineLetter(getAverageScore(aClass));
    }



}
