package hust.soict.hedspi.aims.media;
import java.util.*;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();

	public List<String> getAuthors() {
		return authors;
	}
	
	public void addAuthor(String authorName) {
		int tmp = authors.indexOf(authorName);
		if (tmp !=-1) {
			return;
		}
		authors.add(authorName);
	}
	public void removeAuthor(String authorName) {
		int tmp = authors.indexOf(authorName);
		if (tmp == -1) {
			return;
		}
		authors.remove(authorName);
	}
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String title) {
		super(title,0);
	}
	public Book(String title, String category) {
		super(title, category,0);
	}
	public Book(String title, String category, float cost) {
		super(title, category, cost,0);
	}
	public Book(String title, String category, float cost, List<String> authors) {
		super(title, category, cost,0);
		this.authors = authors;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getId()).append(". Book - ").append(getTitle()).append(" - ").append(getCategory()).append(" - ");
		sb.append(getCost()).append("$\n");
		sb.append("Authors: ");
		for (String author : authors) {
			sb.append(author).append(", ");
		}
		if (authors.size() > 0) {
			sb.setLength(sb.length() - 2); // Remove the last comma and space
		}
		return sb.toString();
	}
}
