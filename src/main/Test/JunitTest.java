import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class JunitTest {

    @Test
    public void test01() {
        System.out.println("hello world!");
    }

    @Test
    public void test02() {
        Map<String, String> headers = new HashMap<>();
        headers.put("User-Agent", "Pixel 2L");
        System.out.println(headers.toString());
    }

    @Test
    public void test03() {
        String qd_sg = String.format("865166028633454-8.10.0-%d-", System.currentTimeMillis());
        System.out.println(qd_sg);
    }

}
