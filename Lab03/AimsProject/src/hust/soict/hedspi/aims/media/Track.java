package hust.soict.hedspi.aims.media;

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

    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
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
