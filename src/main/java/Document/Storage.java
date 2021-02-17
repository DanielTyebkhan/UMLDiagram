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

    public void AddObject(ObjectClass object) {
        objects.add(object);
    }
}
