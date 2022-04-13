public class RB extends Flex{
    // instance variables
    private int rushCar;
    private double avgYDsPerCar;

    // constructor
    public RB(int rushCar, double avgYDsPerCar){
        // super();
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
        return String.format("Rushing Attempts: %d%n" +
                "Average Yard per Carry: %,.2f%n",
                this.rushCar, this.avgYDsPerCar);
    }
}
