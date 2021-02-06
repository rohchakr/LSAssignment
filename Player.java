public class Player {
    String name;
    float height;
    float BMI;
    int scores;
    int defends;
    String verdict;
    String role;
    private static final double MINHEIGHT = 5.8;
    private static final double MAXBMI = 23;
    private static final int MINGOALSCORED = 50;
    private static final int MINGOALDEFENDED = 30;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getBMI() {
        return BMI;
    }

    public void setBMI(float bMI) {
        BMI = bMI;
    }

    public int getScores() {
        return scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }

    public int getDefends() {
        return defends;
    }

    public void setDefends(int defends) {
        this.defends = defends;
    }

    public String getVerdict() {
        return verdict;
    }

    public void setVerdict(String verdict) {
        this.verdict = verdict;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isFit() {
        return (this.height >= MINHEIGHT && this.BMI <= MAXBMI);
    }
    
    public boolean isStrikerEligible() {
        return this.scores >= MINGOALSCORED;
    }

    public boolean isDefenderEligible() {
        return this.defends >= MINGOALDEFENDED;
    }
}