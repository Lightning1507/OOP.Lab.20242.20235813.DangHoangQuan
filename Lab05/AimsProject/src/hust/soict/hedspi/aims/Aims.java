package hust.soict.hedspi.aims;

import java.util.*;
import java.util.Collections;

import javax.naming.LimitExceededException;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.media.Media;

public class Aims {
	private static final java.util.Scanner scanner = new java.util.Scanner(System.in);
	private static final Store store = new Store();
	private static final Cart cart = new Cart();

	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}

	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}

	
	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter media in cart");
		System.out.println("2. Sort media in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}


	public static void main (String[] args) throws PlayerException, LimitExceededException {
		initializeStore();
		int choice;
		do{
			showMenu();
			choice = scanner.nextInt();
			scanner.nextLine();
			switch(choice){
				case 1:
					System.out.println("View store");
					System.out.println("Available media in store: ");

					for (Media media : store.getItemsInStore()) {
						System.out.println(media.toString());
					}
					storeMenu();
					int storeChoice = scanner.nextInt();
					scanner.nextLine();
					switch(storeChoice){
						case 1:
							System.out.println("See a media’s details");
							System.out.println("Enter media title: ");
							String title = scanner.nextLine();
							Media foundMedia = null;
							for (Media media : store.getItemsInStore()) {
								if (media.getTitle().equalsIgnoreCase(title)) {
									foundMedia = media;
									break;
								}
							}
							if (foundMedia == null) {
								System.out.println("Media not found.");
								break;
							}
							System.out.println("Media details: " + foundMedia.toString());
							mediaDetailsMenu();
							int mediaChoice = scanner.nextInt();
							scanner.nextLine();
							switch(mediaChoice){
								case 1:
									System.out.println("Add to cart");
									cart.addMedia(foundMedia);
									break;
								case 2:
									System.out.println("Play");
									if (foundMedia instanceof Book) {
										System.out.println("Books cannot be played.");
									} else if (foundMedia instanceof Playable) {
										((Playable) foundMedia).play();
									} else {
										System.out.println("This media cannot be played.");
									}
									break;
								case 0:
									System.out.println("Back to store menu");
									break;
								default:
									System.out.println("Invalid choice. Please try again.");
									break;
							}
							break;
						case 2:
							System.out.println("Add a media to cart");
							System.out.println("Available media in store: ");
							for (Media media : store.getItemsInStore()) {
								System.out.println(media.toString());
							}
							System.out.println("Enter media title: ");
							String mediaTitle = scanner.nextLine();
							Media mediaToAdd = null;
							for (Media media : store.getItemsInStore()) {
								if (media.getTitle().equalsIgnoreCase(mediaTitle)) {
									mediaToAdd = media;
									break;
								}
							}
							if (mediaToAdd == null) {
								System.out.println("Media not found.");
								break;
							}
							cart.addMedia(mediaToAdd);
							System.out.println("Added \"" + mediaToAdd.getTitle() + "\" to cart.");
							int dvdCount = 0;
							for (Media item : cart.getItemsOrdered()) {
								if (item instanceof DigitalVideoDisc) {
									dvdCount++;
								}
							}
							System.out.println("Current cart has " + dvdCount + " DVD(s)");
							break;
						case 3:
							System.out.println("Play a media");
							System.out.println("Available media in store: ");
							for (Media media : store.getItemsInStore()) {
								System.out.println(media.toString());
							}
							System.out.println("Enter media title: ");
							String playTitle = scanner.nextLine();
							Media mediaToPlay = null;
							for (Media media : store.getItemsInStore()) {
								if (media.getTitle().equalsIgnoreCase(playTitle)) {
									mediaToPlay = media;
									break;
								}
							}
							if (mediaToPlay == null) {
								System.out.println("Media not found.");
								break;
							}
							if (mediaToPlay instanceof Playable) {
								((Playable) mediaToPlay).play();
							} else {
								System.out.println("This media cannot be played.");
							}
							break;
						case 4:
							System.out.println("See current cart");
							for (Media media : cart.getItemsOrdered()) {
								System.out.println(media.toString());
							}
							break;
						case 0:
							System.out.println("Back to main menu");
							break;
						default:
							System.out.println("Invalid choice. Please try again.");
							break;
					}
					break;
				case 2:
					System.out.println("Update store");
					System.out.println("Available media in store: ");
					for (Media media : store.getItemsInStore()) {
						System.out.println(media.toString());
					}
					System.out.println("--------------------------------");
					System.out.println("1. Add a media");
					System.out.println("2. Remove a media");
					System.out.println("0. Back");
					System.out.println("--------------------------------");
					int updateChoice = scanner.nextInt();
					scanner.nextLine();
					switch(updateChoice){
						case 1:
							System.out.println("Add a media");
							System.out.println("Enter media title: ");
							String newTitle = scanner.nextLine();
							System.out.println("Enter media category: ");
							String newCategory = scanner.nextLine();
							System.out.println("Enter media cost: ");
							float newCost = scanner.nextFloat();
							scanner.nextLine();
							DigitalVideoDisc newMedia = new DigitalVideoDisc(newTitle, newCategory, newCost);
							store.addMedia(newMedia);
							System.out.println("Added \"" + newMedia.getTitle() + "\" to store.");
							break;
						case 2:
							System.out.println("Remove a media");
							System.out.println("Enter media title: ");
							String removeTitle = scanner.nextLine();
							Media mediaToRemove = null;
							for (Media media : store.getItemsInStore()) {
								if (media.getTitle().equalsIgnoreCase(removeTitle)) {
									mediaToRemove = media;
									break;
								}
							}
							if (mediaToRemove == null) {
								System.out.println("Media not found.");
								break;
							}
							store.removeMedia(mediaToRemove);
							System.out.println("Removed \"" + mediaToRemove.getTitle() + "\" from store.");
							break;
						case 0:
							System.out.println("Back to main menu");
							break;
						default:
							System.out.println("Invalid choice. Please try again.");
					}
					break;
				case 3:
					System.out.println("See current cart");
					System.out.println("Available media in cart: ");
					for (Media media : cart.getItemsOrdered()) {
						System.out.println(media.toString());
					}
					cartMenu();
					int cartChoice = scanner.nextInt();
					scanner.nextLine();
					switch(cartChoice) {
						case 1:
							System.out.println("Filter media in cart");
							System.out.println("--------------------------------");
							System.out.println("1. Filter by title");
							System.out.println("2. Filter by id");
							System.out.println("0. Back");
							System.out.println("--------------------------------");
							int filterChoice = scanner.nextInt();
							scanner.nextLine();
							switch (filterChoice) {
								case 1:
									System.out.println("Filter by title");
									System.out.println("Enter title to filter: ");
									String filterTitle = scanner.nextLine();
									System.out.println("Filtered media: ");
									boolean foundTitle = false;
									for (Media media : cart.getItemsOrdered()) {
										if (media.getTitle().toLowerCase().contains(filterTitle.toLowerCase())) {
											System.out.println(media.toString());
											foundTitle = true;
										}
									}
									if (!foundTitle) {
										System.out.println("No media found.");
									}
									
									break;
								case 2:
									System.out.println("Filter by id");
									System.out.println("Enter id to filter: ");
									String filterId = scanner.nextLine();
									System.out.println("Filtered media: ");
									boolean foundId = false;
									for (Media media : cart.getItemsOrdered()) {
										if (String.valueOf(media.getId()).contains(filterId)) {
											System.out.println(media.toString());
											foundId = true;
										}
									}
									if (!foundId) {
										System.out.println("No media found.");
									}
									break;
								case 0:
									System.out.println("Back to cart menu");
									break;
								default:
									System.out.println("Invalid choice. Please try again.");
							}
							break;
						case 2:
							System.out.println("Sort media in cart");
							System.out.println("--------------------------------");
							System.out.println("1. Sort by title");
							System.out.println("2. Sort by cost");
							System.out.println("0. Back");
							System.out.println("--------------------------------");
							int sortChoice = scanner.nextInt();
							scanner.nextLine();
							switch (sortChoice) {
								case 1:
									Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);
									System.out.println("Sorted cart by title:");
									for (Media media : cart.getItemsOrdered()) {
										System.out.println(media.toString());
									}
									break;
								case 2:
									Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
									System.out.println("Sorted cart by cost:");
									for (Media media : cart.getItemsOrdered()) {
										System.out.println(media.toString());
									}
									break;
								case 0:
									System.out.println("Back to cart menu");
									break;
								default:
									System.out.println("Invalid choice. Please try again.");
							}
							break;
						case 3:
							System.out.println("Remove media from cart");
							System.out.println("Enter media title to remove: ");
							String removeTitleFromCart = scanner.nextLine();
							Media mediaToRemoveFromCart = null;
							for (Media media : cart.getItemsOrdered()) {
								if (media.getTitle().equalsIgnoreCase(removeTitleFromCart)) {
									mediaToRemoveFromCart = media;
									break;
								}
							}
							if (mediaToRemoveFromCart == null) {
								System.out.println("Media not found in cart.");
								break;
							}
							cart.removeMedia(mediaToRemoveFromCart);
							System.out.println("Removed \"" + mediaToRemoveFromCart.getTitle() + "\" from cart.");
							break;
						case 4:
							System.out.println("Play a media");
							System.out.println("Available media in cart: ");
							for (Media media : cart.getItemsOrdered()) {
								System.out.println(media.toString());
							}
							System.out.println("Enter media title: ");
							String playTitleFromCart = scanner.nextLine();
							Media mediaToPlayFromCart = null;
							for (Media media : cart.getItemsOrdered()) {
								if (media.getTitle().equalsIgnoreCase(playTitleFromCart)) {
									if (media instanceof Book) {
										System.out.println("Books cannot be played.");
										break;
									}
									mediaToPlayFromCart = media;
									break;
								}
							}
							if (mediaToPlayFromCart == null) {
								System.out.println("Media not found in cart.");
								break;
							}
							if (mediaToPlayFromCart instanceof Playable) {
								((Playable) mediaToPlayFromCart).play();
							} else {
								System.out.println("This media cannot be played.");
							}
							break;
						case 5:
							System.out.println("Place order");
							System.out.println("Total cost: " + cart.totalCost());
							System.out.println("Order placed successfully.");
							cart.getItemsOrdered().clear();
							System.out.println("Cart has been cleared.");
							break;
						case 0:
							System.out.println("Back to main menu");
							break;
					}
					break;
				case 0:
					System.out.println("Exiting...");
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
					break;
			}
		} while(choice != 0);
	}

	private static void initializeStore() throws LimitExceededException {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "Antoine Galland",100, 18.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 24.99f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Shawshank Redemption", "Drama", "Frank Darabont", 142, 21.99f);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("Toy Story", "Animation", "John Lasseter", 81, 19.99f);

		Book book1 = new Book("Harry Potter", "Fantasy", 29.99f);
		Book book2 = new Book("The Hobbit", "Fantasy", 24.99f);
		Book book3 = new Book("1984", "Dystopian", 19.99f);
		Book book4 = new Book("To Kill a Mockingbird", "Fiction", 14.99f);
		Book book5 = new Book("The Great Gatsby", "Fiction", 18.99f);

		
		CompactDisc cd1 = new CompactDisc("The Beatles", "Music", "The Beatles", 19.99f);
		CompactDisc cd2 = new CompactDisc("Taylor Swift", "Music", "Taylor Swift", 14.99f);
		CompactDisc cd3 = new CompactDisc("21", "Music", "Adele", 16.99f);
		CompactDisc cd4 = new CompactDisc("Thriller", "Music", "Michael Jackson", 17.99f);
		CompactDisc cd5 = new CompactDisc("Back in Black", "Music", "AC/DC", 15.99f);
		CompactDisc cd6 = new CompactDisc("Born to Run", "Music", "Bruce Springsteen", 16.99f);

		Track track1 = new Track("Track 1", 3);
		Track track2 = new Track("Track 2", 4);
		Track track3 = new Track("Track 3", 5);
		Track track4 = new Track("Billie Jean", 4);
		Track track5 = new Track("Thunder Road", 5);
		Track track6 = new Track("Highway to Hell", 3);
		

        
		cd1.addTrack(track1);
		cd1.addTrack(track2);
		cd2.addTrack(track3);
		cd3.addTrack(track1);
		cd3.addTrack(track2);
		cd3.addTrack(track3);
		cd4.addTrack(track4);
		cd4.addTrack(track1);
		cd5.addTrack(track6);
		cd5.addTrack(track2);
		cd6.addTrack(track5);
		cd6.addTrack(track3);
		
		
		store.addMedia(dvd1);
		store.addMedia(dvd2);
		store.addMedia(dvd3);
		store.addMedia(dvd4);
		store.addMedia(dvd5);
		store.addMedia(dvd6);
		store.addMedia(book1);
		store.addMedia(book2);
		store.addMedia(book3);
		store.addMedia(book4);
		store.addMedia(book5);
		store.addMedia(cd1);
		store.addMedia(cd2);
		store.addMedia(cd3);
		store.addMedia(cd4);
		store.addMedia(cd5);
		store.addMedia(cd6);

	}

}