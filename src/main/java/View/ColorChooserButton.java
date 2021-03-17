package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import General.Observer;

/**
 * Creates a color chooser button that displays
 * the current selected color
 * @author Sai Lyon Ho
 */
public class ColorChooserButton extends JButton implements Observer {
    
    private Color current;
    private Consumer<Color> setter;
    private Supplier<Color> getter;

    /**
     * Constructs the button that opens the JColorChooser
     * @param c is the current color
     * @param label is the label associated with the button
     * @param setter is a Consumer of type Color
     * @param getter is a Subject of type Color
     */
    public ColorChooserButton(Color c, String label, Consumer<Color> setter, Supplier<Color> getter) {
        this.setter = setter;
        this.getter = getter;
        setSelectedColor(c); 
        setText(label);
        setSize(new Dimension(200, 200));

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color newColor = JColorChooser.showDialog(null, "Choose a color", current);
                setSelectedColor(newColor);
            }
        });
    }

    /**
     * Gets the current selected color
     * @return current Color
     */
    public Color getSelectedColor() {
        return current;
    }

    /**
     * Sets the selected color
     * @param newColor
     */
    public void setSelectedColor(Color newColor) {
        setSelectedColor(newColor, true);
    }

    /**
     * Creates square icon with current color when notified
     * @param newColor the new set Color
     */
    private void setColorNoNotify(Color newColor) {
        current = newColor;
        setIcon(createIcon(current, 30, 30));
        repaint();
    }

    /**
     * Sets selected color and makes sure others are notified 
     * @param newColor the new set Color
     * @param notify a boolean as a notifier 
     */
    public void setSelectedColor(Color newColor, boolean notify) {

        if (newColor == null) return;

        setColorNoNotify(newColor);
        if (notify) {
            // Notify everybody that may be interested.
            for (ColorChangedListener l : listeners) {
                l.colorChanged(newColor);
            }
        }
        setter.accept(current);
    }

    public static interface ColorChangedListener {
        public void colorChanged(Color newColor);
    }

    private List<ColorChangedListener> listeners = new ArrayList<ColorChangedListener>();

    public void addColorChangedListener(ColorChangedListener toAdd) {
        listeners.add(toAdd);
    }

    /**
     * Creates icon as a square filled with the current color
     * @param main the color
     * @param width of the icon as int
     * @param height of icon as int 
     * @return the icon type ImageIcon 
     */
    public static ImageIcon createIcon(Color main, int width, int height) {
        BufferedImage image = new BufferedImage(width, height, java.awt.image.BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(main);
        graphics.fillRect(0, 0, width, height);
        graphics.setXORMode(Color.DARK_GRAY);
        graphics.drawRect(0, 0, width-1, height-1);
        image.flush();
        ImageIcon icon = new ImageIcon(image);
        return icon;
    }

    @Override
    public void update() {
        setColorNoNotify(getter.get());
        repaint();
    }
}
