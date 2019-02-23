package au.com.iselect.challenge;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @Author Akbar
 * @DATE 2/23/2019.
 */

@Getter
@NoArgsConstructor
public class Robot {
    private int x;
    private int y;
    private Facing facing;
    private Grid grid;

    public Robot(int x, int y, Facing facing, Grid grid) {
        this.x = x;
        this.y = y;
        this.facing = facing;
        this.grid = grid;
    }

    public void move() {
        switch (facing) {
            case NORTH:
                y = (grid.isRobotPositionValid(x, ++y)) ? y : grid.getHeight();
                break;
            case SOUTH:
                y = (grid.isRobotPositionValid(x, --y)) ? y : 0;
                break;
            case EAST:
                x = (grid.isRobotPositionValid(++x, y)) ? x : grid.getWidth();
                break;
            case WEST:
                x = (grid.isRobotPositionValid(--x, y)) ? x : 0;
                break;
        }
    }

    public void turnLeft() {
        switch (facing){
            case NORTH:
                facing = Facing.WEST;
                break;
            case SOUTH:
                facing = Facing.WEST;
                break;
            case EAST:
                facing = Facing.NORTH;
                break;
            case WEST:
                facing = Facing.SOUTH;
                break;
        }
    }

    public void turnRight() {
        switch (facing){
            case NORTH:
                facing = Facing.EAST;
                break;
            case SOUTH:
                facing = Facing.WEST;
                break;
            case EAST:
                facing = Facing.SOUTH;
                break;
            case WEST:
                facing = Facing.NORTH;
                break;
        }
    }
}
