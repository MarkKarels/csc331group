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
        return String.format("%n%s%n%s%n%s%n2021 Total Points: %,.1f pts%n 2022 Projected: %,.1f pts%nRush Yards: %,.2f%nRush TDs: %d%nReceptions: %d%nReceiving Yards: %,.2f%nReceiving TDs: %d%n ",
                getPosition(),
                getPlayer(),
                getTeam(),
                getPrevPoints(),
                getProjPoints(),
                this.rushYDs,
                this.rushTDs,
                this.receptions,
                this.receivingYDs,
                this.receivingTDs);
    }

}
