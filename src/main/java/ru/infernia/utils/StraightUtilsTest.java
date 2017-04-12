package ru.infernia.utils;

import org.junit.Test;
import ru.infernia.figure.Point;
import ru.infernia.figure.Straight;

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
        Point a1 = new Point(0, 0);
        Point a2 = new Point(10, 10);
        Point b1 = new Point(20, 20);
        Point b2 = new Point(40, 40);

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
        Point a1 = new Point(0, 0);
        Point a2 = new Point(10, 10);
        Point b1 = new Point(0, 0);
        Point b2 = new Point(10, 0);

        Optional<Point> crossedPoint = StraightUtils.getCrossedPoint(
                new Straight(a1, a2),
                new Straight(b1, b2)
        );
        assertThat(crossedPoint.isPresent(), is(true));
        assertThat(crossedPoint.get().getX(), is(0));
        assertThat(crossedPoint.get().getY(), is(0));
    }

    /**
     * Прямые пересекаются в какой-то обычной точке
     *
     * @throws Exception ex
     */
    @Test
    public void crossStraight() throws Exception {
        Point a1 = new Point(0, 0);
        Point a2 = new Point(10, 10);
        Point b1 = new Point(0, 10);
        Point b2 = new Point(10, 0);

        Optional<Point> crossedPoint = StraightUtils.getCrossedPoint(
                new Straight(a1, a2),
                new Straight(b1, b2)
        );
        assertThat(crossedPoint.isPresent(), is(true));
        assertThat(crossedPoint.get().getX(), is(5));
        assertThat(crossedPoint.get().getY(), is(5));
    }

}