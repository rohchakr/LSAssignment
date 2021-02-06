import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TeamSelection ts = new TeamSelection();
        Scanner s = new Scanner(System.in);
        // First Input - Number of rows
        int numPlayers = s.nextInt();
        // Second Input - Number of columns
        int features = s.nextInt();
        ts.inputPlayers(numPlayers, s);
        ts.evaluatePlayers();
        ts.printVerdict();
    }
}