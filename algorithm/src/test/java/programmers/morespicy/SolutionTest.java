package programmers.morespicy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void case1() {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;
        int answer = new Solution().solution(scoville, k);

        assertThat(answer).isEqualTo(2);
    }

}
