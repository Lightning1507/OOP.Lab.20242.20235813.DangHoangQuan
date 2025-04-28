package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {

	public DigitalVideoDisc() {
		super();
	}

	public DigitalVideoDisc(String title) {
		super(title);
	}
	
	public DigitalVideoDisc(String title, String category) {
		super(title, category);
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
	}

	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
	}

	public String toString() {
		return getId() + ". DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - "
				+ getLength() + " - " + getCost() + "$";
	}

	public boolean isMatch(String title) {
		return this.getTitle().equals(title);
	}
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
}