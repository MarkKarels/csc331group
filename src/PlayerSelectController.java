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
import java.util.Collections;
import java.util.Objects;
import javafx.scene.control.TextField;


public class PlayerSelectController {
    // instance variables for interacting with GUI
    @FXML private ListView<Player> playerListView;
    @FXML private ListView<Player> teamListView;
    @FXML private ImageView playerImageView;
    @FXML private TextArea myTeam;
    @FXML private TextArea playerStats;
    @FXML private TextField teamNameText;
    // stores the list of Player Objects
    private final ObservableList<Player> player = FXCollections.observableArrayList();
    private final ObservableList<Player> team = FXCollections.observableArrayList();
    DisplayTeam displayTeam = new DisplayTeam();

    Player[] QB = new Player[] {
        new QB("Justin Fields", "Chicago Bears", "/images/small/JustinFields.jpg",
              "/images/large/JustinFields.jpg", "QB", 126.8, 255.92, 3625.0,
              19, 15, 99, 578.0, 3),
        new QB("Tom Brady", "Tampa Bay Buccaneers", "/images/small/TomBrady.jpg",
              "/images/large/TomBrady.jpg", "QB", 374.74, 315.13, 4485.0,
              36, 12, 29, 56.0, 2),
        new QB("Kirk Cousins", "Minnesota Vikings", "/images/small/KirkCousins.jpg",
              "/images/large/KirkCousins.jpg", "QB", 300.34, 279.57, 4108.0,
              27, 10, 29, 104.0, 1),
        new QB("Patrick Mahomes", "Kansas City Chiefs", "/images/small/PatrickMahomes.jpg",
              "/images/large/PatrickMahomes.jpg", "QB", 361.66, 353.84,
              4683.0, 35, 12, 64, 395.0, 3),
        new QB("Justin Herbert", "Los Angeles Chargers", "/images/small/JustinHerbert.jpg",
              "/images/large/JustinHerbert.jpg", "QB", 380.76, 329.13, 4338.0,
              33, 12, 60, 285, 3),
        new QB("Aaron Rodgers", "Green Bay Packers", "/images/small/AaronRodgers.jpg",
              "/images/large/AaronRodgers.jpg", "QB", 333.3, 309.1, 4088.0,
              35, 7, 37, 131, 2),
        new QB("Josh Allen", "Buffalo Bills", "/images/small/JoshAllen.jpg",
              "/images/large/JoshAllen.jpg", "QB", 402.58, 375.29, 4113.0,
                35, 12, 64, 395, 3),
        new QB("Joe Burrow", "Cincinnati Bengals", "/images/small/JoeBurrow.jpg",
              "/images/large/JoeBurrow.jpg", "QB", 314.24, 298.53, 4208.0,
                31, 12, 52, 158, 3),
        new QB("Russell Wilson", "Denver Broncos", "/images/small/RussellWilson.jpg",
              "/images/large/RussellWilson.jpg", "QB", 242.82, 302.17, 4132,
                30, 10, 65, 287, 2),
        new QB("Matthew Stafford", "Los Angeles Rams", "/images/small/MatthewStafford.jpg",
              "/images/large/MatthewStafford.jpg", "QB", 329.74, 286.96, 4366.0,
                32, 14, 36, 64, 2)
    };

    Player[] RB = new Player[] {
        new Player("David Montgomery", "Chicago Bears", "/images/small/DavidMontgomery.jpg",
              "/images/large/DavidMontgomery.jpg", "RB", 195.0, 241.64),
        new Player("Christian McCaffrey", "Carolina Panthers", "/images/small/ChristianMcCaffrey.jpg",
              "/images/large/ChristianMcCaffrey.jpg", "RB", 127.5, 301.6),
        new Player("Nick Chubb", "Cleveland Browns", "/images/small/NickChubb.jpg",
              "/images/large/NickChubb.jpg", "RB", 215.3, 213.82),
        new Player("Derrick Henry", "Tennessee Titans", "/images/small/DerrickHenry.jpg",
              "/images/large/DerrickHenry.jpg", "RB", 193.3, 275.78),
        new Player("Jonathan Taylor", "Indianapolis Colts", "/images/small/JonathanTaylor.jpg",
              "/images/large/JonathanTaylor.jpg", "RB", 373.1, 316.27),
        new Player("Ezekiel Elliot", "Dallas Cowboys","images/small/EzekielElliotsmall.jpg",
                "images/large/EzekielElliot.jpg", "RB", 252.06, 219.29),
        new Player("Austin Ekeler", "Los Angeles Chargers", "images/small/AustinEkelersmall.jpg",
                "images/large/AustinEkeler.jpg", "RB", 343.8, 299.5),
        new Player("Alvin Kamara", "New Orleans Saints", "images/small/AlvinKamara.jpg",
                "images/large/AlvinKamara.jpg", "RB", 234.7, 280.47),
        new Player("D'Andre Swift", "Detroit Lions", "images/small/D'AndreSwift.jpg",
                "images/large/D'AndreSwift.jpg", "RB", 208.9, 264.92),
        new Player("Najee Harris", "Pittsburgh Steelers", "images/small/NajeeHarris.jpg",
                "images/large/NajeeHarris.jpg", "RB", 300.7, 264.17),
        new Player("Dalvin Cook", "Minnesota Vikings", "images/small/DalvinCook.jpg",
                "images/large/DalvinCook.jpg", "RB", 206.3, 261.27),
        new Player("Joe Mixon", "Cincinnati Bengals", "images/small/JoeMixon.jpg",
                "images/large/JoeMixon.jpg", "RB", 287.9, 258.32),
        new Player("James Conner", "Arizona Cardinals", "images/small/JamesConner.jpg",
                "images/large/JamesConner.jpg", "RB", 257.7, 250.1),
        new Player("Aaron Jones", "Green Bay Packers", "images/small/AaronJones.jpg",
                "images/large/AaronJones.jpg", "RB", 229.0, 244.44),
        new Player("Antonio Gibson", "Washington Commanders", "images/small/AntonioGibson.jpg",
                "images/large/AntonioGibson.jpg", "RB", 229.1, 234.55),
        new Player("Josh Jacobs", "Las Vegas Raiders", "images/small/JoshJacobs.jpg",
                "images/large/JoshJacobs.jpg", "RB", 226.0, 227.82),
        new Player("J.K. Dobbins", "Baltmore Ravens", "images/small/JKDobbins.jpg",
                "images/large/JKDobbins.jpg", "RB", 0, 223.97),
        new Player("Saquon Barkley", "New York Giants", "images/small/SaquonBarkley.jpg",
                "images/large/SaquonBarkley.jpg", "RB", 148.6, 215.59),
        new Player("Michael Carter", "New York Jets", "images/small/MichaelCarter.jpg",
                "images/large/MichaelCarter.jpg", "RB", 154.4, 214.43),
        new Player("Javonte Williams", "Denver Broncos", "images/small/JavonteWilliams.jpg",
                "images/small/JavonteWilliams.jpg", "RB", 204.9, 268.23)
    };

    Player[] WR = new Player[] {
            new Player("DeVante Adams", "Las Vegas Raiders", "/images/small/DeVanteAdams.jpg",
                    "/images/large/DeVanteAdams.jpg", "WR", 344.3, 260.95),
            new Player("Tyreek Hill", "Miami Dolphins", "/images/small/TyreekHill.jpg",
                    "/images/large/TyreekHill.jpg", "WR", 296.5, 257.2),
            new Player("DK Metcalf", "Seattle Seahawks", "/images/small/DKMetcalf.jpg",
                    "/images/large/DKMetcalf.jpg", "WR", 244.3, 239.15),
            new Player("DeAndre Hopkins", "Arizona Cardinals", "/images/small/DeAndreHopkins.jpg",
                    "/images/large/DeAndreHopkins.jpg", "WR", 147.2, 234.13),
            new Player("Ja'Marr Chase", "Cincinnati Bengals", "/images/small/JaMarrChase.jpg",
                    "/images/large/JaMarrChase.jpg", "WR", 304.6, 287.47)
    };

    Player[] TE = new Player[] {
            new Player("Cole Kmet", "Chicago Bears", "/images/small/ColeKmet.jpg",
                    "/images/large/ColeKmet.jpg", "TE", 121.2, 136.59),
            new Player("Travis Kelce", "Kansas City Chiefs", "/images/small/TravisKelce.jpg",
                    "/images/large/TravisKelce.jpg", "TE", 262.8, 240.65),
            new Player("Darren Waller", "Las Vegas Raiders", "/images/small/DarrenWaller.jpg",
                    "/images/large/DarrenWaller.jpg", "TE", 133.5, 195.33),
            new Player("George Kittle", "San Francisco 49ers", "/images/small/GeorgeKittle.jpg",
                    "/images/large/GeorgeKittle.jpg", "TE", 198.0, 181.57),
            new Player("Mark Andrews", "Baltimore Ravens", "/images/small/MarkAndrews.jpg",
                    "/images/large/MarkAndrews.jpg", "TE", 301.1, 254.12)
    };

    Player[] K = new Player[] {
            new Player("Cairo Santos", "Chicago Bears", "/images/small/CairoSantos.jpg",
                    "/images/large/CairoSantos.jpg", "K", 112.0, 123.64),
            new Player("Justin Tucker", "Baltimore Ravens", "/images/small/JustinTucker.jpg",
                    "/images/large/JustinTucker.jpg", "K", 161.0, 140.14),
            new Player("Jason Sanders", "Miami Dolphins", "/images/small/JasonSanders.jpg",
                    "/images/large/JasonSanders.jpg", "K", 107.0, 109.77),
            new Player("Harrison Butker", "Kansas City Chiefs", "/images/small/HarrisonButker.jpg",
                    "/images/large/HarrisonButker.jpg", "K", 137.0, 145.51),
            new Player("Robbie Gould", "San Francisco 49ers", "/images/small/RobbieGould.jpg",
                    "/images/large/RobbieGould.jpg", "K", 109.0, 130.86)
    };

    Player[] Def = new Player[] {
            new Player("Chicago Bears", "Chicago Bears", "/images/small/ChicagoBears.jpg",
                    "/images/large/ChicagoBears.jpg", "Def", 105.0, 90.8),
            new Player("Carolina Panthers", "Carolina Panthers", "/images/small/CarolinaPanthers.png",
                    "/images/large/CarolinaPanthers.png", "Def", 88.0, 99.69),
            new Player("Houston Texans", "Houston Texans", "/images/small/HoustonTexans.jpg",
                    "/images/large/HoustonTexans.jpg", "Def", 58.0, 56.35),
            new Player("Los Angeles Rams", "Los Angeles Rams", "/images/small/LARams.jpg",
                    "/images/large/LARams.jpg", "Def", 105.0, 94.1),
            new Player("BuffaloBills", "Buffalo Bills", "/images/small/BuffaloBills.jpg",
                    "/images/large/BuffaloBills.jpg", "Def", 154.0, 129.83)
    };

    int rbNum = 0;
    int qbNum = 0;
    int wrNum = 0;
    int teNum = 0;
    int kNum = 0;
    int defNum = 0;
    int flexNum = 0;

    @FXML
    void teamNameCommit(ActionEvent event) {
        displayTeam.setTeamName(teamNameText.getText());
        teamNameText.clear();
        myTeam.setText(displayTeam.toString());
    }

    @FXML
    void selectPlayerButtonPress(ActionEvent event) {
        Player[] tmpQB = new Player[QB.length - 1];
        Player[] tmpRB = new Player[RB.length - 1];
        Player[] tmpWR = new Player[WR.length - 1];
        Player[] tmpTE = new Player[TE.length - 1];
        Player[] tmpK = new Player[K.length - 1];
        Player[] tmpDef = new Player[Def.length - 1];

        String name = playerListView.getSelectionModel().getSelectedItem().getPlayer();
        String position = playerListView.getSelectionModel().getSelectedItem().getPosition();

        try{
            if (Objects.equals(position, "QB")) {
                int j = 0;
                for (Player value : QB) {
                    if (Objects.equals(name, value.getPlayer()) && qbNum < 1) {
                        team.add(playerListView.getSelectionModel().getSelectedItem());
                        teamListView.setItems(team);
                        playerImageView.setImage(new Image("images/large/PickIsIn.jpg"));
                        displayTeam.setQB(name);
                        qbNum++;
                    } else {
                        tmpQB[j++] = value;
                    }
                }
                QB = tmpQB;
            }

            if (Objects.equals(position, "RB")) {
                int j = 0;
                for (Player value : RB) {
                    if (Objects.equals(name, value.getPlayer()) && rbNum < 2) {
                        team.add(playerListView.getSelectionModel().getSelectedItem());
                        teamListView.setItems(team);
                        playerImageView.setImage(new Image("images/large/PickIsIn.jpg"));
                        if(rbNum <1) {
                            displayTeam.setRB1(name);
                        } else {
                            displayTeam.setRB2(name);
                        }
                        rbNum++;
                    } else if (Objects.equals(name, value.getPlayer()) && flexNum < 1) {
                        team.add(playerListView.getSelectionModel().getSelectedItem());
                        teamListView.setItems(team);
                        playerImageView.setImage(new Image("images/large/PickIsIn.jpg"));
                        displayTeam.setFLEX(name);
                        flexNum++;
                    } else {
                        tmpRB[j++] = value;
                    }
                }
                RB = tmpRB;
            }

            if (Objects.equals(position, "WR")) {
                int j = 0;
                for (Player value : WR) {
                    if (Objects.equals(name, value.getPlayer()) && wrNum < 2) {
                        team.add(playerListView.getSelectionModel().getSelectedItem());
                        teamListView.setItems(team);
                        playerImageView.setImage(new Image("images/large/PickIsIn.jpg"));
                        if(wrNum <1) {
                            displayTeam.setWR1(name);
                        } else {
                            displayTeam.setWR2(name);
                        }
                        wrNum++;
                    } else if (Objects.equals(name, value.getPlayer()) && flexNum < 1) {
                        team.add(playerListView.getSelectionModel().getSelectedItem());
                        teamListView.setItems(team);
                        playerImageView.setImage(new Image("images/large/PickIsIn.jpg"));
                        displayTeam.setFLEX(name);
                        flexNum++;
                    } else {
                        tmpWR[j++] = value;
                    }
                }
                WR = tmpWR;
            }

            if (Objects.equals(position, "TE")) {
                int j = 0;
                for (Player value : TE) {
                    if (Objects.equals(name, value.getPlayer()) && teNum < 1) {
                        team.add(playerListView.getSelectionModel().getSelectedItem());
                        teamListView.setItems(team);
                        playerImageView.setImage(new Image("images/large/PickIsIn.jpg"));
                        displayTeam.setTE(name);
                        teNum++;
                    } else if (Objects.equals(name, value.getPlayer()) && flexNum < 1) {
                        team.add(playerListView.getSelectionModel().getSelectedItem());
                        teamListView.setItems(team);
                        playerImageView.setImage(new Image("images/large/PickIsIn.jpg"));
                        displayTeam.setFLEX(name);
                        flexNum++;
                    } else {
                        tmpTE[j++] = value;
                    }
                }
                TE = tmpTE;
            }

            if (Objects.equals(position, "K")) {
                int j = 0;
                for (Player value : K) {
                    if (Objects.equals(name, value.getPlayer()) && kNum < 1) {
                        team.add(playerListView.getSelectionModel().getSelectedItem());
                        teamListView.setItems(team);
                        playerImageView.setImage(new Image("images/large/PickIsIn.jpg"));
                        displayTeam.setK(name);
                        kNum++;
                    } else {
                        tmpK[j++] = value;
                    }
                }
                K = tmpK;
            }

            if (Objects.equals(position, "Def") && defNum < 1) {
                int j = 0;
                for (Player value : Def) {
                    if (Objects.equals(name, value.getPlayer())) {
                        team.add(playerListView.getSelectionModel().getSelectedItem());
                        teamListView.setItems(team);
                        playerImageView.setImage(new Image("images/large/PickIsIn.jpg"));
                        displayTeam.setDEF(name);
                        defNum++;
                    } else {
                        tmpDef[j++] = value;
                    }
                }
                Def = tmpDef;
            }

            if (qbNum == 1 && rbNum == 2 && wrNum == 2 && teNum == 1 && flexNum == 1 && kNum == 1 && defNum == 1) {
                playerImageView.setImage(new Image("images/large/Trophy.jpg"));
                playerStats.setText("TEAM COMPLETE! CONGRATS!!!");

            }
        }catch(ArrayIndexOutOfBoundsException outOfBoundsException) {
            playerListView.getItems().clear();
            playerImageView.setImage(new Image("images/large/RedX.jpg"));
            playerStats.setText("That Position is Full, Try Again!");
            myTeam.setText("That Position is Full, Try Again!");
        }catch(Exception ignored) {;};


        playerListView.getItems().clear();
        myTeam.setText(displayTeam.toString());

    }

    @FXML
    void defButtonPress(ActionEvent event) {
        // populate the ObservableList<Player>
        playerListView.getItems().clear();
        Collections.addAll(player, Def);
        playerListView.setItems(player);
    }

    @FXML
    void kButtonPress(ActionEvent event) {
        // populate the ObservableList<Player>
        playerListView.getItems().clear();
        Collections.addAll(player, K);
        playerListView.setItems(player);
    }

    @FXML
    void qbButtonPress(ActionEvent event) {
        // populate the ObservableList<Player>
        playerListView.getItems().clear();
        Collections.addAll(player, QB);
        playerListView.setItems(player);
    }

    @FXML
    void rbButtonPress(ActionEvent event) {
        // populate the ObservableList<Player>
        playerListView.getItems().clear();
        Collections.addAll(player, RB);
        playerListView.setItems(player);
    }

    @FXML
    void teButtonPress(ActionEvent event) {
        // populate the ObservableList<Player>
        playerListView.getItems().clear();
        Collections.addAll(player, TE);
        playerListView.setItems(player);
    }

    @FXML
    void wrButtonPress(ActionEvent event) {
        // populate the ObservableList<Player>
        playerListView.getItems().clear();
        Collections.addAll(player, WR);
        playerListView.setItems(player);
    }

    // initialize controller
    public void initialize() {
        playerListView.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Player>() {
                    @Override
                    public void changed(ObservableValue<? extends Player> observableValue, Player oldValue,
                                        Player newValue) {
                        try {
                            playerImageView.setImage(new Image(newValue.getLargeImage()));
                            playerStats.setText(newValue.toString());
                        } catch(Exception ignored) {;}
                    }
                }
        );
        teamListView.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Player>() {
                    @Override
                    public void changed(ObservableValue<? extends Player> observableValue, Player oldValue,
                                        Player newValue) {
                        try {
                            playerImageView.setImage(new Image(newValue.getLargeImage()));
                            playerStats.setText(newValue.toString());
                        } catch(Exception ignored) {;}
                    }
                }
        );
        playerListView.setCellFactory(new Callback<ListView<Player>, ListCell<Player>>() {
            @Override
            public ListCell<Player> call (ListView<Player> listView) {
                return new ImageTextCell();
            }
        });
        teamListView.setCellFactory(new Callback<ListView<Player>, ListCell<Player>>() {
            @Override
            public ListCell<Player> call (ListView<Player> listView) {
                return new ImageTextCell();
            }
        });
    }
}
