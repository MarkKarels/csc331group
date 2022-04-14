public class DisplayTeam {
    private String QB;
    private String RB1;
    private String RB2;
    private String WR1;
    private String WR2;
    private String TE;
    private String FLEX;
    private String K;
    private String DEF;

    public DisplayTeam() {}

    public void setQB(String QB) {this.QB = QB;}
    public void setRB1(String RB1) {this.RB1 = RB1;}
    public void setRB2(String RB2) {this.RB2 = RB2;}
    public void setWR1(String WR1) {this.WR1 = WR1;}
    public void setWR2(String WR2) {this.WR2 = WR2;}
    public void setTE(String TE) {this.TE = TE;}
    public void setFLEX(String FLEX) {this.FLEX = FLEX;}
    public void setK(String K) {this.K = K;}
    public void setDEF(String DEF) {this.DEF = DEF;}

    public String getQB() {return QB;}
    public String getRB1() {return RB1;}
    public String getRB2() {return RB2;}
    public String getWR1() {return WR1;}
    public String getWR2() {return WR2;}
    public String getTE() {return TE;}
    public String getFLEX() {return FLEX;}
    public String getK() {return K;}
    public String getDEF() {return DEF;}

    @Override
    public String toString() {
        return String.format("%n%n%-19s%s%n%-20s%s%n%-20s%s%n%-19s%s%n%-19s%s%n%-21s%s%n%-21s%s%n%-22s%s%n%-19s%s%n",
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
