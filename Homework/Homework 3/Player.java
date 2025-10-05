// Name: Richard He
// Computing ID: rtk8qj@virginia.edu
// Homework Name: Homework 3 - Soccer
// Resources used: none

public class Player {
    private String pName;
    private String pPosition;
    private int minPlayed, pGoals, pAssists;
    private double pPercentage;

    public Player() {
        this.pName = "";
        this.pPosition = "";
        this.minPlayed = 0;
        this.pGoals = 0;
        this.pAssists = 0;
        this.pPercentage = 0.0;
    }

    public Player(String n, String p, int m, int g, int a, double pp) {
        if (n != null) {
            this.pName = n;
        } else {
            this.pName = "";
        }
        if (p != null && (p.toLowerCase().equals("defense") || p.toLowerCase().equals("midfield")
                || p.toLowerCase().equals("forward") || p.toLowerCase().equals("goalie"))) {
            this.pPosition = p;
        } else {
            this.pPosition = "";
        }
        if (m < 0) {
            this.minPlayed = 0;
        } else {
            this.minPlayed = m;
        }
        if (g < 0) {
            this.pGoals = 0;
        } else {
            this.pGoals = g;
        }
        if (a < 0) {
            this.pAssists = 0;
        } else {
            this.pAssists = a;
        }
        if (pp < 0 || pp > 1) {
            this.pPercentage = 0;
        } else {
            this.pPercentage = pp;
        }
    }

    public void setName(String n) {
        if (n != null && !n.equals("")) { // if parameter is invalid (empty)
            this.pName = n;
        }
    }

    public String getName() {
        return pName;
    }

    public void setPosition(String p) {
        if (p != null && !p.equals("") && (p.toLowerCase().equals("defense") || p.toLowerCase().equals("midfield")
                || p.toLowerCase().equals("forward") || p.toLowerCase().equals("goalie"))) { // if parameter is invalid
                                                                                             // (empty)
            this.pPosition = p;
        }
    }

    public String getPosition() {
        return this.pPosition;
    }

    public int getMinutes() {
        return this.minPlayed;
    }

    public int getAssists() {
        return this.pAssists;
    }

    public int getGoals() {
        return this.pGoals;
    }

    public double getSOG() {
        return this.pPercentage;
    }

    public void setSOG(double s) {
        this.pPercentage = s;
    }

    public String toString() {
        return "Your name is: " + pName + ". Your position is: " + pPosition + " and you've played " + minPlayed
                + " minutes this season. You've made " + pAssists + " assists and  " + pGoals
                + " goals. Your shots-on-goal percentage is " + pPercentage + ".";
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof Player) {
            Player o1 = (Player) o;
            return this.pName.toLowerCase().equals(o1.getName().toLowerCase())
                    && this.pPosition.toLowerCase().equals(o1.getPosition().toLowerCase())
                    && this.minPlayed == o1.getMinutes() && this.pPercentage == o1.getSOG();
        }
        return false;
    }
}