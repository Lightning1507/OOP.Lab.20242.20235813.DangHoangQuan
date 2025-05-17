package hust.soict.hedspi.aims.screen.manager;
import javax.swing.*;
import java.awt.*;
import hust.soict.hedspi.aims.cart.*;
import hust.soict.hedspi.aims.store.*;
import hust.soict.hedspi.aims.media.*;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

public abstract class AddItemToStoreScreen extends JPanel {
    protected Store store;
    protected StoreManagerScreen mainScreen;

    public AddItemToStoreScreen(Store store, StoreManagerScreen mainScreen) {
        this.store = store;
        this.mainScreen = mainScreen;
        setLayout(new BorderLayout());
        add(mainScreen.createMenuBar(), BorderLayout.NORTH); // Reuse menu bar
        add(createFormPanel(), BorderLayout.CENTER);
    }

    protected abstract JPanel createFormPanel();
    protected void goBackToStore() {
        if (mainScreen != null) {
            mainScreen.showStoreScreen();
//            mainScreen.revalidate();
//            mainScreen.repaint();
        }
    }
}