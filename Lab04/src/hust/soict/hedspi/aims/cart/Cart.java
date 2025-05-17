package hust.soict.hedspi.aims.cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import java.util.*;

public class Cart {

	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

	public ArrayList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	public void addMedia(Media media) {
		if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full");
			return;
		}
		itemsOrdered.add(media);
		System.out.println("The media has been added");
	}

	public void removeMedia(Media media) {
		if (itemsOrdered.remove(media)) {
			System.out.println("The media has been removed");
		} else {
			System.out.println("The media was not found in the cart");
		}
	}

	public float totalCost() {
		float sum=0;
		for (Media item : itemsOrdered) {
			sum += item.getCost();
		}
		return sum;
	}
}
