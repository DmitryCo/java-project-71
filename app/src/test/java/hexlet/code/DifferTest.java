package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class DifferTest {
    private static String expectedJSON;
    private static String expectedStylish;
    private static String expectedPlain;
    private static String file1JSON;
    private static String file2JSON;
    private static String file1YAML;
    private static String file2YAML;

    @BeforeAll
    public static void beforeAll() throws Exception {
        expectedJSON = TestUtils.readFixture("expectedJSON.json");
        expectedStylish = TestUtils.readFixture("expectedStylish.txt");
        expectedPlain = TestUtils.readFixture("expectedPlain.txt");
        file1JSON = TestUtils.getPath("file1.json");
        file2JSON = TestUtils.getPath("file2.json");
        file1YAML = TestUtils.getPath("file1.yml");
        file2YAML = TestUtils.getPath("file2.yml");
    }

    @Test
    public void testTreeJSON() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode expected = objectMapper.readTree(expectedJSON);
        JsonNode actual = objectMapper.readTree(expectedJSON);
        assertEquals(expected, actual);
    }

    @Test
    public void testStylishJSON() throws Exception {
        assertEquals(expectedStylish, Differ.generate(file1JSON, file2JSON, "stylish"));
    }

    @Test
    public void testStylishYAML() throws Exception {
        assertEquals(expectedStylish, Differ.generate(file1YAML, file2YAML, "stylish"));
    }

    @Test
    public void testPlainJSON() throws Exception {
        assertEquals(expectedPlain, Differ.generate(file1JSON, file2JSON, "plain"));
    }

    @Test
    public void testPlainYAML() throws Exception {
        assertEquals(expectedPlain, Differ.generate(file1YAML, file2YAML, "plain"));
    }

    @Test
    public void testJsonJSON() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode expected = objectMapper.readTree(expectedJSON);
        JsonNode actual = objectMapper.readTree(Differ.generate(file1JSON, file2JSON, "json"));
        assertEquals(expected, actual);
    }

    @Test
    public void testJsonYAML() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode expected = objectMapper.readTree(expectedJSON);
        JsonNode actual = objectMapper.readTree(Differ.generate(file1YAML, file2YAML, "json"));
        assertEquals(expected, actual);
    }

    @Test
    public void testDefaultFormat() throws Exception {
        assertEquals(expectedStylish, Differ.generate(file1JSON, file2JSON));
        assertEquals(expectedStylish, Differ.generate(file1YAML, file2YAML));
    }
}
