/**
 * Goto https://fantasy.espn.com/football/players/projections for player stats
 */

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
import javafx.scene.control.TextArea;
import java.util.List;


public class PlayerSelectController {
    // instance variables for interacting with GUI
    @FXML private ListView<Player> playerListView;
    @FXML private ImageView playerImageView;
    @FXML private TextArea detailedText;
    // stores the list of Player Objects
    private final ObservableList<Player> player = FXCollections.observableArrayList();

    @FXML
    void selectPlayerButtonPress(ActionEvent event) {

    }

    @FXML
    void viewTeamButtonPress(ActionEvent event) {

    }

    @FXML
    void defButtonPress(ActionEvent event) {
        // populate the ObservableList<Player>
        playerListView.getItems().clear();
        player.add(new Player("Chicago Bears", "Chicago Bears", "/images/small/ChicagoBears.jpg",
                "/images/large/ChicagoBears.jpg", 105.0, 90.8));
        player.add(new Player("Carolina Panthers", "Carolina Panthers", "/images/small/CarolinaPanthers.png",
                "/images/large/CarolinaPanthers.png", 88.0, 99.69));
        player.add(new Player("Houston Texans", "Houston Texans", "/images/small/HoustonTexans.jpg",
                "/images/large/HoustonTexans.jpg", 58.0, 56.35));
        player.add(new Player("Los Angeles Rams", "Los Angeles Rams", "/images/small/LARams.jpg",
                "/images/large/LARams.jpg", 105.0, 94.1));
        player.add(new Player("BuffaloBills", "Buffalo Bills", "/images/small/BuffaloBills.jpg",
                "/images/large/BuffaloBills.jpg", 154.0, 129.83));
        playerListView.setItems(player);
    }

    @FXML
    void kButtonPress(ActionEvent event) {
        // populate the ObservableList<Player>
        playerListView.getItems().clear();
        player.add(new Player("Cairo Santos", "Chicago Bears", "/images/small/CairoSantos.jpg",
                "/images/large/CairoSantos.jpg", 112.0, 123.64));
        player.add(new Player("Justin Tucker", "Baltimore Ravens", "/images/small/JustinTucker.jpg",
                "/images/large/JustinTucker.jpg", 161.0, 140.14));
        player.add(new Player("Jason Sanders", "Miami Dolphins", "/images/small/JasonSanders.jpg",
                "/images/large/JasonSanders.jpg", 107.0, 109.77));
        player.add(new Player("Harrison Butker", "Kansas City Chiefs", "/images/small/HarrisonButker.jpg",
                "/images/large/HarrisonButker.jpg", 137.0, 145.51));
        player.add(new Player("Robbie Gould", "San Francisco 49ers", "/images/small/RobbieGould.jpg",
                "/images/large/RobbieGould.jpg", 109.0, 130.86));
        playerListView.setItems(player);
    }

    @FXML
    void qbButtonPress(ActionEvent event) {
        // populate the ObservableList<Player>
        playerListView.getItems().clear();
        player.add(new QB("Justin Fields", "Chicago Bears", "/images/small/JustinFields.jpg",
                "/images/large/JustinFields.jpg", 126.8, 255.92, 3625.0, 19,
                15, 99, 578.0, 3));
        player.add(new QB("Tom Brady", "Tampa Bay Buccaneers", "/images/small/TomBrady.jpg",
                "/images/large/TomBrady.jpg", 374.74, 315.13, 4485.0, 36,
                12, 29, 56.0, 2));
        player.add(new QB("Kirk Cousins", "Minnesota Vikings", "/images/small/KirkCousins.jpg",
                "/images/large/KirkCousins.jpg", 300.34, 279.57, 4108.0, 27,
                10, 29, 104.0, 1));
        player.add(new QB("Patrick Mahomes", "Kansas City Chiefs", "/images/small/PatrickMahomes.jpg",
                "/images/large/PatrickMahomes.jpg", 361.66, 353.84, 4683.0, 35,
                12, 64, 395.0, 3));
        player.add(new QB("Justin Herbert", "Los Angeles Chargers", "/images/small/JustinHerbert.jpg",
                "/images/large/JustinHerbert.jpg", 380.76, 329.13, 4338.0, 33,
                12, 60, 285, 3));
        playerListView.setItems(player);
    }

    @FXML
    void rbButtonPress(ActionEvent event) {
        // populate the ObservableList<Player>
        playerListView.getItems().clear();
        player.add(new Player("David Montgomery", "Chicago Bears", "/images/small/DavidMontgomery.jpg",
                "/images/large/DavidMontgomery.jpg", 195.0, 241.64));
        player.add(new Player("Christian McCaffrey", "Carolina Panthers", "/images/small/ChristianMcCaffrey.jpg",
                "/images/large/ChristianMcCaffrey.jpg", 127.5, 301.6));
        player.add(new Player("Nick Chubb", "Cleveland Browns", "/images/small/NickChubb.jpg",
                "/images/large/NickChubb.jpg", 215.3, 213.82));
        player.add(new Player("Derrick Henry", "Tennessee Titans", "/images/small/DerrickHenry.jpg",
                "/images/large/DerrickHenry.jpg", 193.3, 275.78));
        player.add(new Player("Jonathan Taylor", "Indianapolis Colts", "/images/small/JonathanTaylor.jpg",
                "/images/large/JonathanTaylor.jpg", 373.1, 316.27));
        playerListView.setItems(player);
    }

    @FXML
    void teButtonPress(ActionEvent event) {
        // populate the ObservableList<Player>
        playerListView.getItems().clear();
        player.add(new Player("Cole Kmet", "Chicago Bears", "/images/small/ColeKmet.jpg",
                "/images/large/ColeKmet.jpg", 121.2, 136.59));
        player.add(new Player("Travis Kelce", "Kansas City Chiefs", "/images/small/TravisKelce.jpg",
                "/images/large/TravisKelce.jpg", 262.8, 240.65));
        player.add(new Player("Darren Waller", "Las Vegas Raiders", "/images/small/DarrenWaller.jpg",
                "/images/large/DarrenWaller.jpg", 133.5, 195.33));
        player.add(new Player("George Kittle", "San Francisco 49ers", "/images/small/GeorgeKittle.jpg",
                "/images/large/GeorgeKittle.jpg", 198.0, 181.57));
        player.add(new Player("Mark Andrews", "Baltimore Ravens", "/images/small/MarkAndrews.jpg",
                "/images/large/MarkAndrews.jpg", 301.1, 254.12));
        playerListView.setItems(player);
    }

    @FXML
    void wrButtonPress(ActionEvent event) {
        // populate the ObservableList<Player>
        playerListView.getItems().clear();
        player.add(new Player("DeVante Adams", "Las Vegas Raiders", "/images/small/DeVanteAdams.jpg",
                "/images/large/DeVanteAdams.jpg", 344.3, 260.95));
        player.add(new Player("Tyreek Hill", "Miami Dolphins", "/images/small/TyreekHill.jpg",
                "/images/large/TyreekHill.jpg", 296.5, 257.2));
        player.add(new Player("DK Metcalf", "Seattle Seahawks", "/images/small/DKMetcalf.jpg",
                "/images/large/DKMetcalf.jpg", 244.3, 239.15));
        player.add(new Player("DeAndre Hopkins", "Arizona Cardinals", "/images/small/DeAndreHopkins.jpg",
                "/images/large/DeAndreHopkins.jpg", 147.2, 234.13));
        player.add(new Player("Ja'Marr Chase", "Cincinnati Bengals", "/images/small/JaMarrChase.jpg",
                "/images/large/JaMarrChase.jpg", 304.6, 287.47));
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
                        detailedText.setText(newValue.toString());
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
