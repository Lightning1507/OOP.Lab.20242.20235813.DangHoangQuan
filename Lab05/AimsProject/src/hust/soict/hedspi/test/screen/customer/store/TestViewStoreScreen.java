package hust.soict.hedspi.test.screen.customer.store;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application{
	public static Store store;
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
		Cart cart = new Cart();
		ViewStoreController viewStoreController = new ViewStoreController(store);
		fxmlLoader.setController(viewStoreController);
		Parent root = fxmlLoader.load();
		
		primaryStage.setTitle("Store");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	public static void main(String[] args) {
		store = new Store();
		try {
		
			DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
			DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
			DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "Antoine Galland",-100, 18.99f);
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
			
	        CompactDisc cd = new CompactDisc("Supernatural", "Music", "NewJeans", 59.99f);
	        cd.addTrack(new Track("Supernatural", 200));
	        cd.addTrack(new Track("Right Now", 180));
	        store.addMedia(cd);
	        
			cd1.addTrack(track1);
			cd1.addTrack(track2);
//			cd2.addTrack(track3);
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
		} catch (Exception e) {
			System.out.println("Error adding media to store: " + e.getMessage());
		}
		
		launch(args);
	}
}
