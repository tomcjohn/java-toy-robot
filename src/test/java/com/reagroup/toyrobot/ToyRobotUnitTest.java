package com.reagroup.toyrobot;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit tests for {@link ToyRobot}.
 */
public class ToyRobotUnitTest {

    /**
     * Example test data A from problem definition.
     */
    @Test
    public void testExampleA() {
        final Universe universe = new SquareUniverse(5);
        final Robot robot = new ToyRobot(universe);

        robot.place(0, 0, Direction.NORTH);
        robot.move();
        assertEquals("0,1,NORTH", robot.report());
    }

    /**
     * Example test data B from problem definition.
     */
    @Test
    public void testExampleB() {
        final Universe universe = new SquareUniverse(5);
        final Robot robot = new ToyRobot(universe);

        robot.place(0, 0, Direction.NORTH);
        robot.left();
        assertEquals("0,0,WEST", robot.report());
    }

    /**
     * Example test data C from problem definition.
     */
    @Test
    public void testExampleC() {
        final Universe universe = new SquareUniverse(5);
        final Robot robot = new ToyRobot(universe);

        robot.place(1, 2, Direction.EAST);
        robot.move();
        robot.move();
        robot.left();
        robot.move();
        assertEquals("3,3,NORTH", robot.report());
    }

    /**
     * Check behaviour of the {@link ToyRobot#right()} method.
     */
    @Test
    public void testRight() {
        final Universe universe = new SquareUniverse(5);
        final Robot robot = new ToyRobot(universe);

        robot.place(1, 2, Direction.NORTH);
        assertEquals("1,2,NORTH", robot.report());
        robot.right();
        assertEquals("1,2,EAST", robot.report());
        robot.right();
        assertEquals("1,2,SOUTH", robot.report());
        robot.right();
        assertEquals("1,2,WEST", robot.report());
        robot.right();
        assertEquals("1,2,NORTH", robot.report());
    }

    /**
     * Check behaviour of the {@link ToyRobot#left()} method.
     */
    @Test
    public void testLeft() {
        final Universe universe = new SquareUniverse(5);
        final Robot robot = new ToyRobot(universe);

        robot.place(1, 2, Direction.NORTH);
        assertEquals("1,2,NORTH", robot.report());
        robot.left();
        assertEquals("1,2,WEST", robot.report());
        robot.left();
        assertEquals("1,2,SOUTH", robot.report());
        robot.left();
        assertEquals("1,2,EAST", robot.report());
        robot.left();
        assertEquals("1,2,NORTH", robot.report());
    }

    /**
     * Check all instructions before the first place are ignored.
     */
    @Test
    public void testInstructionsBeforeFirstPlaceAreIgnored() {
        final Universe universe = new SquareUniverse(5);
        final Robot robot = new ToyRobot(universe);

        assertEquals("Not placed", robot.report());
        robot.move();
        assertEquals("Not placed", robot.report());
        robot.left();
        assertEquals("Not placed", robot.report());
        robot.move();
        assertEquals("Not placed", robot.report());
        robot.right();
        assertEquals("Not placed", robot.report());
        robot.place(1, 2, Direction.NORTH);
        assertEquals("1,2,NORTH", robot.report());
        robot.move();
        assertEquals("1,3,NORTH", robot.report());
        robot.left();
        assertEquals("1,3,WEST", robot.report());
        robot.move();
        assertEquals("0,3,WEST", robot.report());
        robot.right();
        assertEquals("0,3,NORTH", robot.report());
    }

    /**
     * Check the robot can neither be placed nor moved outside of the bounds of the universe.
     */
    @Test
    public void testUniverseBounds() {
        final Universe universe = new SquareUniverse(5);
        final Robot robot = new ToyRobot(universe);

        // check we can't place outside the bounds
        robot.place(6, 5, Direction.NORTH);
        assertEquals("Not placed", robot.report());
        robot.place(5, 6, Direction.NORTH);
        assertEquals("Not placed", robot.report());

        // check northerly movement
        robot.place(2, 4, Direction.NORTH);
        assertEquals("2,4,NORTH", robot.report());
        robot.move();
        assertEquals("2,4,NORTH", robot.report());

        // check southerly movement
        robot.place(2, 0, Direction.SOUTH);
        assertEquals("2,0,SOUTH", robot.report());
        robot.move();
        assertEquals("2,0,SOUTH", robot.report());

        // check easterly movement
        robot.place(4, 2, Direction.EAST);
        assertEquals("4,2,EAST", robot.report());
        robot.move();
        assertEquals("4,2,EAST", robot.report());

        // check westerly movement
        robot.place(0, 2, Direction.WEST);
        assertEquals("0,2,WEST", robot.report());
        robot.move();
        assertEquals("0,2,WEST", robot.report());
    }
}
