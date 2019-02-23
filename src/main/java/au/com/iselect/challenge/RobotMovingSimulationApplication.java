package au.com.iselect.challenge;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringJoiner;
import java.util.stream.Stream;

@SpringBootApplication
@Getter
@Setter
public class RobotMovingSimulationApplication implements CommandLineRunner {

    private Robot robot;
    private Grid grid;

    public RobotMovingSimulationApplication(Grid grid) {
        this.grid = grid;
    }

    public static void main(String[] args) {
        SpringApplication.run(RobotMovingSimulationApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        Stream<String> commands = Files.lines(Paths.get(classLoader.getResource("commands.txt").toURI()));
        commands.forEach(command -> execute(command));
    }

    public void execute(String command) {
        if (command.toUpperCase().startsWith("PLACE")) {
            String[] positionInfo = command.toUpperCase().replace("PLACE", "").trim().split(",");
            try {
                int x = Integer.parseInt(positionInfo[0]);
                int y = Integer.parseInt(positionInfo[1]);
                Facing facing = Facing.valueOf(positionInfo[2].toUpperCase());
                if ((0 <= x && x < grid.getWidth()) && (0 <= y && y < grid.getHeight())) {
                    robot = new Robot(x, y, facing, grid);
                }
            }catch (Exception e){
                //ignore the input
            }
        } else if (robot != null && command.equalsIgnoreCase("MOVE")) {
            robot.move();
        } else if (robot != null && command.equalsIgnoreCase("LEFT")) {
            robot.turnLeft();
        } else if (robot != null && command.equalsIgnoreCase("RIGHT")) {
            robot.turnRight();
        } else if (robot != null && command.equalsIgnoreCase("REPORT")) {
            System.out.println(String.format("\n\nThe robot positioned in (x = %s, y=%s), facing to: %s\n\n",
                    robot.getX(), robot.getY(), robot.getFacing()));
        }
    }
}
