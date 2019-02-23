package au.com.iselect.challenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * @Author Akbar
 * @DATE 2/23/2019.
 */
public class RobotTest {

    private Robot robot;


    @Before
    public void setUp() throws Exception {
        robot = new Robot(2, 2, Facing.NORTH, new Grid(5,5));
    }

    @Test
    public void moveTest() throws Exception {
        robot.move();
        Assert.assertEquals(robot.getX(), 2);
        Assert.assertEquals(robot.getY(), 3);
        Assert.assertEquals(robot.getFacing(), Facing.NORTH);
    }

    @Test
    public void turnLeftTest() throws Exception {
        robot.turnLeft();
        Assert.assertEquals(robot.getX(), 2);
        Assert.assertEquals(robot.getY(), 2);
        Assert.assertEquals(robot.getFacing(), Facing.WEST);
    }

    @Test
    public void turnRightTest() throws Exception {
        robot.turnRight();
        Assert.assertEquals(robot.getX(), 2);
        Assert.assertEquals(robot.getY(), 2);
        Assert.assertEquals(robot.getFacing(), Facing.EAST);
    }

}