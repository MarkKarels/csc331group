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
    @FXML private TextArea mysteryTeam1;
    @FXML private TextArea mysteryTeam2;
    // stores the list of Player Objects
    private final ObservableList<Player> player = FXCollections.observableArrayList();
    private final ObservableList<Player> team = FXCollections.observableArrayList();
    DisplayTeam displayTeam = new DisplayTeam();
    DisplayTeam autoTeam1 = new DisplayTeam();
    DisplayTeam autoTeam2 = new DisplayTeam();
    String[] mysteryNames1 = {"Run CMC", "Yippe Kai-Yay Justin Tucker", "Rolling with Mahomes", "Stuck in the End Zone",
    "Punt Intended", "My Kupp Runneth Over", "Davante's Inferno", "The Real Slim Brady", "Kmet the Frog", "Riding in my Lambeau"};
    String[] mysteryNames2 = {"RussellMania", "Legion of Boom", "Too Many Cooks", "Tua Legit Tua Quit", "Matty Ice and Easy",
    "Quarantine Salvation", "Play At Home Order", "Cobra Ky-ler", "Judge Jeudy", "High Wattage"};

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
        new RB("David Montgomery", "Chicago Bears", "/images/small/DavidMontgomery.jpg",
                "/images/large/DavidMontgomery.jpg", "RB", 195.0, 241.64, 1043,
                8, 45, 326, 2, 261, 4.0),
        new RB("Christian McCaffrey", "Carolina Panthers", "/images/small/ChristianMcCaffrey.jpg",
                "/images/large/ChristianMcCaffrey.jpg", "RB", 127.5, 301.6, 926,
                6, 91, 674, 2, 211, 4.4),
        new RB("Nick Chubb", "Cleveland Browns", "/images/small/NickChubb.jpg",
                "/images/large/NickChubb.jpg", "RB", 215.3, 213.82, 1147,
                7, 27, 228, 1, 233, 4.9),
        new RB("Derrick Henry", "Tennessee Titans", "/images/small/DerrickHenry.jpg",
                "/images/large/DerrickHenry.jpg", "RB", 193.3, 275.78, 1519,
                12, 28, 211, 1, 356, 4.3),
        new RB("Jonathan Taylor", "Indianapolis Colts", "/images/small/JonathanTaylor.jpg",
                "/images/large/JonathanTaylor.jpg", "RB", 373.1, 316.27, 1551,
                13, 42, 339, 1, 319, 4.9),
        new RB("Ezekiel Elliot", "Dallas Cowboys","images/small/EzekielElliot.jpg",
                "images/large/EzekielElliot.jpg", "RB", 252.06, 219.29, 966,
                8, 36, 248, 2, 229, 4.2),
        new RB("Austin Ekeler", "Los Angeles Chargers", "images/small/AustinEkeler.jpg",
                "images/large/AustinEkeler.jpg", "RB", 343.8, 299.5, 1007,
                9, 66, 620, 3, 231, 4.4),
        new RB("Alvin Kamara", "New Orleans Saints", "images/small/AlvinKamara.jpg",
                "images/large/AlvinKamara.jpg", "RB", 234.7, 280.47, 873,
                7, 64, 648, 4, 217, 4.0),
        new RB("D'Andre Swift", "Detroit Lions", "images/small/D'AndreSwift.jpg",
                "images/large/D'AndreSwift.jpg", "RB", 208.9, 264.92, 853,
                7, 70, 536, 3, 202, 4.2),
        new RB("Najee Harris", "Pittsburgh Steelers", "images/small/NajeeHarris.jpg",
                "images/large/NajeeHarris.jpg", "RB", 300.7, 264.17, 1118,
                7, 61, 406, 2, 270, 4.1),
        new RB("Dalvin Cook", "Minnesota Vikings", "images/small/DalvinCook.jpg",
                "images/large/DalvinCook.jpg", "RB", 206.3, 261.27, 1178,
                10, 44, 355, 1, 265, 4.4),
        new RB("Joe Mixon", "Cincinnati Bengals", "images/small/JoeMixon.jpg",
                "images/large/JoeMixon.jpg", "RB", 287.9, 258.32, 1139,
                10, 42, 280, 2, 271, 4.2),
        new RB("James Conner", "Arizona Cardinals", "images/small/JamesConner.jpg",
                "images/large/JamesConner.jpg", "RB", 257.7, 250.1, 896,
                11, 49, 384, 2, 222, 4.0),
        new RB("Aaron Jones", "Green Bay Packers", "images/small/AaronJones.jpg",
                "images/large/AaronJones.jpg", "RB", 229.0, 244.44, 846,
                6, 58, 496, 3, 185, 4.6),
        new RB("Antonio Gibson", "Washington Commanders", "images/small/AntonioGibson.jpg",
                "images/large/AntonioGibson.jpg", "RB", 229.1, 234.55, 1121,
                10, 33, 240, 1, 265, 4.2),
        new RB("Josh Jacobs", "Las Vegas Raiders", "images/small/JoshJacobs.jpg",
                "images/large/JoshJacobs.jpg", "RB", 226.0, 227.82, 1036,
                9, 36, 258, 1, 247, 4.2),
        new RB("J.K. Dobbins", "Baltmore Ravens", "images/small/JKDobbins.jpg",
                "images/large/JKDobbins.jpg", "RB", 0, 223.97, 925,
                10, 37, 273, 1, 195, 4.7),
        new RB("Saquon Barkley", "New York Giants", "images/small/SaquonBarkley.jpg",
                "images/large/SaquonBarkley.jpg", "RB", 148.6, 215.59, 824,
                5, 52, 412, 2, 203, 4.1),
        new RB("Michael Carter", "New York Jets", "images/small/MichaelCarter.jpg",
                "images/large/MichaelCarter.jpg", "RB", 154.4, 214.43, 896,
                5, 45, 381, 2, 208, 4.3),
        new RB("Javonte Williams", "Denver Broncos", "images/small/JavonteWilliams.jpg",
                "images/small/JavonteWilliams.jpg", "RB", 204.9, 268.23, 1044,
                8, 59, 426, 2, 241, 4.3)
    };

    Player[] WR = new Player[] {
            new WR("DeVante Adams", "Las Vegas Raiders", "/images/small/DeVanteAdams.jpg",
                    "/images/large/DeVanteAdams.jpg", "WR", 344.3, 260.95,
                    0, 0, 98, 1181, 8, 138, 12.0),
            new WR("Tyreek Hill", "Miami Dolphins", "/images/small/TyreekHill.jpg",
                    "/images/large/TyreekHill.jpg", "WR", 296.5, 257.2,
                    60, 0, 92, 1138, 7, 135, 12.4),
            new WR("DK Metcalf", "Seattle Seahawks", "/images/small/DKMetcalf.jpg",
                    "/images/large/DKMetcalf.jpg", "WR", 244.3, 239.15,
                    0, 0, 82, 1210, 6, 143, 14.7),
            new WR("DeAndre Hopkins", "Arizona Cardinals", "/images/small/DeAndreHopkins.jpg",
                    "/images/large/DeAndreHopkins.jpg", "WR", 147.2, 234.13,
                    0, 0, 87, 1051, 7, 127, 12.0),
            new WR("Ja'Marr Chase", "Cincinnati Bengals", "/images/small/JaMarrChase.jpg",
                    "/images/large/JaMarrChase.jpg", "WR", 304.6, 287.47,
                    83, 1, 87, 1308, 10, 135, 15.0),
            new WR("Cooper Kupp", "Las Angeles Ram", "/images/small/CooperKupp.jpg",
                    "/images/large/CooperKupp.jpg", "WR", 439.5, 311.59,
                    25, 0, 114, 1358, 10, 156, 11.9),
            new WR("Justin Jefferson", "Minnesota Vikings", "/images/small/JustinJefferson.jpg",
                    "/images/large/JustinJefferson.jpg", "WR", 330.4, 293.06,
                    24, 0, 101, 1411, 8, 155, 14.0),
            new WR("Deebo Samuel", "San Francisco 49ers", "/images/small/DeeboSamuel.jpg",
                    "/images/large/DeeboSamuel.jpg", "WR", 338.96, 271.95,
                    583, 6, 63, 908, 5, 95, 14.4),
            new WR("Stefon Diggs", "Buffalo Bills", "/images/small/StefonDiggs.jpg",
                    "/images/large/StefonDiggs.jpg", "WR", 285.5, 266.08,
                    0, 0, 96, 1181, 9, 146, 12.3),
            new WR("CeeDee Lamb", "Dallas Cowboys", "/images/small/CeeDeeLamb.jpg",
                    "/images/large/CeeDeeLamb.jpg", "WR", 232.8, 260.76,
                    60, 0, 89, 1156, 8, 135, 13.0),
            new WR("A.J. Brown", "Tennessee Titans", "/images/small/AJBrown.jpg",
                    "/images/large/AJBrown.jpg", "WR", 180.9, 238.01,
                    0, 0, 80, 1182, 7, 130, 14.9),
            new WR("Tee Higgins", "Cincinnati Bengals", "/images/small/TeeHiggins.jpg",
                    "/images/large/TeeHiggins.jpg", "WR", 219.1, 247.98,
                    0, 0, 83, 1136, 9, 130, 13.6),
            new WR("Mike Evans", "Tampa Bay Buccaneers", "/images/small/MikeEvans.jpg",
                    "/images/large/MikeEvans.jpg", "WR", 262.5, 223.64,
                    0, 0, 73, 1002, 8, 117, 13.8),
            new WR("Courtland Sutton", "Denver Broncos", "/images/small/CourtlandSutton.jpg",
                    "/images/large/CourtlandSutton.jpg", "WR", 150.24, 208.19,
                    0, 0, 65, 958, 8, 112, 14.6),
            new WR("Keenan Allen", "Los Angeles Chargers", "/images/small/KeenanAllen.jpg",
                    "/images/large/KeenanAllen.jpg", "WR", 257.8, 239.17,
                    0, 0, 95, 1043, 7, 139, 11.0),
            new WR("Jaylen Waddle", "Miami Dolphins", "/images/small/JaylenWaddle.jpg",
                    "/images/large/JaylenWaddle.jpg", "WR", 245.8, 238.64,
                    48, 0, 94, 1005, 6, 135, 10.7),
            new WR("DJ Moore", "Carolina Panthers", "/images/small/DJMoore.jpg",
                    "/images/large/DJMoore.jpg", "WR", 237.5, 248.18, 54,
                    0, 87, 1240, 5, 146, 14.3),
            new WR("Marquise Brown", "Baltimore Ravens", "/images/small/MarquiseBrown.jpg",
                    "/images/large/MarquiseBrown.jpg", "WR", 226.3, 234.16,
                    0, 0, 81, 1108, 7, 129, 13.7),
            new WR("Chris Godwin", "Tampa Bay Buccaneers", "/images/small/ChrisGodwin.jpg",
                    "/images/large/ChrisGodwin.jpg", "WR", 242.4, 216.44,
                    25, 0, 81, 931, 7, 112, 11.5),
            new WR("Amari Cooper", "Dallas Cowboys", "/images/small/AmariCooper.jpg",
                    "/images/large/AmariCooper.jpg", "WR", 202.5, 211.05,
                    0, 0, 79, 925, 7, 119, 11.7)
    };

    Player[] TE = new Player[] {
            new TE("Cole Kmet", "Chicago Bears", "/images/small/ColeKmet.jpg",
                    "/images/large/ColeKmet.jpg", "TE", 121.2, 136.59, 0,
                    0, 55, 591, 4, 85, 10.6 ),
            new TE("Travis Kelce", "Kansas City Chiefs", "/images/small/TravisKelce.jpg",
                    "/images/large/TravisKelce.jpg", "TE", 262.8, 240.65,
                    7, 0, 92, 1034, 7, 126, 11.3),
            new TE("Darren Waller", "Las Vegas Raiders", "/images/small/DarrenWaller.jpg",
                    "/images/large/DarrenWaller.jpg", "TE", 133.5, 195.33,
                    0, 0, 70, 908, 6, 109, 12.9),
            new TE("George Kittle", "San Francisco 49ers", "/images/small/GeorgeKittle.jpg",
                    "/images/large/GeorgeKittle.jpg", "TE", 198.0, 181.57,
                    12, 0, 67, 835, 5, 96, 12.5),
            new TE("Mark Andrews", "Baltimore Ravens", "/images/small/MarkAndrews.jpg",
                    "/images/large/MarkAndrews.jpg", "TE", 301.1, 254.12,
                    0, 0, 91, 1105, 9, 135, 12.2)
    };

    Player[] K = new Player[] {
            new K("Cairo Santos", "Chicago Bears", "/images/small/CairoSantos.jpg",
                    "/images/large/CairoSantos.jpg", "K", 112.0, 123.64, 16,
                    8, 3, 33, 28, 33, 31),
            new K("Justin Tucker", "Baltimore Ravens", "/images/small/JustinTucker.jpg",
                    "/images/large/JustinTucker.jpg", "K", 161.0, 140.14, 17,
                    8, 3, 32, 28, 51, 50),
            new K("Jason Sanders", "Miami Dolphins", "/images/small/JasonSanders.jpg",
                    "/images/large/JasonSanders.jpg", "K", 107.0, 109.77, 13,
                    6, 3, 27, 22, 41, 38),
            new K("Harrison Butker", "Kansas City Chiefs", "/images/small/HarrisonButker.jpg",
                    "/images/large/HarrisonButker.jpg", "K", 137.0, 145.51, 17,
                    8, 3, 32, 28, 51, 50),
            new K("Robbie Gould", "San Francisco 49ers", "/images/small/RobbieGould.jpg",
                    "/images/large/RobbieGould.jpg", "K", 109.0, 130.86, 16,
                    8, 3, 32, 27, 41, 39),
            new K("Evan McPherson", "Cincinnati Bengals", "/images/small/EvanMcpherson.jpg",
                    "/images/large/EvanMcpherson.jpg", "K", 149.0, 148.83, 18,
                    9,4,35,31, 47,46),
            new K("Matt Gay", "Los Angeles Rams", "/images/small/MattGay.jpg",
                    "/images/large/MattGay.jpg", "K", 157.0, 147.97, 18,
                    9,4,35,31,46,45),
            new K("Nick Folk", "New England Patriots", "/images/small/NickFolk.jpg",
                    "/images/large/NickFolk.jpg", "K", 168.0, 135.79, 17,
                    8,3,32,28,41,41),
            new K("Tyler Bass", "Buffalo Bills", "/images/small/TylerBass.jpg",
                    "/images/large/TylerBass.jpg", "K", 139.0, 132.86, 16,
                    7,3,31,26, 50,47),
            new K("Mason Crosby", "Green Bay Packers", "/images/small/MasonCrosby.jpg",
                    "/images/large/MasonCrosby.jpg", "K", 125.0, 131.71, 16,
                    8,3,32,26,48,44)
    };

    Player[] Def = new Player[] {
            new Def("Chicago Bears", "Chicago Bears", "/images/small/ChicagoBears.jpg",
                    "/images/large/ChicagoBears.jpg", "Def", 105.0, 90.8, 39,
                    11, 9, 2, 418, 5843.0),
            new Def("Carolina Panthers", "Carolina Panthers", "/images/small/CarolinaPanthers.png",
                    "/images/large/CarolinaPanthers.png", "Def", 88.0, 99.69, 40, 13,
                    8, 2, 405, 5822.0),
            new Def("Houston Texans", "Houston Texans", "/images/small/HoustonTexans.jpg",
                    "/images/large/HoustonTexans.jpg", "Def", 58.0, 56.35, 39,
                    12, 6, 3, 422, 6025.0),
            new Def("Los Angeles Rams", "Los Angeles Rams", "/images/small/LARams.jpg",
                    "/images/large/LARams.jpg", "Def", 105.0, 94.1, 42,
                    14, 8, 2, 372, 5971.0),
            new Def("Buffalo Bills", "Buffalo Bills", "/images/small/BuffaloBills.jpg",
                    "/images/large/BuffaloBills.jpg", "Def", 154.0, 129.83, 44,
                    14, 8, 2, 340, 5755.0)
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
        int mysteryNum1 = (int)(Math.floor(Math.random() * 10));
        int mysteryNum2 = (int)(Math.floor(Math.random() * 10));

        displayTeam.setTeamName(teamNameText.getText());
        teamNameText.clear();
        myTeam.setText(displayTeam.toString());
        autoTeam1.setTeamName(mysteryNames1[mysteryNum1]);
        autoTeam2.setTeamName(mysteryNames2[mysteryNum2]);
        mysteryTeam1.setText(autoTeam1.toString());
        mysteryTeam2.setText(autoTeam2.toString());
    }

    @FXML
    void selectPlayerButtonPress(ActionEvent event) {
        Player[] tmpQB = new Player[QB.length - 1];
        Player[] tmpRB = new Player[RB.length - 1];
        Player[] tmpWR = new Player[WR.length - 1];
        Player[] tmpTE = new Player[TE.length - 1];
        Player[] tmpK = new Player[K.length - 1];
        Player[] tmpDef = new Player[Def.length - 1];
        int indexNum1 = (int)(Math.floor(Math.random() * 5));
        int indexNum2 = (int)(Math.floor(Math.random() * 5));

        try{
            String name = playerListView.getSelectionModel().getSelectedItem().getPlayer();
            String position = playerListView.getSelectionModel().getSelectedItem().getPosition();

            if (team.toArray().length == 9) {
                playerImageView.setImage(new Image("images/large/Trophy.jpg"));
                playerStats.setText("Cannot Select Another Player,\n Team is Complete.");
            }
            else if (Objects.equals(position, "QB")) {
                int j = 0;
                for (Player value : QB) {
                    if (Objects.equals(name, value.getPlayer()) && qbNum < 1) {
                        team.add(playerListView.getSelectionModel().getSelectedItem());
                        teamListView.setItems(team);
                        displayTeam.setQB(name);
                        qbNum++;
                    } else {tmpQB[j++] = value;}
                }
                QB = tmpQB;
                if (team.toArray().length == 9) {
                    playerImageView.setImage(new Image("images/large/Trophy.jpg"));
                    playerStats.setText("DRAFT COMPLETE! CONGRATS!!!");
                }
            }
            else if (Objects.equals(position, "RB")) {
                int j = 0;
                for (Player value : RB) {
                    if (Objects.equals(name, value.getPlayer()) && rbNum < 2) {
                        team.add(playerListView.getSelectionModel().getSelectedItem());
                        teamListView.setItems(team);
                        if(rbNum <1) {
                            displayTeam.setRB1(name);
                        } else {
                            displayTeam.setRB2(name);
                        }
                        rbNum++;
                    } else if (Objects.equals(name, value.getPlayer()) && flexNum < 1) {
                        team.add(playerListView.getSelectionModel().getSelectedItem());
                        teamListView.setItems(team);
                        displayTeam.setFLEX(name);
                        flexNum++;
                    } else {tmpRB[j++] = value;}
                }
                RB = tmpRB;
                if (team.toArray().length == 9) {
                    playerImageView.setImage(new Image("images/large/Trophy.jpg"));
                    playerStats.setText("DRAFT COMPLETE! CONGRATS!!!");
                }
            }
            else if (Objects.equals(position, "WR")) {
                int j = 0;
                for (Player value : WR) {
                    if (Objects.equals(name, value.getPlayer()) && wrNum < 2) {
                        team.add(playerListView.getSelectionModel().getSelectedItem());
                        teamListView.setItems(team);
                        if(wrNum <1) {
                            displayTeam.setWR1(name);
                        } else {
                            displayTeam.setWR2(name);
                        }
                        wrNum++;
                    } else if (Objects.equals(name, value.getPlayer()) && flexNum < 1) {
                        team.add(playerListView.getSelectionModel().getSelectedItem());
                        teamListView.setItems(team);
                        displayTeam.setFLEX(name);
                        flexNum++;
                    } else {tmpWR[j++] = value;}
                }
                WR = tmpWR;
                if (team.toArray().length == 9) {
                    playerImageView.setImage(new Image("images/large/Trophy.jpg"));
                    playerStats.setText("DRAFT COMPLETE! CONGRATS!!!");
                }
            }
            else if (Objects.equals(position, "TE")) {
                int j = 0;
                for (Player value : TE) {
                    if (Objects.equals(name, value.getPlayer()) && teNum < 1) {
                        team.add(playerListView.getSelectionModel().getSelectedItem());
                        teamListView.setItems(team);
                        displayTeam.setTE(name);
                        teNum++;
                    } else if (Objects.equals(name, value.getPlayer()) && flexNum < 1) {
                        team.add(playerListView.getSelectionModel().getSelectedItem());
                        teamListView.setItems(team);
                        displayTeam.setFLEX(name);
                        flexNum++;
                    } else {tmpTE[j++] = value;}
                }
                TE = tmpTE;
                if (team.toArray().length == 9) {
                    playerImageView.setImage(new Image("images/large/Trophy.jpg"));
                    playerStats.setText("DRAFT COMPLETE! CONGRATS!!!");
                }
            }
            else if (Objects.equals(position, "K")) {
                int j = 0;
                for (Player value : K) {
                    if (Objects.equals(name, value.getPlayer()) && kNum < 1) {
                        team.add(playerListView.getSelectionModel().getSelectedItem());
                        teamListView.setItems(team);
                        displayTeam.setK(name);
                        kNum++;
                    } else {tmpK[j++] = value;}
                }
                K = tmpK;
                if (team.toArray().length == 9) {
                    playerImageView.setImage(new Image("images/large/Trophy.jpg"));
                    playerStats.setText("DRAFT COMPLETE! CONGRATS!!!");
                }
            }
            else if (Objects.equals(position, "Def") && defNum < 1) {
                int j = 0;
                for (Player value : Def) {
                    if (Objects.equals(name, value.getPlayer())) {
                        team.add(playerListView.getSelectionModel().getSelectedItem());
                        teamListView.setItems(team);
                        displayTeam.setDEF(name);
                        defNum++;
                    } else {tmpDef[j++] = value;}
                }
                Def = tmpDef;
                if (team.toArray().length == 9) {
                    playerImageView.setImage(new Image("images/large/Trophy.jpg"));
                    playerStats.setText("DRAFT COMPLETE! CONGRATS!!!");
                }
            }
            // Auto Draft
            if(team.toArray().length != 9){
                int j = 0;
                if(autoTeam1.getRB1() == null) {
                    tmpRB = new Player[RB.length - 1];
                    autoTeam1.setRB1(RB[indexNum1].getPlayer());
                    for(Player value: RB){
                        if (Objects.equals(autoTeam1.getRB1(), value.getPlayer())) {
                            playerImageView.setImage(new Image("images/large/AutoDraft.jpg"));
                        }else {tmpRB[j++] = value;}
                    }
                    RB = tmpRB;

                    tmpRB = new Player[RB.length - 1];
                    j = 0;
                    autoTeam2.setRB1(RB[indexNum2].getPlayer());
                    for(Player value2: RB){
                        if (Objects.equals(autoTeam2.getRB1(), value2.getPlayer())) {
                            playerImageView.setImage(new Image("images/large/AutoDraft.jpg"));
                        }else {tmpRB[j++] = value2;}
                    }
                    RB = tmpRB;
                }
                else if(autoTeam1.getWR1() == null) {
                    tmpWR = new Player[WR.length - 1];
                    autoTeam1.setWR1(WR[indexNum1].getPlayer());
                    for(Player value: WR){
                        if (Objects.equals(autoTeam1.getWR1(), value.getPlayer())) {
                            playerImageView.setImage(new Image("images/large/AutoDraft.jpg"));
                        }else {tmpWR[j++] = value;}
                    }
                    WR = tmpWR;

                    tmpWR = new Player[WR.length - 1];
                    j = 0;
                    autoTeam2.setWR1(WR[indexNum2].getPlayer());
                    for(Player value2: WR){
                        if (Objects.equals(autoTeam2.getWR1(), value2.getPlayer())) {
                            playerImageView.setImage(new Image("images/large/AutoDraft.jpg"));
                        }else {tmpWR[j++] = value2;}
                    }
                    WR = tmpWR;
                }
                else if(autoTeam1.getRB2() == null) {
                    tmpRB = new Player[RB.length - 1];
                    autoTeam1.setRB2(RB[indexNum1].getPlayer());
                    for(Player value: RB){
                        if (Objects.equals(autoTeam1.getRB2(), value.getPlayer())) {
                            playerImageView.setImage(new Image("images/large/AutoDraft.jpg"));
                        }else {tmpRB[j++] = value;}
                    }
                    RB = tmpRB;

                    tmpRB = new Player[RB.length - 1];
                    j = 0;
                    autoTeam2.setRB2(RB[indexNum2].getPlayer());
                    for(Player value2: RB){
                        if (Objects.equals(autoTeam2.getRB2(), value2.getPlayer())) {
                            playerImageView.setImage(new Image("images/large/AutoDraft.jpg"));
                        }else {tmpRB[j++] = value2;}
                    }
                    RB = tmpRB;
                }
                else if(autoTeam1.getWR2() == null) {
                    tmpWR = new Player[WR.length - 1];
                    autoTeam1.setWR2(WR[indexNum1].getPlayer());
                    for(Player value: WR){
                        if (Objects.equals(autoTeam1.getWR2(), value.getPlayer())) {
                            playerImageView.setImage(new Image("images/large/AutoDraft.jpg"));
                        }else {tmpWR[j++] = value;}
                    }
                    WR = tmpWR;

                    tmpWR = new Player[WR.length - 1];
                    j = 0;
                    autoTeam2.setWR2(WR[indexNum2].getPlayer());
                    for(Player value2: WR){
                        if (Objects.equals(autoTeam2.getWR2(), value2.getPlayer())) {
                            playerImageView.setImage(new Image("images/large/AutoDraft.jpg"));
                        }else {tmpWR[j++] = value2;}
                    }
                    WR = tmpWR;
                }
                else if(autoTeam1.getQB() == null) {
                    tmpQB = new Player[QB.length - 1];
                    autoTeam1.setQB(QB[indexNum1].getPlayer());
                    for(Player value: QB){
                        if (Objects.equals(autoTeam1.getQB(), value.getPlayer())) {
                            playerImageView.setImage(new Image("images/large/AutoDraft.jpg"));
                        }else {tmpQB[j++] = value;}
                    }
                    QB = tmpQB;

                    tmpQB = new Player[QB.length - 1];
                    j = 0;
                    autoTeam2.setQB(QB[indexNum2].getPlayer());
                    for(Player value: QB){
                        if (Objects.equals(autoTeam2.getQB(), value.getPlayer())) {
                            playerImageView.setImage(new Image("images/large/AutoDraft.jpg"));
                        }else {tmpQB[j++] = value;}
                    }
                    QB = tmpQB;
                }
                else if(autoTeam1.getTE() == null) {
                    tmpTE = new Player[TE.length - 1];
                    autoTeam1.setTE(TE[indexNum1].getPlayer());
                    for(Player value: TE){
                        if (Objects.equals(autoTeam1.getTE(), value.getPlayer())) {
                            playerImageView.setImage(new Image("images/large/AutoDraft.jpg"));
                        }else {tmpTE[j++] = value;}
                    }
                    TE = tmpTE;

                    tmpTE = new Player[TE.length - 1];
                    j = 0;
                    autoTeam2.setTE(TE[indexNum2].getPlayer());
                    for(Player value2: TE){
                        if (Objects.equals(autoTeam2.getTE(), value2.getPlayer())) {
                            playerImageView.setImage(new Image("images/large/AutoDraft.jpg"));
                        }else {tmpTE[j++] = value2;}
                    }
                    TE = tmpTE;
                }
                else if(autoTeam1.getFLEX() == null) {
                    tmpRB = new Player[RB.length - 1];
                    autoTeam1.setFLEX(RB[indexNum1].getPlayer());
                    for(Player value: RB){
                        if (Objects.equals(autoTeam1.getFLEX(), value.getPlayer())) {
                            playerImageView.setImage(new Image("images/large/AutoDraft.jpg"));
                        }else {tmpRB[j++] = value;}
                    }
                    RB = tmpRB;

                    tmpRB = new Player[RB.length - 1];
                    j = 0;
                    autoTeam2.setFLEX(RB[indexNum2].getPlayer());
                    for(Player value2: RB){
                        if (Objects.equals(autoTeam2.getFLEX(), value2.getPlayer())) {
                            playerImageView.setImage(new Image("images/large/AutoDraft.jpg"));
                        }else {tmpRB[j++] = value2;}
                    }
                    RB = tmpRB;
                }
                else if(autoTeam1.getDEF() == null) {
                    tmpDef = new Player[Def.length - 1];
                    autoTeam1.setDEF(Def[indexNum1].getPlayer());
                    for(Player value: Def){
                        if (Objects.equals(autoTeam1.getDEF(), value.getPlayer())) {
                            playerImageView.setImage(new Image("images/large/AutoDraft.jpg"));
                        }else {tmpDef[j++] = value;}
                    }
                    Def = tmpDef;

                    tmpDef = new Player[Def.length - 1];
                    j = 0;
                    autoTeam2.setDEF(Def[indexNum2].getPlayer());
                    for(Player value2: Def){
                        if (Objects.equals(autoTeam2.getDEF(), value2.getPlayer())) {
                            playerImageView.setImage(new Image("images/large/AutoDraft.jpg"));
                        }else {tmpDef[j++] = value2;}
                    }
                    Def = tmpDef;
                }
            }
            if(autoTeam1.getK() == null && team.toArray().length == 9) {
                tmpK = new Player[K.length - 1];
                int j = 0;
                autoTeam1.setK(K[indexNum1].getPlayer());
                for (Player value : K) {
                    if (Objects.equals(autoTeam1.getK(), value.getPlayer())) {
                        playerImageView.setImage(new Image("images/large/AutoDraft.jpg"));
                    } else {
                        tmpK[j++] = value;
                    }
                }
                K = tmpK;

                tmpK = new Player[K.length - 1];
                j = 0;
                autoTeam2.setK(K[indexNum2].getPlayer());
                for (Player value2 : K) {
                    if (Objects.equals(autoTeam2.getK(), value2.getPlayer())) {
                        playerImageView.setImage(new Image("images/large/AutoDraft.jpg"));
                    } else {
                        tmpK[j++] = value2;
                    }
                }
                K = tmpK;
            }
        }catch(ArrayIndexOutOfBoundsException outOfBoundsException) {
            playerListView.getItems().clear();
            playerImageView.setImage(new Image("images/large/RedX.jpg"));
            playerStats.setText("That Position is Full, Try Again!");
        }catch(Exception ignored) {;};

        if (team.toArray().length == 9) {
            playerImageView.setImage(new Image("images/large/Trophy.jpg"));
            playerStats.setText("DRAFT COMPLETE! CONGRATS!!!");
        }

        playerListView.getItems().clear();
        myTeam.setText(displayTeam.toString());
        mysteryTeam1.setText(autoTeam1.toString());
        mysteryTeam2.setText(autoTeam2.toString());
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
                });
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
                });
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
