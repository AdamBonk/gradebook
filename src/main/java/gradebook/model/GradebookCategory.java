package gradebook.model;

import java.util.Iterator;

/** Gradebook Categories belong to students
*   this method of sections holding categories is different from the project
*   description,
*   but the method defined by the description would create a category object
*   for every
*   gradebook item, which is wasteful according to flyweight design.
*/
public class GradebookCategory {

    private String name;
    private GradebookStorage items;
    private double weight;

    public GradebookCategory(String name , GradebookStorage items ,
        double weight) {
        this.name   = name;
        this.items  = items;
        this.weight = weight;
    }

    public GradebookCategory(String name , double weight) {
        this.name   = name;
        this.weight = weight;
        items       = new GradebookStorage();
    }

    public GradebookCategory duplicate(GradebookCategory category) {
        return new GradebookCategory(category.getName(),
        category.getWeight());
    }

    public void addItem(GradebookItem item) {
        item.setCategory(this);
        items.add(item);
    }
    public void changeWeight(double newWeight) {
        weight = newWeight;
    }

    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public double findWeightedAverage() {
        double average = new GradingScheme().findAverage(this);
        return average * weight;
    }

    public GradebookStorage getItems() {
        return items;
    }

    public String toString() {
        Iterator itemIterator = items.iterator();
        String returnString = "";
        returnString += "Category: " + name + "   Weight: "
        + weight + "\n";
        while (itemIterator.hasNext()) {
            returnString +=
            "      " + ((GradebookItem) itemIterator.next()).toString();
        }
        return returnString;
    }

}
