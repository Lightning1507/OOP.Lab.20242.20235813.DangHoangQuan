package hust.soict.hedspi.aims.screen.customer.controller;

import java.io.IOException;
import java.net.URL;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.EmptyCartException;
import hust.soict.hedspi.aims.exception.NotFoundException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {
    private Cart cart;
    private Store store;
    private FilteredList<Media> filteredMedia;

    public CartController(Cart cart) {
        this.cart = cart;
    }
    
    public CartController(Store store, Cart cart) {
		this.cart = cart;
		this.store = store;
	}
    
    @FXML
    private TextField tfFilter;
    
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Double> colMediaCost;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private Label costLabel;

    @FXML
    private ToggleGroup filterCategory;
    
    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;
    
    @FXML
    private TableView<Media> tblMedia;

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null && media instanceof Playable) {
            try {
                String playMessage = ((Playable) media).play();
                showAlert(Alert.AlertType.INFORMATION, "Playing Media", playMessage);
            } catch (Exception e) {
                showAlert(Alert.AlertType.ERROR, "Play Error", e.getMessage());
            }
        }
    }
    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    void btnRemovePressed(ActionEvent event) throws NotFoundException {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);
            updateCost();
            showAlert(Alert.AlertType.INFORMATION, "Removed", "The media " + media.getTitle() + " has been removed from the cart.");
        } else {
            showAlert(Alert.AlertType.WARNING, "No Selection", "Please select a media item to remove.");
            throw new NotFoundException("No media selected to remove.");
        }
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        if (store == null || cart == null) {
            System.err.println("Store or Cart is null!");
            return;
        }
        
        try {
            final String CART_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
            URL location = getClass().getResource(CART_FXML_FILE_PATH);
            if (location == null) {
                System.err.println("FXML file not found at: " + CART_FXML_FILE_PATH);
                return;
            }
            
            FXMLLoader fxmlLoader = new FXMLLoader(location);
            ViewStoreController controller = new ViewStoreController(store, cart);
            fxmlLoader.setController(controller);
            
            Parent root = fxmlLoader.load();
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Store");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    void updateButtonBar(Media media) {
        if (media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        }
        else {
            btnRemove.setVisible(true);
            if (media instanceof Playable) {
                btnPlay.setVisible(true);
            }
            else {
                btnPlay.setVisible(false);
            }
        }
    }
    
    @FXML
    public void initialize() {
        // Initialize columns
        colMediaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        
        // Initialize filtered list
        filteredMedia = new FilteredList<>(cart.getItemsOrdered(), p -> true); 
        tblMedia.setItems(filteredMedia); 
        
        
        radioBtnFilterId.setToggleGroup(filterCategory);
        radioBtnFilterTitle.setToggleGroup(filterCategory);
        radioBtnFilterTitle.setSelected(true); 
        
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        
        // Selection listener
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> updateButtonBar(newValue)
        );
        
        // Filter text field listener
        tfFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            showFilteredMedia(newValue);
        });
        
        // Radio button listener
        filterCategory.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            showFilteredMedia(tfFilter.getText());
        });
        
        updateCost();
    }
    
    private void showFilteredMedia(String filter) {
        if (filter == null || filter.isEmpty()) {
            filteredMedia.setPredicate(media -> true);
            return;
        }
        
        String lowerCaseFilter = filter.toLowerCase();
        
        if (radioBtnFilterId.isSelected()) {
            // Filter by ID
            filteredMedia.setPredicate(media -> {
                try {
                    int filterId = Integer.parseInt(filter);
                    return media.getId() == filterId;
                } catch (NumberFormatException e) {
                    return false;
                }
            });
        } else if (radioBtnFilterTitle.isSelected()) {
            // Filter by title
            filteredMedia.setPredicate(media -> 
                media.getTitle().toLowerCase().contains(lowerCaseFilter)
            );
        } else {
            // Default filter (by title and category)
            filteredMedia.setPredicate(media -> 
                media.getTitle().toLowerCase().contains(lowerCaseFilter) ||
                media.getCategory().toLowerCase().contains(lowerCaseFilter)
            );
        }
    }
    @FXML
    void btnPlaceOrder(ActionEvent event) {
    	if (cart.getItemsOrdered().isEmpty()) {
    		showAlert(Alert.AlertType.WARNING, "Empty Cart", "Your cart is empty. Please add items to your cart before placing an order.");
		} else {
			// Logic to place the order
			showAlert(Alert.AlertType.INFORMATION, "Order Placed", "Your order has been successfully placed!");
			cart.getItemsOrdered().clear(); 
			updateCost();
		}
    }
    private void updateCost() {
        float total = cart.totalCost();
        costLabel.setText(String.format("%.2f $", total));
    }
}