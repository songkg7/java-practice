package basic.finalorder;

import org.springframework.stereotype.Repository;

@Repository
public class TestRepository extends MemoryRepository {

    @Override
    public String to(String s) {
        return s;
    }
}
