package fr.esgi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {

    private Grid grid;

    @BeforeEach
    void setup() {
        grid = new Grid(8, 4);
    }

    @Test
    public void alive_less_2_neighbours_expect_dead() {
        grid.getCell(4, 2).live();
        grid.getCell(5, 2).live();

        grid.run();

        assertThat(grid.getCell(4, 2).isAlive()).isEqualTo(false);
    }


}
