# TrainsChallenge

REQUERIMENTS:
You must have MAVEN installed on your computer.

DESCRIPTION:
This application serves to inform users who are in a certain train station information about the possible destinations to which they can visit, providing the shortest distance routes to each destination they wish to visit.

USE FROM CONSOLE:
The user must enter the station where he is, having to choose between station A, B, C, D or E passed as an argument when running the application.
Example:
* If the user is in station A, they must put:     mvn exec:java -Dexec.mainClass="main.mainApp" -Dexec.args="A"
* If the user is in station B, they must put:     mvn exec:java -Dexec.mainClass="main.mainApp" -Dexec.args="B"

To run Tests you must enter:     "  mvn clean test  "
