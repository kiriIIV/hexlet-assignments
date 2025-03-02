package exercise;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
// BEGIN

// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.TRUNCATE_EXISTING);
    }

    // BEGIN
    @Test
    public void test1() {
        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "value"));
        String actual = storage.get("key", "default");
        String expected = "value";
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "value"));
        String actual = storage.get("123", "default");
        String expected = "default";
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        FileKV storage = new FileKV("src/test/resources/file", Map.of("key", "value"));
        storage.saveData();
        assertEquals(Map.of("key", "value"), storage.downloadData());
    }

    @Test
    public void test4() {
        FileKV storage = new FileKV("src/test/resources/file", Map.of("key", "value"));
        storage.saveData();
        assertEquals("{\"key\":\"value\"}", Utils.readFile("" + filepath));
    }
    // END
}
