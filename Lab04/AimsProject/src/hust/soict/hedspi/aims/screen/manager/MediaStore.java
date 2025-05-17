package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.media.Track;

import javax.swing.*;
import java.awt.*;

public class MediaStore extends JPanel {
    private Media media;
    public MediaStore(Media media){
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(""+media.getCost()+" $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        if (media instanceof Playable){
            JButton playButton = new JButton("Play");
            playButton.addActionListener(e -> {
                JDialog dialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(this), "Playing Media", true);
                JTextArea ta = new JTextArea();
                if (media instanceof CompactDisc) {
                    CompactDisc cd = (CompactDisc) media;
                    StringBuilder content = new StringBuilder(media.toString() + "\n\nTrack List:\n");
                    for (Track track : cd.getTracks()) {
                        content.append("- ").append(track.getTitle())
                                .append(" (Length: ").append(track.getLength()).append(")\n");
                    }
                    ta.setText(content.toString());
                } else {
                    ta.setText(media.toString());
                }
                ta.setEditable(false);
                dialog.add(new JScrollPane(ta));
                dialog.setSize(300, 200);
                dialog.setLocationRelativeTo(this);
                dialog.setVisible(true);
            });
            container.add(playButton);
        }
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}