package hust.soict.hedspi.aims.screen.manager;
import javax.swing.*;
import java.awt.*;
import hust.soict.hedspi.aims.cart.*;
import hust.soict.hedspi.aims.store.*;
import hust.soict.hedspi.aims.media.*;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    public AddCompactDiscToStoreScreen(Store store, StoreManagerScreen mainScreen) {
        super(store, mainScreen);
    }

    @Override
    protected JPanel createFormPanel() {
        ArrayList<Track> tracks = new ArrayList<>();

        JPanel panel = new JPanel(new GridLayout(7, 2, 5, 5));
        JLabel lblTitle = new JLabel("Title:");
        JTextField tfTitle = new JTextField();
        JLabel lblCategory = new JLabel("Category:");
        JTextField tfCategory = new JTextField();
        JLabel lblArtist = new JLabel("Artist:");
        JTextField tfArtist = new JTextField();
        JLabel lblCost = new JLabel("Cost:");
        JTextField tfCost = new JTextField();
        JLabel lblTrackTitle = new JLabel("Track Title:");
        JTextField tfTrackTitle = new JTextField();
        JLabel lblTrackLength = new JLabel("Track Length:");
        JTextField tfTrackLength = new JTextField();

        JButton btnAddTrack = new JButton("Add Track");
        JButton btnAdd = new JButton("Add CD");

        panel.add(lblTitle);
        panel.add(tfTitle);
        panel.add(lblCategory);
        panel.add(tfCategory);
        panel.add(lblArtist);
        panel.add(tfArtist);
        panel.add(lblCost);
        panel.add(tfCost);
        panel.add(lblTrackTitle);
        panel.add(tfTrackTitle);
        panel.add(lblTrackLength);
        panel.add(tfTrackLength);
        panel.add(btnAddTrack);
        panel.add(btnAdd);

        btnAddTrack.addActionListener(e -> {
            String trackTitle = tfTrackTitle.getText();
            int trackLength;
            try {
                trackLength = Integer.parseInt(tfTrackLength.getText());
                tracks.add(new Track(trackTitle, trackLength));
                tfTrackTitle.setText("");
                tfTrackLength.setText("");
                JOptionPane.showMessageDialog(this, "Track added!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid track length!");
            }
        });

        btnAdd.addActionListener(e -> {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            String artist = tfArtist.getText();
            float cost;
            try {
                cost = Float.parseFloat(tfCost.getText());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid cost!");
                return;
            }
            CompactDisc cd = new CompactDisc(title, category, artist, cost);
            for (Track track : tracks) {
                cd.addTrack(track);
            }
            store.addMedia(cd);
            JOptionPane.showMessageDialog(this, "CD added!");
            goBackToStore();
        });

        return panel;
    }
}