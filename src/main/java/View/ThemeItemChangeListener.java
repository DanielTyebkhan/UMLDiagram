package View;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ThemeItemChangeListener implements ItemListener {

    @Override
    public void itemStateChanged(ItemEvent event) {
        ThemeObject selected = (ThemeObject) event.getItem();
        ThemeManager.instance.setTheme(selected);
    }
    
}
