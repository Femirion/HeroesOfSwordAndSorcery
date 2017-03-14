package new_engine.unils;

import new_engine.figure.Point;
import new_engine.figure.Straight;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты для VectorUntils
 *
 * Created by steam on 14.03.17.
 */
public class VectorUntilsTest {

    @Test
    public void crossedStraights() throws Exception {
        Straight a = new Straight(new Point(0f,0f), new Point(10f,10f));
        Straight b = new Straight(new Point(0f,10f), new Point(10f,0));

        boolean isCrossed = VectorUntils.isCrossed(a, b);
        assertThat(isCrossed, is(true));
    }

    @Test
    public void isLeftRotate() throws Exception {
        Point a1 = new Point(0f, 0f);
        Point a2 = new Point(1f, 1f);
        Point b = new Point(0.5f, 1f);

        int isLeftRotate = VectorUntils.isLeftRotate(a1, a2, b);
        assertThat(isLeftRotate, is(0));
    }

}