/** Class DisplayTeam contains the information for each user's team
 * in the Fantasy Football Draft. Each team will have 9 players (instance variables)
 * as well as setters/getters and a toString method for displaying the team roster.
 * Important to note that the in the toString method, each instance variable value will
 * initially be set to "null" until a player has been drafted.
 */
public class DisplayTeam {
    // instance variables (attributes)
    private String teamName;
    private String QB;
    private String RB1;
    private String RB2;
    private String WR1;
    private String WR2;
    private String TE;
    private String FLEX;
    private String K;
    private String DEF;

    // Null Constructor; Initial value for String variables must be null
    public DisplayTeam() {}

    // setters (mutators)
    public void setTeamName(String teamName) {this.teamName = teamName;}
    public void setQB(String QB) {this.QB = QB;}
    public void setRB1(String RB1) {this.RB1 = RB1;}
    public void setRB2(String RB2) {this.RB2 = RB2;}
    public void setWR1(String WR1) {this.WR1 = WR1;}
    public void setWR2(String WR2) {this.WR2 = WR2;}
    public void setTE(String TE) {this.TE = TE;}
    public void setFLEX(String FLEX) {this.FLEX = FLEX;}
    public void setK(String K) {this.K = K;}
    public void setDEF(String DEF) {this.DEF = DEF;}

    // getters (accessors)
    public String getTeamName() {return teamName;}
    public String getQB() {return QB;}
    public String getRB1() {return RB1;}
    public String getRB2() {return RB2;}
    public String getWR1() {return WR1;}
    public String getWR2() {return WR2;}
    public String getTE() {return TE;}
    public String getFLEX() {return FLEX;}
    public String getK() {return K;}
    public String getDEF() {return DEF;}

    // public toString() method to customize formatting of String output
    @Override
    public String toString() {
        return String.format("%n%s%n%n%-19s%s%n%-20s%s%n%-20s%s%n%-19s%s%n%-19s%s%n%-21s%s%n%-21s%s%n%-22s%s%n%-19s%s%n",
                teamName,
                "Quarterback: ", QB,
                "Running Back 1: ", RB1,
                "Running Back 2: ", RB2,
                "Wide Receiver 1: ", WR1,
                "Wide Receiver 2: ", WR2,
                "Tight End: ", TE,
                "FLEX: ", FLEX,
                "Kicker: ", K,
                "Defense/ST: ", DEF);
    }
}
