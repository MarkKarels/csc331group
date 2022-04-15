public class DST extends Flex {
    /**
     * Goto https://fantasy.espn.com/football/players/projections for player stats
     */
    // instance variables

    private int sacks;
    private int interceptions;
    private int fumbleRecover;
    private int totalTDs;
    private int pointsAgainst;
    private double yardsAgainst;

    // constructor
    public DST(
               int sacks, int interceptions, int fumbleRecover, int totalTDs, int pointsAgainst, double yardsAgainst) {
        //super();
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

    @Override
    public String toString() {
        return String.format("Sacks: %d%nInterceptions: %d%nFumble Recoveries: %d%nTotal Touchdowns: %d%n Points Against: %d%nYards Against: %.2f",
                this.sacks, this.interceptions, this.fumbleRecover, this.totalTDs, this.pointsAgainst, this.yardsAgainst);
    }


}
