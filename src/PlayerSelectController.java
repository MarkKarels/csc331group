import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import javafx.event.ActionEvent;
import java.util.List;


public class PlayerSelectController {
    // instance variables for interacting with GUI
    @FXML private ListView<Player> playerListView;
    @FXML private ImageView playerImageView;
    // stores the list of Player Objects
    private final ObservableList<Player> player = FXCollections.observableArrayList();

    @FXML
    void defButtonPress(ActionEvent event) {
        // populate the ObservableList<Player>
        playerListView.getItems().clear();
        player.add(new Player("Chicago Bears", "/images/small/ChicagoBears.jpg", "/images/large/ChicagoBears.jpg"));
        player.add(new Player("Carolina Panthers", "/images/small/CarolinaPanthers.png", "/images/large/CarolinaPanthers.png"));
        player.add(new Player("Houston Texans", "/images/small/HoustonTexans.jpg", "/images/large/HoustonTexans.jpg"));
        player.add(new Player("Los Angeles Rams", "/images/small/LARams.jpg", "/images/large/LARams.jpg"));
        player.add(new Player("BuffaloBills", "/images/small/BuffaloBills.jpg", "/images/large/BuffaloBills.jpg"));
        playerListView.setItems(player);
    }

    @FXML
    void kButtonPress(ActionEvent event) {
        // populate the ObservableList<Player>
        playerListView.getItems().clear();
        player.add(new Player("Cairo Santos", "/images/small/CairoSantos.jpg", "/images/large/CairoSantos.jpg"));
        player.add(new Player("Justin Tucker", "/images/small/JustinTucker.jpg", "/images/large/JustinTucker.jpg"));
        player.add(new Player("Jason Sanders", "/images/small/JasonSanders.jpg", "/images/large/JasonSanders.jpg"));
        player.add(new Player("Harrison Butker", "/images/small/HarrisonButker.jpg", "/images/large/HarrisonButker.jpg"));
        player.add(new Player("Robbie Gould", "/images/small/RobbieGould.jpg", "/images/large/RobbieGould.jpg"));
        playerListView.setItems(player);
    }

    @FXML
    void qbButtonPress(ActionEvent event) {
        // populate the ObservableList<Player>
        playerListView.getItems().clear();
        player.add(new Player("Justin Fields", "/images/small/JustinFields.jpg", "/images/large/JustinFields.jpg"));
        player.add(new Player("Tom Brady", "/images/small/TomBrady.jpg", "/images/large/TomBrady.jpg"));
        player.add(new Player("Kirk Cousins", "/images/small/KirkCousins.jpg", "/images/large/KirkCousins.jpg"));
        player.add(new Player("Patrick Mahomes", "/images/small/PatrickMahomes.jpg", "/images/large/PatrickMahomes.jpg"));
        player.add(new Player("Justin Herbert", "/images/small/JustinHerbert.jpg", "/images/large/JustinHerbert.jpg"));
        playerListView.setItems(player);
    }

    @FXML
    void rbButtonPress(ActionEvent event) {
        // populate the ObservableList<Player>
        playerListView.getItems().clear();
        player.add(new Player("David Montgomery", "/images/small/DavidMontgomery.jpg", "/images/large/DavidMontgomery.jpg"));
        player.add(new Player("Christian McCaffrey", "/images/small/ChristianMcCaffrey.jpg", "/images/large/ChristianMcCaffrey.jpg"));
        player.add(new Player("Nick Chubb", "/images/small/NickChubb.jpg", "/images/large/NickChubb.jpg"));
        player.add(new Player("Derrick Henry", "/images/small/DerrickHenry.jpg", "/images/large/DerrickHenry.jpg"));
        player.add(new Player("Jonathan Taylor", "/images/small/JonathanTaylor.jpg", "/images/large/JonathanTaylor.jpg"));
        playerListView.setItems(player);
    }

    @FXML
    void teButtonPress(ActionEvent event) {
        // populate the ObservableList<Player>
        playerListView.getItems().clear();
        player.add(new Player("Cole Kmet", "/images/small/ColeKmet.jpg", "/images/large/ColeKmet.jpg"));
        player.add(new Player("Travis Kelce", "/images/small/TravisKelce.jpg", "/images/large/TravisKelce.jpg"));
        player.add(new Player("Darren Waller", "/images/small/DarrenWaller.jpg", "/images/large/DarrenWaller.jpg"));
        player.add(new Player("George Kittle", "/images/small/GeorgeKittle.jpg", "/images/large/GeorgeKittle.jpg"));
        player.add(new Player("Mark Andrews", "/images/small/MarkAndrews.jpg", "/images/large/MarkAndrews.jpg"));
        playerListView.setItems(player);
    }

    @FXML
    void wrButtonPress(ActionEvent event) {
        // populate the ObservableList<Player>
        playerListView.getItems().clear();
        player.add(new Player("DeVante Adams", "/images/small/DeVanteAdams.jpg", "/images/large/DeVanteAdams.jpg"));
        player.add(new Player("Tyreek Hill", "/images/small/TyreekHill.jpg", "/images/large/TyreekHill.jpg"));
        player.add(new Player("DK Metcalf", "/images/small/DKMetcalf.jpg", "/images/large/DKMetcalf.jpg"));
        player.add(new Player("DeAndre Hopkins", "/images/small/DeAndreHopkins.jpg", "/images/large/DeAndreHopkins.jpg"));
        player.add(new Player("Ja'Marr Chase", "/images/small/JaMarrChase.jpg", "/images/large/JaMarrChase.jpg"));
        playerListView.setItems(player);
    }

    // initialize controller
    public void initialize() {
        playerListView.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Player>() {
                    @Override
                    public void changed(ObservableValue<? extends Player> observableValue, Player oldValue,
                                        Player newValue) {
                        playerImageView.setImage(new Image(newValue.getLargeImage()));
                    }
                }
        );
        playerListView.setCellFactory(new Callback<ListView<Player>, ListCell<Player>>() {
            @Override
            public ListCell<Player> call (ListView<Player> listView) {
                return new ImageTextCell();
            }
        });
    }
}
