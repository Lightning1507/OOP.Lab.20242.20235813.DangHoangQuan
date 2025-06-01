package hust.soict.hedspi.aims.cart;
import hust.soict.hedspi.aims.exception.NotFoundException;
import hust.soict.hedspi.aims.exception.LimitExceededException;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;

public class Cart {

	public static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	public void addMedia(Media media) throws LimitExceededException {
		if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
			throw new LimitExceededException("The cart is full. Cannot add more media.");
		}
		itemsOrdered.add(media);
		System.out.println("The media has been added");
	}

	public void removeMedia(Media media) throws NotFoundException {
		if (itemsOrdered.remove(media)) {
			System.out.println("The media has been removed");
		} else {
			throw new NotFoundException("The media is not found in the cart");
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
