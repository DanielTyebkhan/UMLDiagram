package View;

import java.util.ArrayList;

import General.Observer;
import General.Subject;

/**
 * Manages the program's global theme settings
 * @author Daniel Tyebkhan
 */
public class ThemeManager implements Cloneable, Subject {
    public static ThemeManager instance = new ThemeManager();
    private ArrayList<Observer> observers;
    private ThemeObject currentTheme;
    private ArrayList<ThemeObject> themes;

    private ThemeManager() {
        observers = new ArrayList<Observer>();
        themes = new ArrayList<ThemeObject>();
        // Construct and add default themes
        // currentTheme = themes.get(0);
    }

    public ThemeObject getTheme() {
        return currentTheme;
    }

    @Override
    public void attachObserver(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void detachObserver(Observer obs) {
        observers.remove(obs);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers)
            o.update();
    }


}
