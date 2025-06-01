package hust.soict.hedspi.aims.media;
import java.util.*;

import hust.soict.hedspi.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public String getArtist() {
        return artist;
    }

    public CompactDisc() {
        super();
    }
    public CompactDisc(String title) {
        super(title);
    }
    public CompactDisc(String title, String category) {
        super(title, category);
    }
    public CompactDisc(String title, String category, float cost) {
        super(title, category, cost);
    }
    public CompactDisc(String title, String category, String artist, float cost) {
        super(title, category, cost);
        this.artist = artist;
    }

    public void addTrack(Track track) {
        int tmp = tracks.indexOf(track);
        if (tmp != -1) {
            return;
        }
        tracks.add(track);
    }

    public void removeTrack(Track track) {
        if (tracks.remove(track)) {
            System.out.println("Track removed successfully");
        } else {
            System.out.println("Track not found");
        }
    }

    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }


    @Override
    public String play() throws PlayerException {
        if (tracks.isEmpty()) {
            System.err.println("ERROR: No tracks available to play");
			throw new PlayerException("ERROR: No tracks available to play");
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("Playing CD: ").append(this.getTitle()).append("\n")
          .append("Artist: ").append(this.getArtist()).append("\n")
          .append("Total length: ").append(this.getLength()).append(" seconds\n");
        
        for (Track track : tracks) {
            try {
                sb.append(track.play()).append("\n");
            } catch (PlayerException e) {
                sb.append("Error playing track ").append(track.getTitle())
                  .append(": ").append(e.getMessage()).append("\n");
            }
        }
        
        return sb.toString();
    }

    public String toString() {
        return getId() + ". CD - " + getTitle() + " - " + getCategory() + " - " + getArtist() + " - "
                + getLength() + " - " + getCost() + "$";
    }
}
