public class Player {
    private String player;
    private String thumbImage;
    private String largeImage;

    public Player (String player, String thumbImage, String largeImage) {
        this.player = player;
        this.thumbImage = thumbImage;
        this.largeImage = largeImage;
    }

    // Mutators
    public void setPlayer(String player) {this.player = player;}
    public void setThumbImage(String thumbImage) {this.thumbImage = thumbImage;}
    public void setLargeImage(String largeImage) {this.largeImage = largeImage;}

    public String getPlayer() {return player;}
    public String getThumbImage() {return thumbImage;}
    public String getLargeImage() {return largeImage;}

    @Override
    public String toString(){
        return String.format("%s", player);
    }
}
