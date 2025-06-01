package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.*;


import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

public class StoreManagerScreen extends JFrame {
    private Store store;
    private JMenuItem viewStoreItem, addBookItem, addCDItem, addDVDItem;
    private Component centerComponent;
    public StoreManagerScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);
        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        viewStoreItem = new JMenuItem("View Store");
        menu.add(viewStoreItem);

        JMenu smUpdateStore = new JMenu("Update Store");
        addBookItem = new JMenuItem("Add Book");
        addCDItem = new JMenuItem("Add CD");
        addDVDItem = new JMenuItem("Add DVD");
        smUpdateStore.add(addBookItem);
        smUpdateStore.add(addCDItem);
        smUpdateStore.add(addDVDItem);
        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        // Attach listeners
        viewStoreItem.addActionListener(e -> showStoreScreen());
        addBookItem.addActionListener(e -> showAddBookScreen());
        addCDItem.addActionListener(e -> showAddCDScreen());
        addDVDItem.addActionListener(e -> showAddDVDScreen());

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new GridLayout(1, 1));
        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);
        header.add(title);
        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));
        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < 9 && i < mediaInStore.size(); ++i) {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }
        // Fill empty spots for 9 cells if necessary
        for (int i = mediaInStore.size(); i < 9; i++) {
            center.add(new JPanel());
        }
        return center;
    }

    void showStoreScreen() {
        Container cp = getContentPane();
        cp.removeAll();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    void showAddBookScreen() {
        setContentPane(new AddBookToStoreScreen(store, this));
        revalidate();
        repaint();
    }

    void showAddCDScreen() {
        setContentPane(new AddCompactDiscToStoreScreen(store, this));
        revalidate();
        repaint();
    }

    void showAddDVDScreen() {
        setContentPane(new AddDigitalVideoDiscToStoreScreen(store, this));
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        Store store = new Store();
        // Add sample items
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f));
        store.addMedia(new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f));
        store.addMedia(new Book("Design Patterns", "Programming", 39.99f));
        CompactDisc cd = new CompactDisc("Supernatural", "Music", "NewJeans", 59.99f);
        cd.addTrack(new Track("Supernatural", 200));
        cd.addTrack(new Track("Right Now", 180));
        store.addMedia(cd);
        new StoreManagerScreen(store);
    }

}
