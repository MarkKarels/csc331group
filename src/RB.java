/** class Def is a subclass of class Flex
 * It contains the necessary stats/information for each Running Back (RB) player object
 * For Player Stats, visit: https://fantasy.espn.com/football/players/projections
 */
public class RB extends Flex{
    // instance variables
    private int rushCar;
    private double avgYDsPerCar;

    // constructor
    public RB(String player, String team, String thumbImage, String largeImage, String position, double prevPoints, double projPoints,
              double rushYDs, int rushTDs, int receptions, double receivingYDs, int receivingTDs, int rushCar, double avgYDsPerCar){
        super(player, team, thumbImage, largeImage, position, prevPoints, projPoints, rushYDs, rushTDs, receptions, receivingYDs, receivingTDs);
        this.rushCar = rushCar;
        this.avgYDsPerCar = avgYDsPerCar;
    }

    // mutators (setters)
    public void setRushCar(int rushCar) {this.rushCar = rushCar;}
    public void setAvgYDsPerCar(double avgYDsPerCar) {this.avgYDsPerCar = avgYDsPerCar;}

    // accessors (getters)
    public int getRushCar() {return rushCar;}
    public double getAvgYDsPerCar() {return avgYDsPerCar;}

    /** Overriding toString method to display each running back (RB) object's stats
     * @return String.format: a formatted string containing stats
     */
    @Override
    public String toString() {
        return String.format("%s%-30s%d%n%-27s%,.1f%n",
                super.toString(),
                "Rushing Carries: ", rushCar,
                "Average Yds Per Carry: ", avgYDsPerCar);
    }
}
