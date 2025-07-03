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

    @Test
    public void alive_more_3_neighbours_expect_dead() {
        grid.getCell(2, 1).live();
        grid.getCell(3, 1).live();
        grid.getCell(1, 2).live();
        grid.getCell(2, 2).live();
        grid.getCell(3, 2).live();

        grid.run();

        assertThat(grid.getCell(2, 1).isAlive()).isEqualTo(false);
    }

    @Test
    public void alive_2_neighbours_expect_alive() {
        grid.getCell(2, 1).live();
        grid.getCell(3, 1).live();
        grid.getCell(1, 2).live();

        grid.run();
        assertThat(grid.getCell(2, 1).isAlive()).isEqualTo(true);
    }
}
