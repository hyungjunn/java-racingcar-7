package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("n대의 차들이 모두 전진함에 따라 포지션이 1씩 증가한다는 로직을 테스트하라")
    @Test
    void test1() {
        Cars cars = Cars.withNames(List.of("A", "B", "C"));

        List<Integer> positions1 = cars.move(() -> true);
        List<Integer> positions2 = cars.move(() -> true);
        List<Integer> positions3 = cars.move(() -> true);

        assertThat(positions1).isEqualTo(List.of(1, 1, 1));
        assertThat(positions2).isEqualTo(List.of(2, 2, 2));
        assertThat(positions3).isEqualTo(List.of(3, 3, 3));
    }

    @DisplayName("n대의 차들이 모두 정지함에 따라 포지션이 그대로인 로직을 테스트하라")
    @Test
    void test2() {
        Cars cars = Cars.withNames(List.of("A", "B", "C"));

        List<Integer> positions1 = cars.move(() -> true);
        List<Integer> positions2 = cars.move(() -> true);
        List<Integer> positions3 = cars.move(() -> true);

        assertThat(positions1).isEqualTo(List.of(1, 1, 1));
        assertThat(positions2).isEqualTo(List.of(2, 2, 2));
        assertThat(positions3).isEqualTo(List.of(3, 3, 3));
    }

    @DisplayName("n대의 차들이 2번 정지, 1번 전진에 따라 포지션이 바뀌는 로직을 테스트하라")
    @Test
    void test3() {
        Cars cars = Cars.withNames(List.of("A", "B", "C"));

        List<Integer> positions1 = cars.move(() -> false);
        List<Integer> positions2 = cars.move(() -> false);

        List<Integer> positions3 = cars.move(() -> true);

        assertThat(positions1).isEqualTo(List.of(0, 0, 0));
        assertThat(positions2).isEqualTo(List.of(0, 0, 0));
        assertThat(positions3).isEqualTo(List.of(1, 1, 1));
    }

    @DisplayName("n대의 차들이 1번 정지, 2번 전진에 따라 포지션이 바뀌는 로직을 테스트하라")
    @Test
    void test4() {
        Cars cars = Cars.withNames(List.of("A", "B", "C"));

        List<Integer> positions1 = cars.move(() -> false);

        List<Integer> positions2 = cars.move(() -> true);
        List<Integer> positions3 = cars.move(() -> true);

        assertThat(positions1).isEqualTo(List.of(0, 0, 0));
        assertThat(positions2).isEqualTo(List.of(1, 1, 1));
        assertThat(positions3).isEqualTo(List.of(2, 2, 2));
    }
}
