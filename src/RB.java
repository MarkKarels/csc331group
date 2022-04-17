/**
 * Goto https://fantasy.espn.com/football/players/projections for player stats
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

    @Override
    public String toString() {
        return String.format("%s%-30s%d%n%-27s%,.1f%n",
                super.toString(),
                "Rushing Carries: ", rushCar,
                "Average Yds Per Carry: ", avgYDsPerCar);
    }
}
