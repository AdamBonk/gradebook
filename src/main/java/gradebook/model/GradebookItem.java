package gradebook.model;

/** Is instantiated for each grade a student recieves
*   in a given category. can have a name, score, and
*   contains a variable indicating the category it belongs
*   to.
*/

public class GradebookItem {

    private String name;
    private double score;
    private GradebookCategory category;
    private static final int PADDING = 10;
    private static final int IGNORE  = -1;

// BEGIN CONSTRUCTERS
    public GradebookItem(String name) {
        this.name = name;
        score = IGNORE;
    }
    public GradebookItem(double score) {
        this.score = score;
    }
    public GradebookItem(String name , double score) {
        this.name  = name;
        this.score = score;
    }
    public GradebookItem(String name , GradebookCategory category) {
        this.name     = name;
        score         = IGNORE;
        this.category = category;
    }
    public GradebookItem(double score , GradebookCategory category) {
        this.score    = score;
        this.category = category;
    }
    public GradebookItem(String name , double score ,
        GradebookCategory category) {
        this.name     = name;
        this.score    = score;
        this.category = category;
    }
    public GradebookItem(GradebookCategory category) {
        score         = IGNORE;
        this.category = category;
    }
//  END CONSTRUCTOR


    public void setName(String name) {
        this.name = name;
    }
    public void setScore(double score) {
        this.score = score;
    }
    public void setCategory(GradebookCategory category) {
        this.category = category;
    }
    public String getName() {
        if (name == null) {
            return "Unnamed";
        } else {
            return name;
        }
    }
    public double getScore() {
        return score;
    }
    public GradebookCategory getCategory() {
        return category;
    }
    public double getWeightOfCategory() {
        return category.getWeight();
    }

    public String toString() {
        return String.format("%1$-" + PADDING + "s",
            getName()) + ": " + score + "\n";
    }

}
