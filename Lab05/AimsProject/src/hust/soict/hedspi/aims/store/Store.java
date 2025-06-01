package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;

import javax.naming.LimitExceededException;

public class Store {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	public void addMedia(Media media) throws LimitExceededException {
		if (itemsInStore.size() >= MAX_NUMBERS_ORDERED) {
			throw new LimitExceededException("The store is full. Cannot add more media.");
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
