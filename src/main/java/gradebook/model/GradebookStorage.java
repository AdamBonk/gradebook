package gradebook.model;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;

/**
*   This class allows for quick modification of data types as it is used for
*   every long data storage in the code. It includes functionailty of
*   arraylists and hashMaps in order to have dynamic sizes and
*   key value associations.
*
*/
public class GradebookStorage {
    private ArrayList<Object> storage;
    private HashMap associations;

    GradebookStorage() {
        storage = new ArrayList<Object>();
        associations = new HashMap();
    }

    public Iterator<Object> iterator() {
        storage.trimToSize();
        return storage.iterator();
    }

    public int size() {
        return storage.size();
    }

    public void add(Object object) {
        storage.add(object);
    }

    public void associate(Object aClass , Object section) {
        associations.put(aClass , section);
    }

    public Object getAssociated(Object classOrSection) {
        try {
            return associations.get(classOrSection);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean contains(Object someObject) {
        return (storage.contains(someObject));
    }

    public Object getItemByName(String type , String name) {
        if (type.equals("CATEGORY")) {
            for (Object item : storage) {
                GradebookCategory itemC = (GradebookCategory) item;
                if (itemC.getName().equals(name)) {
                    return item;
                }
            }
        }
        return null;
    }
}
