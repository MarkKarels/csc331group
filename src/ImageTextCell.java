import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

/** ImageTextCell.java defines the custom ListView for how each cell will
 * look in the "Available Players" section of the draft
 * For Player Stats, visit: https://fantasy.espn.com/football/players/projections
 */

public class ImageTextCell extends ListCell<Player>{
    private VBox vbox = new VBox(8.0); // 8 points of gap between controls
    private ImageView thumbImageView = new ImageView(); // initially empty
    private Label label = new Label();

    // constructor for configuring the VBox, Imageview, and Label
    public ImageTextCell() {
        vbox.setAlignment(Pos.CENTER); // center VBox contents horizontally

        thumbImageView.setPreserveRatio(true);
        thumbImageView.setFitHeight(100.0);
        vbox.getChildren().add(thumbImageView);

        label.setWrapText(true);
        label.setTextAlignment(TextAlignment.CENTER);
        vbox.getChildren().add(label);

        setPrefWidth(USE_PREF_SIZE);
    }

    /** Method updateItem is called to configure each ListView cell
     * @param item Player object
     * @param empty boolean for whether the cell is empty
     */
    @Override
    protected void updateItem(Player item, boolean empty) {
        // required to ensure that cell displays properly
        super.updateItem(item, empty);

        if (empty || item == null) {
            setGraphic(null); // don't display anything
        }
        else {
            // set ImageView's thumbnail image
            thumbImageView.setImage(new Image(item.getThumbImage()));
            label.setText(item.getPlayer());
            setGraphic(vbox);
        }
    }
}
