package au.com.iselect.challenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author Akbar
 * @DATE 2/23/2019.
 */
public class RobotMovingSimulationApplicationTest {

    private RobotMovingSimulationApplication application;
    private Grid grid;

    @Before
    public void setUp() throws Exception {
        grid = new Grid(5, 5);
        application = new RobotMovingSimulationApplication(grid);
        application.setRobot(new Robot(1, 1, Facing.EAST, grid));
    }

    @Test
    public void runTest() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        Assert.assertEquals(classLoader.getResource("commands.txt").getFile().contains("commands.txt"), true);
    }

    @Test
    public void executeTestPlace() throws Exception {
        application.execute("PLACE 0,0,NORTH");
        Assert.assertEquals(application.getRobot().getX(), 0);
        Assert.assertEquals(application.getRobot().getY(), 0);
        Assert.assertEquals(application.getRobot().getFacing(), Facing.NORTH);
    }

    @Test
    public void executeTestRight() throws Exception {
        application.execute("RIGHT");
        Assert.assertEquals(application.getRobot().getX(), 1);
        Assert.assertEquals(application.getRobot().getY(), 1);
        Assert.assertEquals(application.getRobot().getFacing(), Facing.SOUTH);
    }

    @Test
    public void executeTestLeft() throws Exception {
        application.execute("LEFT");
        Assert.assertEquals(application.getRobot().getX(), 1);
        Assert.assertEquals(application.getRobot().getY(), 1);
        Assert.assertEquals(application.getRobot().getFacing(), Facing.NORTH);
    }

    @Test
    public void executeTestMove() throws Exception {
        application.execute("MOVE");
        Assert.assertEquals(application.getRobot().getX(), 2);
        Assert.assertEquals(application.getRobot().getY(), 1);
        Assert.assertEquals(application.getRobot().getFacing(), Facing.EAST);
    }

    @Test
    public void executeTestReport() throws Exception {
        application.execute("REPORT");
        Assert.assertEquals(application.getRobot().getX(), 1);
        Assert.assertEquals(application.getRobot().getY(), 1);
        Assert.assertEquals(application.getRobot().getFacing(), Facing.EAST);
    }
}