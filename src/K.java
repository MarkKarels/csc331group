/**
 * Goto https://fantasy.espn.com/football/players/projections for player stats
 */

public class K extends Player{
    private int made1to39;
    private int made40to49;
    private int made50plus;
    private int totalAttempt;
    private int totalMade;
    private int xpAttempt;
    private int xpMade;

    public K(String player, String team, String thumbImage, String largeImage, String position, double prevPoints, double projPoints,
             int made1to39, int made40to49, int made50plus, int totalAttempt, int totalMade, int xpAttempt, int xpMade){
        super(player, team, thumbImage, largeImage, position, prevPoints, projPoints);
        this.made1to39 =made1to39;
        this.made40to49 = made40to49;
        this.made50plus=made50plus;
        this.totalAttempt=totalAttempt;
        this.totalMade=totalMade;
        this.xpAttempt=xpAttempt;
        this.xpMade=xpMade;
    }

    public void setMade1to39(int made1to39) {this.made1to39=made1to39;}
    public void setMade40to49(int made40to49) {this.made40to49=made40to49;}
    public void setMade50plus(int made50plus) {this.made50plus=made50plus;}
    public void setTotalAttempt(int totalAttempt) {this.totalAttempt=totalAttempt;}
    public void setTotalMade(int totalMade) {this.totalMade=totalMade;}
    public void setXpAttempt(int xpAttempt) {this.xpAttempt=xpAttempt;}
    public void setXpMade(int xpMade){this.xpMade=xpMade;}

    public int getMade1to39() {return made1to39;}
    public int getMade40to49() {return made40to49;}
    public int getMade50plus() {return made50plus;}
    public int getTotalAttempt() {return totalAttempt;}
    public int getTotalMade() {return totalMade;}
    public int getXpAttempt() {return xpAttempt;}
    public int getXpMade() {return xpMade;}

    @Override
    public String toString() {
        double fgPercent = (double)totalMade / (double)totalAttempt * 100;
        double xpPercent = (double)xpMade / (double)xpAttempt * 100;
        return String.format("%n%s%n%s%n%s%n%n%-28s%,.1f%n%n%28s%n%-31s%,.1f%n%-29s%d%n%-28s%d%n%-29s%d%n%-28s%,.1f %%%n%-28s%,.1f %%%n",
                 getPosition(),
                 getPlayer(), getTeam(),
                 "2021 Total Points: ", getPrevPoints(),
                 "2022 Projected",
                 "Points: ", getProjPoints(),
                 "1-39 Yards: ", made1to39,
                 "40-49 Yards: ", made40to49,
                 "50+ Yards: ", made50plus,
                 "Total FG Percent: ", fgPercent,
                 "Total XP Percent: ", xpPercent);
    }
}
