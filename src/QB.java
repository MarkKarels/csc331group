/**
 * Goto https://fantasy.espn.com/football/players/projections for player stats
 */

public class QB extends Player{
    private double passYDs;
    private int passTDs;
    private int passInt;
    private int rushCar;
    private double rushYDs;
    private int rushTDs;

    public QB(String player, String team, String thumbImage, String largeImage, double prevPoints, double projPoints,
              double passYDs, int passTDs, int passInt, int rushCar, double rushYDs, int rushTDs) {
        super(player, team, thumbImage, largeImage, prevPoints, projPoints);
        this.passYDs = passYDs;
        this.passTDs = passTDs;
        this.passInt = passInt;
        this.rushCar = rushCar;
        this.rushYDs = rushYDs;
        this.rushTDs = rushTDs;
    }

    public void setPassYDs(double passYDs) {this.passYDs = passYDs;}
    public void setPassTDs(int passTDs) {this.passTDs = passTDs;}
    public void setPassInt(int passInt) {this.passInt = passInt;}
    public void setRushCar(int rushCar) {this.rushCar = rushCar;}
    public void setRushYDs(double rushYDs) {this.rushYDs = rushYDs;}
    public void setRushTDs(int rushTDs) {this.rushTDs = rushTDs;}

    public double getPassYDs() {return passYDs;}
    public int getPassTDs() {return passTDs;}
    public int getPassInt() {return passInt;}
    public int getRushCar() {return rushCar;}
    public double getRushYDs() {return rushYDs;}
    public int getRushTDs() {return rushTDs;}

    @Override
    public String toString() {
        return String.format("%s%n%-20s%,.2f%n%-20s%,.2f%n%-20s%,.2f%n%-20s%d%n%-20s%d%n%-20s%d%n%-20s%,.2f%n%-20s%d",
                super.toString(),
                "2021 Total Points: ", getPrevPoints(),
                "2022 Projected Points: ", getProjPoints(),
                "Passing Yards: ", passYDs,
                "Passing Touchdowns: ", passTDs,
                "Passing Interceptions: ", passInt,
                "Rushing Attempts: ", rushCar,
                "Rushing Yards: ", rushYDs,
                "Rushing Touchdowns: ", rushTDs);
    }
}
