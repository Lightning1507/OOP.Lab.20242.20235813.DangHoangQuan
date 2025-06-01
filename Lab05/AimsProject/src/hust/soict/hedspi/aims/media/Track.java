package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class Track implements Playable{
    private String title;
    private int length;

    public Track() {
        this.title = "";
        this.length = 0;
    }

    public Track(String title) {
        this.title = title;
        this.length = 0;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public String toString() {
        return "Track: " + title + " - Length: " + length + " seconds";
    }

    public boolean isMatch(String title) {
        return this.title.equals(title);
    }

    @Override
    public String play() throws PlayerException {
        if (this.getLength() <= 0) {
        	System.err.println("ERROR: Track length is non-positive");
            throw new PlayerException("ERROR: DVD length is non-positive");
        }
        return "Playing DVD: " + this.getTitle() + "\n"
             + "DVD length: " + this.getLength() + " minutes";
    }



    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Track) {
            Track track = (Track) obj;
            return this.title.equals(track.title) && this.length == track.length;
        }
        return false;
    }
}
