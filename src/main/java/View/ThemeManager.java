package View;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import General.Observer;
import General.Subject;

/**
 * Manages the program's global theme settings
 * @author Daniel Tyebkhan
 */
public class ThemeManager implements Subject {
    public static ThemeManager instance = new ThemeManager();
    private ArrayList<Observer> observers;
    private ThemeObject currentTheme;
    private ArrayList<ThemeObject> themes;

    /**
     * Constructs a theme manager
     */
    private ThemeManager() {
        observers = new ArrayList<Observer>();
        themes = new ArrayList<ThemeObject>(); 
        themes.add(new DarkTheme());
        themes.add(new LightTheme());
        currentTheme = themes.get(0);
    }

    /**
     * Gets available themes
     * @return a list of available themes
     */
    public ThemeObject[] getThemes() {
        ThemeObject[] toReturn = new ThemeObject[themes.size()];
        for (int i = 0; i < themes.size(); ++i) {
            toReturn[i] = themes.get(i);
        }
        return toReturn;
    }

    public void setTheme(ThemeObject toSet) {
        for (ThemeObject theme : themes) {
            if (theme.isType(toSet.getType()))
                currentTheme = theme;
        }
    }

    private ThemeObject cloneCurrent() {
        return (ThemeObject) currentTheme.clone();
    }

    public void setClassColor(Color color) {
        currentTheme = cloneCurrent();
        currentTheme.setClassColor(color);
        notifyObservers();
    }

    public void setBorderColor(Color color) {
        currentTheme = cloneCurrent();
        currentTheme.setBorderColor(color);
        notifyObservers();
    }
    
    public void setArrowColor(Color color) {
        currentTheme = cloneCurrent();
        currentTheme.setArrowColor(color);
        notifyObservers();
    }
    public void setDiagramColor(Color color) {
        currentTheme = cloneCurrent();
        currentTheme.setDiagramColor(color);
        notifyObservers();
    }

    public ThemeObject getTheme() {
        return currentTheme;
    }

    public Color getDiagramColor() {
        return currentTheme.getDiagramColor();
    }

    public Color getBorderColor() {
        return currentTheme.getBorderColor();
    }

    public Color getArrowColor() {
        return currentTheme.getArrowColor();
    }

    public Color getClassColor() {
        return currentTheme.getClassColor();
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
