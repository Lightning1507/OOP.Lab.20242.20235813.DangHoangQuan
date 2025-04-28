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
		if (obj instanceof Media) {
			Media media = (Media) obj;
			return this.title.equals(media.title);
		}
		return false;
	}

	@Override
	public String toString() {
		return "Media [id=" + id + ", title=" + title + ", category=" + category + ", cost=" + cost + "]";
	}
}

