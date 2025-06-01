package hust.soict.hedspi.aims.media;

import java.util.*;

public abstract class Media {
	private int id;
	private String title;
	private String category;
	private float cost;
	private static int nbMedia = 0;

	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}

	public Media() {
		// TODO Auto-generated constructor stub
	}

	public Media(String title, int id) {
		this.title = title;
		nbMedia++;
		this.id = nbMedia;
	}

	public Media(String title, String category, int id) {
		this.title = title;
		this.category = category;
		nbMedia++;
		this.id = nbMedia;
	}

	public Media(String title, String category, float cost, int id) {
		this.title = title;
		this.category = category;
		this.cost = cost;
		nbMedia++;
		this.id = nbMedia;
	}

	@Override
	public boolean equals(Object obj) {
	    // Check if comparing with itself
	    if (this == obj) {
	        return true;
	    }
	    
	    // Check for null and class type
	    if (obj == null || !(obj instanceof Media)) {
	        return false;
	    }
	    
	    // Cast and compare fields
	    Media other = (Media) obj;
	    return (this.title == null ? other.title == null : this.title.equals(other.title)) &&
	           Double.compare(this.cost, other.cost) == 0;
	}

	public int compareTo(Media other) {
	    // Check for null
	    if (other == null) {
	        throw new NullPointerException("Cannot compare with null");
	    }
	    
	    // First compare by title
	    int titleComparison;
	    if (this.title == null && other.title == null) {
	        titleComparison = 0;
	    } else if (this.title == null) {
	        titleComparison = -1;
	    } else if (other.title == null) {
	        titleComparison = 1;
	    } else {
	        titleComparison = this.title.compareTo(other.title);
	    }
	    
	    // If titles are equal, compare by cost
	    if (titleComparison != 0) {
	        return titleComparison;
	    }
	    
	    return Double.compare(this.cost, other.cost);
	}

	@Override
	public String toString() {
		return "Media [id=" + id + ", title=" + title + ", category=" + category + ", cost=" + cost + "]";
	}
}

