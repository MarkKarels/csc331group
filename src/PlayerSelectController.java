import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



public class PlayerSelectController {
    // instance variables for interacting with GUI
    @FXML private ListView<Player> playerListView;
    @FXML private ImageView playerImageView;

    // stores the list of Player Objects
    private final ObservableList<Player> player = FXCollections.observableArrayList();

    // initialize controller
    public void initialize() {
        // populate the ObservalbeList<Player>
        player.add(new Player("Justin Fields", "/images/small/JustinFields.jpg", "/images/large/JustinFields.jpg"));
        player.add(new Player("Tom Brady", "/images/small/TomBrady.jpg", "/images/large/TomBrady.jpg"));
        player.add(new Player("Kirk Cousins", "/images/small/KirkCousins.jpg", "/images/large/KirkCousins.jpg"));
        player.add(new Player("Patrick Mahomes", "/images/small/PatrickMahomes.jpg", "/images/large/PatrickMahomes.jpg"));
        player.add(new Player("Justin Herbert", "/images/small/JustinHerbert.jpg", "/images/large/JustinHerbert.jpg"));
        playerListView.setItems(player);

        playerListView.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Player>() {
                    @Override
                    public void changed(ObservableValue<? extends Player> observableValue, Player oldValue,
                                        Player newValue) {
                        playerImageView.setImage( new Image(newValue.getLargeImage()));
                    }
                }
        );
    }
}
