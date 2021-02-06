import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;

public class TeamSelection {
    List<Player> players;

    TeamSelection() {
        players = new ArrayList<>();
    }

    public void inputPlayers(int numPlayers, Scanner s) {
        for (int i = 0; i < numPlayers; i++) {
            Player p = new Player();
            p.setName(s.next());
            p.setHeight(s.nextFloat());
            p.setBMI(s.nextFloat());
            p.setScores(s.nextInt());
            p.setDefends(s.nextInt());
            players.add(p);
        }
    }

    private void rejectPlayer(Player p) {
        p.setVerdict("REJECT");
        p.setRole("NA");
    }

    private void selectPlayer(Player p, String role) {
        p.setVerdict("SELECT");
        p.setRole(role);
    }

    private void evaluateRoles(Map<Integer, List<Player> > roleMap, String role, int limit) {
        int i = 0;
        for (List<Player> pl : roleMap.values()) {
            for (Player p : pl) {
                if (i < limit) {
                    selectPlayer(p, role);
                    i++;
                } else {
                    rejectPlayer(p);
                }
            }
        }
    }

    private void roleMapInsert(Map<Integer, List<Player> > roleMap, Player p) {
        if (roleMap.containsKey(p.getScores())) {
            roleMap.get(p.getScores()).add(p);
        } else {
            List<Player> pl = new ArrayList<>();
            pl.add(p);
            roleMap.put(p.getScores(), pl);
        }
    }

    public void evaluatePlayers() {
        // FIXME: Handle cases where the player is eligible for both Striker and Defender

        Map<Integer, List<Player> > strikerMap = new TreeMap<>(Collections.reverseOrder());
        Map<Integer, List<Player> > defenderMap = new TreeMap<>(Collections.reverseOrder());
        
        for (Player p : players) {
            if (p.isFit()) {
                if (p.isStrikerEligible()) {
                    roleMapInsert(strikerMap, p);
                } else if (p.isDefenderEligible()) {
                    roleMapInsert(defenderMap, p);
                } else {
                    rejectPlayer(p);
                }
            } else {
                rejectPlayer(p);
            }
        }
        int limit = Math.min(strikerMap.size(), defenderMap.size());
        evaluateRoles(strikerMap, "STRIKER", limit);
        evaluateRoles(defenderMap, "DEFENDER", limit);
    }

    public void printVerdict() {
        for (Player p : players) {
            System.out.println(p.getName() + " " + p.getVerdict() + " " + p.getRole());
        }
    }
}