package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;

public class DifferTest {
    private static String expectedJSON;
    private static String expectedStylish;
    private static String expectedPlain;
    private static String file1JSON;
    private static String file2JSON;
    private static String file1YAML;
    private static String file2YAML;

    @BeforeAll
    public static void beforeAll() throws Exception {
        expectedJSON = Utils.readFixture("expectedJSON.json");
        expectedStylish = Utils.readFixture("expectedStylish.txt");
        expectedPlain = Utils.readFixture("expectedPlain.txt");
        file1JSON = Utils.getPath("file1.json");
        file2JSON = Utils.getPath("file2.json");
        file1YAML = Utils.getPath("file1.yml");
        file2YAML = Utils.getPath("file2.yml");
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
        assertEquals(expectedJSON, Differ.generate(file1JSON, file2JSON, "json"));
    }

    @Test
    public void testJsonYAML() throws Exception {
        assertEquals(expectedJSON, Differ.generate(file1YAML, file2YAML, "json"));
    }

    @Test
    public void testDefaultFormat() throws Exception {
        assertEquals(expectedStylish, Differ.generate(file1JSON, file2JSON));
        assertEquals(expectedStylish, Differ.generate(file1YAML, file2YAML));
    }
}
