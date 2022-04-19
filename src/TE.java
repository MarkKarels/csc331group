/** class TE is a subclass of class Flex
 * It contains the necessary stats/information for each Tight End (TE) player object
 * For Player Stats, visit: https://fantasy.espn.com/football/players/projections
 */
public class TE extends Flex{
    //instance variables
    private int targets;
    private double avgYDsPerCatch;

    // constructor
    public TE(String player, String team, String thumbImage, String largeImage, String position, double prevPoints, double projPoints,
              double rushYDs, int rushTDs, int receptions, double receivingYDs, int receivingTDs, int targets, double avgYDsPerCatch){
        super(player, team, thumbImage, largeImage, position, prevPoints, projPoints, rushYDs, rushTDs, receptions, receivingYDs, receivingTDs);
        this.targets = targets;
        this.avgYDsPerCatch = avgYDsPerCatch;
    }
    //mutators (setters)
    public void setTargets(int targets){
        this.targets = targets;
    }
    public void setAvgYDsPerCatch(double avgYDsPerCatch){
        this.avgYDsPerCatch = avgYDsPerCatch;
    }

    //accessors (getters)
    public int getTargets(){
        return this.targets;
    }
    public double getAvgYDsPerCatch(){
        return this.avgYDsPerCatch;
    }

    /** Overriding toString method to display each tight end (TE) object's stats
     * @return String.format: a formatted string containing stats
     */
    @Override
    public String toString() {
        return String.format("%s%-30s%d%n%-27s%,.1f%n",
                super.toString(),
                "Total Targets: ", targets,
                "Average Yds Per Catch: ", avgYDsPerCatch);
    }
}
