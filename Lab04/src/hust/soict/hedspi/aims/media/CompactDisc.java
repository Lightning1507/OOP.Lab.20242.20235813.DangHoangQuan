package hust.soict.hedspi.aims.media;
import java.util.*;

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


    public void play(){
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("Artist: " + this.getArtist());
        System.out.println("Total length: " + this.getLength());

        for (Track track : tracks) {
            track.play();
        }
    }

    public String toString() {
        return getId() + ". CD - " + getTitle() + " - " + getCategory() + " - " + getArtist() + " - "
                + getLength() + " - " + getCost() + "$";
    }
}
