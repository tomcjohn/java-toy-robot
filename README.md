
Tom John - 8th Feb 2016

My implementation of the REA Group Toy Robot programming exercise.

Test data has been supplied as ./robot-test.in. This filename is hardcoded in
the ToyRobot#main() method. It ignores a few commands prior to the first valid
PLACE and then begins at (1,1,EAST).  It then moves to 4,2,EAST where it ignores
a couple of MOVE commands which would cause it to fall of the table. From there
it moves to 2,1,WEST where it jumps to 1,3,NORTH with a second valid PLACE and
then continues to finish at 2,4,NORTH.

Run with:
./gradlew clean compileJava execute

Expected output:
1,1,EAST
4,2,EAST
2,1,WEST
1,3,NORTH
2,4,NORTH

I also added unit tests in ToyRobotUnitTest, the examples from the problem description
and some further tests to prove expected behaviour of ToyRobot.

To run unit tests:
./gradlew clean test
