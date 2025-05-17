package hust.soict.hedspi.aims.media;

public class Disc extends Media {
	private String director;
	private int length;

	public String getDirector() {
		return director;
	}

	public int getLength() {
		return length;
	}

	public Disc() {
		super();
	}
	
	public Disc(String title) {
		super(title,0);
	}
	
	public Disc(String title, String category) {
		super(title,category,0);
	}
	
	
	public Disc(String title, String category, float cost) {
		super(title, category, cost, 0);
	}

	public Disc(String title, String category, String director, float cost) {
		super(title, category, cost, 0);
		this.director = director;
	}

	public Disc(String title, String category, String director, int length, float cost) {
		super(title, category, cost, 0);
		this.director = director;
		this.length = length;
	}
}
