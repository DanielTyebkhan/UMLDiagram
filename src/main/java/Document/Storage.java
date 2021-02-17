package Document;

import java.util.List;
import java.util.ArrayList;
import Document.ObjectClass;
import View.Observer;

public class Storage {
    private ArrayList<ObjectClass> objects;
    private ArrayList<Observer> observers;

    public void notifyObservers() {
        for (Observer observer : observers)
            observer.update();
    }

    public List<ObjectClass> getObjects() {
        return new ArrayList<ObjectClass>(objects);
    }

    public int numObjects() {
        return objects.size();
    }

    public void addObject(ObjectClass object) {
        objects.add(object);
    }

    public boolean removeObject(ObjectClass object) {
        int toRemove = -1;
        int index = 0;
        while (index < numObjects()) {
            if (getObjects().get(index).equals(object))
                toRemove = index;
        }
        if (toRemove > -1) {
            objects.remove(toRemove);
            return true;
        }
        return false;
    }
}
