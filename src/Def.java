/** class Def is a subclass of class Player
 * It contains the necessary stats/information for each Defense player object
 * Each Def object will be an NFL team's defense in the draft.
 * For Player Stats, visit: https://fantasy.espn.com/football/players/projections
 */
public class Def extends Player{
    // instance variables
    private int sacks;
    private int interceptions;
    private int fumbleRecover;
    private int totalTDs;
    private int pointsAgainst;
    private double yardsAgainst;
    // constructor
    public Def( String player, String team, String thumbImage, String largeImage, String position, double prevPoints, double projPoints,
            int sacks, int interceptions, int fumbleRecover, int totalTDs, int pointsAgainst, double yardsAgainst) {
        super(player, team, thumbImage, largeImage, position, prevPoints, projPoints);
        this.sacks = sacks;
        this.interceptions = interceptions;
        this.fumbleRecover = fumbleRecover;
        this.totalTDs = totalTDs;
        this.pointsAgainst = pointsAgainst;
        this.yardsAgainst = yardsAgainst;
    }
    // mutators
    public void setSacks(int sacks) {
        this.sacks = sacks;
    }
    public void setInterceptions(int interceptions) {
        this.interceptions = interceptions;
    }
    public void setFumbleRecover(int fumbleRecover) {
        this.fumbleRecover = fumbleRecover;
    }
    public void setTotalTDs(int totalTDs) {this.totalTDs = totalTDs;}
    public void setPointsAgainst(int pointsAgainst) {
        this.pointsAgainst = pointsAgainst;
    }
    public void setAvgYDsPerCatch(double yardsAgainst) {
        this.yardsAgainst = yardsAgainst;
    }
    // accessors
    public int getSacks() {
        return sacks;
    }
    public int getInterceptions() {
        return interceptions;
    }
    public int getFumbleRecover() {
        return fumbleRecover;
    }
    public int getTotalTDs() {
        return totalTDs;
    }
    public int getPointsAgainst() {
        return pointsAgainst;
    }
    public double getAvgYDsPerCatch() {
        return yardsAgainst;
    }

    /** Overriding toString method to display each defense (Def) object's stats
     * @return String.format: a formatted string containing stats
     */
    @Override
    public String toString() {
        return String.format("%n%s%n%s%n%n%-30s%,.1f%n%n%28s%n%-32s%,.1f%n%-31s%d%n%-31s%d%n%-29s%d%n%-29s%d%n%-31s%d%n%-30s%,.1f",
                getPosition(),
                getTeam(),
                "2021 Total Points: ", getPrevPoints(),
                "2022 Projected",
                "Points: ", getProjPoints(),
                "Sacks: ", sacks,
                "Interceptions: ", interceptions,
                "Fumble Recoveries: ", fumbleRecover,
                "Total Touchdowns: ", totalTDs,
                "Points Against: ", pointsAgainst,
                "Yards Against: ", yardsAgainst);
    }
}
