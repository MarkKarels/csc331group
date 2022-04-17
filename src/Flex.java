/**
 * Goto https://fantasy.espn.com/football/players/projections for player stats
 */
public class Flex extends Player{
    private double rushYDs;
    private int rushTDs;
    private int receptions;
    private double receivingYDs;
    private int receivingTDs;

    public Flex(String player, String team, String thumbImage, String largeImage, String position, double prevPoints, double projPoints,
                double rushYDs, int rushTDs, int receptions, double receivingYDs, int receivingTDs){
        super(player, team, thumbImage, largeImage, position, prevPoints, projPoints);
        this.rushYDs=rushYDs;
        this.rushTDs=rushTDs;
        this.receptions=receptions;
        this.receivingYDs=receivingYDs;
        this.receivingTDs=receivingTDs;
    }
    public void setRushYDs(double rushYDs){this.rushYDs=rushYDs;}
    public void setRushTDs(int rushTDs){this.rushTDs=rushTDs;}
    public void setReceptions(int receptions){this.receptions=receptions;}
    public void setReceivingYDs(double receivingYDs){this.receivingYDs=receivingYDs;}
    public void setReceivingTDs(int receivingTDs){this.receivingTDs=receivingTDs;}

    public double getRushYDs(){return rushYDs;}
    public int getRushTDs(){return rushTDs;}
    public int getReceptions(){return receptions;}
    public double getReceivingYDs(){return receivingYDs;}
    public int getReceivingTDs(){return receivingTDs;}

    @Override
    public String toString(){
        return String.format("%n%s%n%s%n%s%n%n%-30s%,.1f%n%n%28s%n%-32s%,.1f%n%-30s%,.1f%n%-28s%d%n%-29s%d%n%-28s%,.1f%n%-29s%d%n",
                getPosition(),
                getPlayer(), getTeam(),
                "2021 Total Points: ", getPrevPoints(),
                "2022 Projected",
                "Points: ", getProjPoints(),
                "Passing Yards: ", rushYDs,
                "Passing Touchdowns: ", rushTDs,
                "Passing Interceptions: ", receptions,
                "Rushing Attempts: ", receivingYDs,
                "Rushing Yards: ", receivingTDs);
    }
}
