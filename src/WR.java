/**
 * Goto https://fantasy.espn.com/football/players/projections for player stats
 */
public class WR extends Flex {

    // instance variables
    private int targets;
    private double avgYDsPerCatch;

    // constructor
    public WR(int targets, double avgYDsPerCatch){
        // super();
        this.targets = targets;
        this.avgYDsPerCatch = avgYDsPerCatch;
    } // end constructor

    // mutators (setters)
    public void setTargets(int targets) {this.targets = targets;}
    public void setAvgYDsPerCatch(double avgYDsPerCatch) {this.avgYDsPerCatch = avgYDsPerCatch;}

    // accessors (getters)
    public int getTargets() {return targets;}
    public double getAvgYDsPerCatch() {return avgYDsPerCatch;}

    @Override
    public String toString() {
        return String.format("Total Targets: %d%nAverage YPC: %,.2f",
                this.getTargets(), this.getAvgYDsPerCatch());
    }
}
