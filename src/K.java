public class K extends Player{
    private int made1to39;
    private int made40to49;
    private int made50plus;
    private int totalAttempt;
    private int totalMade;
    private int xpAttempt;
    private int xpMade;

    public K(String player, String team, String thumbImage, String largeImage, String position, double prevPoints, double projPoints,
             int made1to39, int made40to49, int made50plus, int totalAttempt, int totalMade, int xpAttempt, int xpMade){
        super(player, team, thumbImage, largeImage, position, prevPoints, projPoints);
        this.made1to39 =made1to39;
        this.made40to49 = made40to49;
        this.made50plus=made50plus;
        this.totalAttempt=totalAttempt;
        this.totalMade=totalMade;
        this.xpAttempt=xpAttempt;
        this.xpMade=xpMade;
    }

    public void setMade1to39(int made1to39){this.made1to39=made1to39;}
    public void setMade40to49(int made40to49){this.made40to49=made40to49;}
    public void setMade50plus(int made50plus){this.made50plus=made50plus;}
    public void setTotalAttempt(int totalAttempt){this.totalAttempt=totalAttempt;}
    public void setTotalMade(int totalMade){this.totalMade=totalMade;}
    public void setXpAttempt(int xpAttempt){this.xpAttempt=xpAttempt;}
    public void setXpMade(int xpMade){this.xpMade=xpMade;}

    public int getMade1to39() {return this.made1to39;}
    public int getMade40to49(){return this.made40to49;}
    public int getMade50plus(){return this.made50plus;}
    public int getTotalAttempt(){return this.totalAttempt;}
    public int getTotalMade(){return this.totalMade;}
    public int getXpAttempt(){return this.xpAttempt;}
    public int getXpMade(){return this.xpMade;}

    @Override
    public String toString() {
        return String.format("%n%s%n%s%n%s%nMade 1-39 Yards: %d%nMade 40-49 Yards: %d%nMade 50+ Yards: %d%nTotal Attempts: %d%n Total Made: %d%nExtra point attempts: %d%nExtra points made: %d",
                getPosition(), getPlayer(), getTeam(),this.made1to39, this.made40to49, this.made50plus, this.totalAttempt, this.totalMade, this.xpAttempt, this,xpMade);
    }

}
