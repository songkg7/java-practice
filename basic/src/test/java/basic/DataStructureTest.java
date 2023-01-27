package basic;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;

public class DataStructureTest {

    // guava 를 통한 bloom filter 의 사용
    @Test
    void bloomFilter() {
        BloomFilter<CharSequence> blackListedIps =
                BloomFilter.create(Funnels.stringFunnel(StandardCharsets.UTF_8), 10000, 0.005);

        blackListedIps.put("192.170.0.1");
        blackListedIps.put("75.245.10.1");
        blackListedIps.put("10.125.22.20");

        assertThat(blackListedIps.mightContain("75.245.10.1")).isTrue();
    }

}
