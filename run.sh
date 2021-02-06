#!/bin/bash

$JAVA_HOME/bin/javac Player.java
$JAVA_HOME/bin/javac TeamSelection.java
$JAVA_HOME/bin/javac Main.java

$JAVA_HOME/bin/java Main

## Cleanup
rm Player.class TeamSelection.class Main.class