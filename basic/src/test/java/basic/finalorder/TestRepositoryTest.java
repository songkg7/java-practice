package basic.finalorder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class TestRepositoryTest {

    @Test
    void save() {
        TestRepository testRepository = new TestRepository();
        testRepository.save("test");

        List<String> lists = testRepository.getLists();
        assertThat(lists).hasSize(1);
    }
}
