package gradebook.model;



import java.util.Iterator;

/** uses the Strategy design pattern by allowing the method
*   of determining the average grades to change depending
*   on the type of object that called the method.
*
*/

public class GradingScheme {

    private static final int GRADEA = 90;
    private static final int GRADEB = 80;
    private static final int GRADEC = 70;
    private static final int GRADED = 60;
    private static final int IGNORE = -1;

    public char determineLetter(double gradeVal) {

        if (gradeVal == GRADEA) {
            return 'A';
        } else if (gradeVal >= GRADEB) {
            return 'B';
        } else if (gradeVal >= GRADEC) {
            return 'C';
        } else if (gradeVal >= GRADED) {
            return 'D';
        } else {
            return 'F';
        }

    }

    public double findAverage(GradebookCategory category) {
        GradebookStorage items = category.getItems();
        double categoryTotal = 0;
        int categorySize     = items.size();

        if (categorySize == 0) {
            return IGNORE;
        }

        Iterator itemsIterator = items.iterator();

        while (itemsIterator.hasNext()) {
            GradebookItem curItem = (GradebookItem) itemsIterator.next();
            if (curItem.getScore() == IGNORE) {
                categorySize--;
            } else {
                categoryTotal += curItem.getScore();
            }

        }

        if (categorySize == 0) {
            return IGNORE;
        }

        return (categoryTotal / categorySize);

    }

    public double findAverage(Student student , Section section) {
        GradebookStorage categories =
        student.getGradebookCategoriesForSection(section);
        Iterator categoriesIterator = categories.iterator();
        double total = 0;

        while (categoriesIterator.hasNext()) {
            GradebookCategory currentCategory = (GradebookCategory)
            categoriesIterator.next();
            double curNum = findAverage(currentCategory);
            if (curNum != IGNORE) {
                total += curNum * currentCategory.getWeight();
            }
        }
        return total;

    }

    public double findAverage(Student student , Class aClass) {
        return findAverage(student , student.getClassSection(aClass));
    }

    public double findAverage(Section section) {
        int numberOfStudents = section.getSize();
        double totalVal      = 0;
        if (numberOfStudents == 0) {
            return IGNORE;
        }
        Iterator studentIt   = section.getStudents().iterator();

        while (studentIt.hasNext()) {
            Student curStudent = (Student) studentIt.next();
            totalVal += findAverage(curStudent , section);
        }
        return (totalVal / numberOfStudents);
    }

    public double findAverage(Class aClass) {
        GradebookStorage sections = aClass.getSections();
        int numberOfSections = sections.size();
        if (numberOfSections == 0) {
            return IGNORE;
        }
        double totalVal         = 0;
        Iterator sectionIt   = sections.iterator();
        while (sectionIt.hasNext()) {
            double curAvg = findAverage((Section) sectionIt.next());
            if (curAvg == IGNORE) {
                numberOfSections--;
            } else {
                totalVal += curAvg;
            }
        }
        if (numberOfSections == 0) {
            return IGNORE;
        }

        return (totalVal / numberOfSections);

    }

    public double findAverage(Course course) {
        GradebookStorage classes = course.getClasses();
        int numberOfClasses = classes.size();
        double val = 0;
        Iterator classIt = classes.iterator();
        while (classIt.hasNext()) {
            double classAvg = findAverage((Class) classIt.next());

            if (classAvg == IGNORE) {
                numberOfClasses--;
            } else {
                val += classAvg;
            }
        }
        if (numberOfClasses == 0) {
            return IGNORE;
        }

        return val / numberOfClasses;

    }

}
