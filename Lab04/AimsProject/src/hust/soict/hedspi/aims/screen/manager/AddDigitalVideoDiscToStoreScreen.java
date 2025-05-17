package hust.soict.hedspi.aims.screen.manager;
import javax.swing.*;
import java.awt.*;
import hust.soict.hedspi.aims.store.*;
import hust.soict.hedspi.aims.media.*;


public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    public AddDigitalVideoDiscToStoreScreen(Store store, StoreManagerScreen mainScreen) {
        super(store, mainScreen);
    }

    @Override
    protected JPanel createFormPanel() {
        JPanel panel = new JPanel(new GridLayout(6, 2, 5, 5));
        JLabel lblTitle = new JLabel("Title:");
        JTextField tfTitle = new JTextField();
        JLabel lblCategory = new JLabel("Category:");
        JTextField tfCategory = new JTextField();
        JLabel lblDirector = new JLabel("Director:");
        JTextField tfDirector = new JTextField();
        JLabel lblLength = new JLabel("Length:");
        JTextField tfLength = new JTextField();
        JLabel lblCost = new JLabel("Cost:");
        JTextField tfCost = new JTextField();

        JButton btnAdd = new JButton("Add DVD");

        panel.add(lblTitle); panel.add(tfTitle);
        panel.add(lblCategory); panel.add(tfCategory);
        panel.add(lblDirector); panel.add(tfDirector);
        panel.add(lblLength); panel.add(tfLength);
        panel.add(lblCost); panel.add(tfCost);
        panel.add(new JLabel());
        panel.add(btnAdd);

        btnAdd.addActionListener(e -> {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            String director = tfDirector.getText();
            int length;
            float cost;
            try {
                length = Integer.parseInt(tfLength.getText());
                cost = Float.parseFloat(tfCost.getText());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid length or cost!");
                return;
            }
            store.addMedia(new DigitalVideoDisc(title, category, director, length, cost));
            JOptionPane.showMessageDialog(this, "DVD added!");
            goBackToStore();
        });

        return panel;
    }
}