package leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class Num1466_MakeAllPathsLeadToTheCityZeroTest {

    Num1466_MakeAllPathsLeadToTheCityZero test = new Num1466_MakeAllPathsLeadToTheCityZero();
    @Test
    public void minReorder() {
        int[][] connections;

        connections = new int[][] {
                new int[]{0,1},
                new int[]{1,3},
                new int[]{2,3},
                new int[]{4,0},
                new int[]{4,5}};
        int i = test.minReorder(6, connections);
        System.out.println(i);
        assertThat(test.minReorder(6, connections)).isEqualTo(3);

        connections = new int[][] {
                new int[]{1,0},
                new int[]{1,2},
                new int[]{3,2},
                new int[]{3,4}};
        int i2 = test.minReorder(5, connections);
        System.out.println(i2);
        assertThat(test.minReorder(5, connections)).isEqualTo(2);


        connections = new int[][] {
                new int[]{0,2},
                new int[]{0,3},
                new int[]{4,1},
                new int[]{4,5},
                new int[]{5,0}
        };
        System.out.println(test.minReorder(6, connections));
        assertThat(test.minReorder(6, connections)).isEqualTo(3);

        connections = new int[][] {
                new int[]{4,3},
                new int[]{2,3},
                new int[]{1,2},
                new int[]{1,0}
        };
        System.out.println(test.minReorder(5, connections));
        assertThat(test.minReorder(5, connections)).isEqualTo(2);
    }
}