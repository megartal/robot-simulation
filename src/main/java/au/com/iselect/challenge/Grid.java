package au.com.iselect.challenge;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Author Akbar
 * @DATE 2/23/2019.
 */
@Getter
@AllArgsConstructor
@Service
@NoArgsConstructor
public class Grid {
    @Value("${height}")
    private int height;
    @Value("${width}")
    private int width;

    public boolean isRobotPositionValid(int x, int y) {
        return ((0 <= x && x < width) && (0 <= y && y < height)) ? true : false;
    }
}
