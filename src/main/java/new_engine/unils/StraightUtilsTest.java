package new_engine.unils;

import new_engine.figure.Point;
import new_engine.figure.Straight;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты для StraightUtils
 * <p>
 * Created by steam on 14.03.17.
 */
public class StraightUtilsTest {

    /**
     * Прямые НЕ пересекаются
     *
     * @throws Exception ex
     */
    @Test
    public void notCrossStraight() throws Exception {
        Point a1 = new Point(0f, 0f);
        Point a2 = new Point(10f, 10f);
        Point b1 = new Point(20f, 20f);
        Point b2 = new Point(40f, 40f);

        Optional<Point> crossedPoint = StraightUtils.getCrossedPoint(
                new Straight(a1, a2),
                new Straight(b1, b2)
        );
        assertThat(crossedPoint.isPresent(), is(false));
    }

    /**
     * Прямые пересекаются в начальной точке
     *
     * @throws Exception ex
     */
    @Test
    public void startInOnePoint() throws Exception {
        Point a1 = new Point(0f, 0f);
        Point a2 = new Point(10f, 10f);
        Point b1 = new Point(0f, 0f);
        Point b2 = new Point(10f, 0f);

        Optional<Point> crossedPoint = StraightUtils.getCrossedPoint(
                new Straight(a1, a2),
                new Straight(b1, b2)
        );
        assertThat(crossedPoint.isPresent(), is(true));
        assertThat(crossedPoint.get().getX(), is(0f));
        assertThat(crossedPoint.get().getY(), is(0f));
    }

    /**
     * Прямые пересекаются в какой-то обычной точке
     *
     * @throws Exception ex
     */
    @Test
    public void crossStraight() throws Exception {
        Point a1 = new Point(0f, 0f);
        Point a2 = new Point(10f, 10f);
        Point b1 = new Point(0f, 10f);
        Point b2 = new Point(10f, 0f);

        Optional<Point> crossedPoint = StraightUtils.getCrossedPoint(
                new Straight(a1, a2),
                new Straight(b1, b2)
        );
        assertThat(crossedPoint.isPresent(), is(true));
        assertThat(crossedPoint.get().getX(), is(5f));
        assertThat(crossedPoint.get().getY(), is(5f));
    }

}