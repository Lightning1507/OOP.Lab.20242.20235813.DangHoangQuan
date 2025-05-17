package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;

public class Store {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	public void addMedia(Media media) {
		if (itemsInStore.size() >= MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full");
			return;
		}
		itemsInStore.add(media);
		System.out.println("The media has been added");
	}

	public void removeMedia(Media media) {
		if (itemsInStore.remove(media)) {
			System.out.println("The media has been removed");
		} else {
			System.out.println("The media was not found in the cart");
		}
	}

	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}

}
