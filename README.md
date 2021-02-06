## Football Team Selection

### Run Instructions:

1. Ensure that `JAVA_HOME` is set correctly in `PATH` environment variable
2. `chmod +x run.sh`
3. `./run.sh`

`NOTE: Please use git bash or other bash executable terminal emulator for Windows OS`

Input :- stdin

Output :- stdout

### Input Format:

First line: Single integer `r` representing Number of Players

Second line: Single integer `c` representing Number of Attributes (Player features)

Next `r` lines: Space Separated `c` values - `String name`, `float height`, `float BMI`, `int scores`, `int defends` 

Players are always sorted by their names.

### Output:

Print `r` lines

`name`, `SELECT/REJECT`, `DEFENDER/STRIKER/NA`

### Rules:

1. Player order in output should be same as that of input
2. Number of strikers should be equal to number of defenders
3. Select the best (one with higher scores/defends) in case of multiple candidates

### Selection Criteria:

1. `height >= 5.8`
2. `BMI <= 23`
3. `scores >= 50` for strikers
4. `defends >= 30` for defenders

### File Structure:

`Player.java` - Contains player features

`TeamSelection.java` - Evaluates players based on the rules

`Main.java` - Driver to call TeamSelection

`run.sh` - Executable

### Approach:

1. Take input
2. Reject if the player is unfit
3. From the remaining fit players, create two collections based on eligibility - strikers and defenders
4. Include strikers and defenders (in descending order of their scores/defends)

### Challenges:

1. Pick best player

Use Treemap {key: scores/defends, value: players}

2. Multiple players having same scores/defences

Use Treemap {key: scores/defends, value: player list}

3. Same player eligible for both striker and defender

### Sample Input:

```
4
5
Boateng 6.1 22 24 45
Kaka 6 22 1 1
Ronaldo 5.8 21 120 0
Suarez 5.9 20 100 1
```

### Sample Output:

```
Boateng SELECT DEFENDER
Kaka REJECT NA
Ronaldo SELECT STRIKER
Suarez REJECT NA
```