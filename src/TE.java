public class TE extends Flex{
    private int targets;
    private double avgYDsPerCatch;

    public TE(String player, String team, String thumbImage, String largeImage, String position, double prevPoints, double projPoints,
              double rushYDs, int rushTDs, int receptions, double receivingYDs, int receivingTDs, int targets, double avgYDsPerCatch){
        super(player, team, thumbImage, largeImage, position, prevPoints, projPoints, rushYDs, rushTDs, receptions, receivingYDs, receivingTDs);
        this.targets = targets;
        this.avgYDsPerCatch = avgYDsPerCatch;
    }

    @Override
    public String toString() {
        return String.format("%s%n%-30s%d%n%-27s%,.1f%n",
                super.toString(),
                "Total Targets: ", targets,
                "Average Yds Per Catch: ", avgYDsPerCatch);
    }
}
