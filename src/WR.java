/**
 * Goto https://fantasy.espn.com/football/players/projections for player stats
 */
public class WR extends Flex {
    // instance variables
    private int targets;
    private double avgYDsPerCatch;
    // constructor
    public WR(String player, String team, String thumbImage, String largeImage, String position, double prevPoints, double projPoints,
              double rushYDs, int rushTDs, int receptions, double receivingYDs, int receivingTDs, int targets, double avgYDsPerCatch){
        super(player, team, thumbImage, largeImage, position, prevPoints, projPoints, rushYDs, rushTDs, receptions, receivingYDs, receivingTDs);
        this.targets = targets;
        this.avgYDsPerCatch = avgYDsPerCatch;
    } // end constructor
    // mutators (setters)
    public void setTargets(int targets) {this.targets = targets;}
    public void setAvgYDsPerCatch(double avgYDsPerCatch) {this.avgYDsPerCatch = avgYDsPerCatch;}
    // accessors (getters)
    public int getTargets() {return targets;}
    public double getAvgYDsPerCatch() {return avgYDsPerCatch;}
    // toString method
    @Override
    public String toString() {
        return String.format("%s%-29s%d%n%-27s%,.1f%n",
                super.toString(),
                "Total Targets: ", targets,
                "Average Yds Per Catch: ", avgYDsPerCatch);
    }
}
