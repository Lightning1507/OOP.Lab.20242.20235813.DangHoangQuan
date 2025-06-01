package hust.soict.hedspi.test.screen.customer.cart;

import javax.naming.LimitExceededException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.screen.customer.controller.CartController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestCart extends Application {
    
    private static Cart cart;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Initialize the cart with some test items
        initializeCart();
        
        // Load the FXML file and set the controller
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/hedspi/aims/screen/customer/view/Cart.fxml"));
        CartController controller = new CartController(cart);
        loader.setController(controller);
        Parent root = loader.load();
        
        // Set up the stage
        primaryStage.setTitle("Shopping Cart");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    
    private void initializeCart() throws LimitExceededException {
        cart = new Cart();
        
        // Add some test media to the cart
        Media dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        Media dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        Media cd1 = new CompactDisc("Thriller", "Pop", "Michael Jackson", 15.99f);
        Media book1 = new Book("Harry Potter", "Fantasy", 12.99f);
        
        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(cd1);
        cart.addMedia(book1);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}