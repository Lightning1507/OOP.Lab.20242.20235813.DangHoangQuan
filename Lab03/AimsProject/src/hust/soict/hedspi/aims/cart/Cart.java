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




//	public void getDetail() {
//		System.out.println("The current cart: ");
//		for (int i=0;i<qtyOrdered;++i) {
//			System.out.print(itemsOrdered[i].getTitle());
//			System.out.print(", ");
//			System.out.print(itemsOrdered[i].getCategory());
//			System.out.print(", ");
//			System.out.print(itemsOrdered[i].getDirector());
//			System.out.print(", ");
//			System.out.print(itemsOrdered[i].getLength());
//			System.out.print(", ");
//			System.out.print(itemsOrdered[i].getCost());
//			System.out.println();
//		}
//	}
//	public void print() {
//		float s=0;
//		System.out.println("***********************CART***********************");
//		System.out.println("Ordered Items:");
//		for (int i=0; i<qtyOrdered;++i) {
//			System.out.println(itemsOrdered[i].toString());
//			s+=itemsOrdered[i].getCost();
//		}
//		System.out.println("Total cost: " + s);
//		System.out.println("***************************************************");
//	}
//
//	public void SearchDVDs(int ID) {
//		for (int i=0;i <qtyOrdered;++i) {
//			if (itemsOrdered[i].getId() == ID) {
//				System.out.println(itemsOrdered[i].toString());
//				return;
//			}
//		}
//		System.out.println("NOT FOUND");
//	}
//	public void SearchDVDs(String title) {
//		for (int i=0;i < qtyOrdered; ++i) {
//			if (itemsOrdered[i].isMatch(title)) {
//				System.out.println(itemsOrdered[i].toString());
//				return;
//			}
//		}
//		System.out.println("NOT FOUND");
//	}
}
