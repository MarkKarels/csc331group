/**
 * Goto https://fantasy.espn.com/football/players/projections for player stats
 */
public class Player {
    private String player;
    private String team;
    private String thumbImage;
    private String largeImage;
    private String position;
    private double prevPoints;
    private double projPoints;

    public Player (String player, String team, String thumbImage, String largeImage, String position, double prevPoints, double projPoints) {
        this.player = player;
        this.team = team;
        this.thumbImage = thumbImage;
        this.largeImage = largeImage;
        this.position = position;
        this.prevPoints = prevPoints;
        this.projPoints = projPoints;
    }

    public Player(){}

    // Mutators
    public void setPlayer(String player) {this.player = player;}
    public void setTeam(String team) {this.team = team;}
    public void setThumbImage(String thumbImage) {this.thumbImage = thumbImage;}
    public void setLargeImage(String largeImage) {this.largeImage = largeImage;}
    public void setPosition(String position) {this.position = position;}
    public void setPrevPoints(double prevPoints) {this.prevPoints = prevPoints;}
    public void setProjPoints(double projPoints) {this.projPoints = projPoints;}

    // Accessors
    public String getPlayer() {return player;}
    public String getTeam() {return team;}
    public String getThumbImage() {return thumbImage;}
    public String getLargeImage() {return largeImage;}
    public String getPosition() {return  position;}
    public double getPrevPoints() {return prevPoints;}
    public double getProjPoints() {return projPoints;}

    @Override
    public String toString(){
        return String.format("%s", player);
    }
}
