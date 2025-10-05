// Name: Richard He
// Computing ID: rtk8qj@virginia.edu
// Homework Name: Homework 3 - Soccer
// Resources used: https://beginnersbook.com/2014/07/java-program-for-bubble-sort-in-ascending-descending-order/

public class Team {
    private Player[] team;

    public Team(Player[] t) {
        // consider edge cases
        team = new Player[t.length];
        Player[] temp = t.clone();
        for (int i = 0; i < temp.length; i++) {
            this.team[i] = new Player(temp[i].getName(), temp[i].getPosition(), temp[i].getMinutes(),
                    temp[i].getGoals(), temp[i].getAssists(), temp[i].getSOG());
        }
        // this.team = t.clone(); // deep and shallow copies!
    }

    public Player[] getTeam() {
        return this.team;
    }

    public void setTeam(Player[] players) {
        // this.team = players.clone();
        team = new Player[players.length];
        Player[] temp = players.clone();
        for (int i = 0; i < temp.length; i++) {
            this.team[i] = new Player(temp[i].getName(), temp[i].getPosition(), temp[i].getMinutes(),
                    temp[i].getGoals(), temp[i].getAssists(), temp[i].getSOG());
        }
    }

    // public boolean equals(Object o) {
    // return o.equals(team); // revisit
    // }

    public String toString() {
        String answer = " ";
        for (Player p : team) {
            answer += p;
            answer += "\n";
        }
        return answer;
    }

    public double SOGAverage() {
        double avg = 0;
        if (team.length == 0) {
            return 0;
        }
        for (Player p : team) {
            avg += p.getSOG();
        }

        return avg / team.length;
    }

    public int positionCount(String pos) {
        int amount = 0;
        for (Player p : team) {
            if (p.getPosition().toLowerCase().equals(pos.toLowerCase())) {
                amount++;
            }
        }
        return amount;
    }

    public Player[] sort() {
        Player[] megaTemp = new Team(this.getTeam()).getTeam();
        for (int i = 0; i < (megaTemp.length - 1); i++) {
            for (int j = 0; j < megaTemp.length - i - 1; j++) {
                if (megaTemp[j].getMinutes() < megaTemp[j + 1].getMinutes()) {
                    Player temp = megaTemp[j];
                    megaTemp[j] = megaTemp[j + 1];
                    megaTemp[j + 1] = temp;
                }
            }
        }
        return megaTemp;
        // java sorting method
    }

    public boolean onTeam(String n) {
        for (Player p : team) {
            if (p.getName().toLowerCase().equals(n.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public Player mostGoals() {
        int max = 0;
        Player mostPlayer = null;
        for (Player p : team) {
            if (p.getGoals() > max) {
                max = p.getGoals();
                mostPlayer = p;
            }
        }
        return mostPlayer;
    }

    public boolean equals(Object t) {
        boolean answer = true;
        if (t == null) {
            return false;
        }
        if (!(t instanceof Team)) {
            return false;
        }
        if (t != null && t instanceof Team) {

            Player[] t1 = ((Team) t).sort();

            Player[] temp = this.sort();

            for (int i = 0; i < temp.length; i++) {
                if (!temp[i].equals(t1[i])) {
                    answer = false;
                }
            }
        }
        return answer;
    }

}
