package hust.soict.hedspi.aims.screen.manager;
import javax.swing.*;
import java.awt.*;
import hust.soict.hedspi.aims.cart.*;
import hust.soict.hedspi.aims.store.*;
import hust.soict.hedspi.aims.media.*;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    public AddBookToStoreScreen(Store store, StoreManagerScreen mainScreen) {
        super(store, mainScreen);
    }

    @Override
    protected JPanel createFormPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
        JLabel lblTitle = new JLabel("Title:");
        JTextField tfTitle = new JTextField();
        JLabel lblCategory = new JLabel("Category:");
        JTextField tfCategory = new JTextField();
        JLabel lblCost = new JLabel("Cost:");
        JTextField tfCost = new JTextField();

        JButton btnAdd = new JButton("Add Book");

        panel.add(lblTitle); panel.add(tfTitle);
        panel.add(lblCategory); panel.add(tfCategory);
        panel.add(lblCost); panel.add(tfCost);
        panel.add(new JLabel()); // empty
        panel.add(btnAdd);

        btnAdd.addActionListener(e -> {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            float cost;
            try {
                cost = Float.parseFloat(tfCost.getText());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid cost!");
                return;
            }
            store.addMedia(new Book(title, category, cost));
            JOptionPane.showMessageDialog(this, "Book added!");
            goBackToStore();
        });

        return panel;
    }
}