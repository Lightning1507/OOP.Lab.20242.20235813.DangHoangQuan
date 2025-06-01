package hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;


public class PainterController {
    @FXML
    private ToggleGroup PenandEraser;

    @FXML
    private Pane drawingAreaPane;
    
    @FXML
    private RadioButton eraser;

    @FXML
    private RadioButton pen;
    
    @FXML
    void initialize() {
        // Set user data for toggle buttons
        pen.setUserData("pen");
        eraser.setUserData("eraser");
    }
    
    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Color drawColor = Color.BLACK; // Default to pen color

        if (PenandEraser.getSelectedToggle() != null) {
            String mode = PenandEraser.getSelectedToggle().getUserData().toString();
            if ("eraser".equals(mode)) {
                drawColor = Color.WHITE; // Canvas background color
            }
        }

        Circle newCircle = new Circle(event.getX(), event.getY(), 4, drawColor);
        drawingAreaPane.getChildren().add(newCircle);
    }


}
