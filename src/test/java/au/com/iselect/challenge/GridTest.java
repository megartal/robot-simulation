package au.com.iselect.challenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author Akbar
 * @DATE 2/23/2019.
 */
public class GridTest {

    private Grid grid;
    @Before
    public void setUp() throws Exception {
        grid = new Grid(5, 5);
    }

    @Test
    public void isRobotPositionValidTest() throws Exception {
        Assert.assertEquals(true, grid.isRobotPositionValid(3, 3));
        Assert.assertEquals(true, grid.isRobotPositionValid(0, 4));
        Assert.assertEquals(true, grid.isRobotPositionValid(0, 0));
        Assert.assertEquals(false, grid.isRobotPositionValid(5, 0));
        Assert.assertEquals(false, grid.isRobotPositionValid(5, 5));
        Assert.assertEquals(false, grid.isRobotPositionValid(0, 5));
    }

}