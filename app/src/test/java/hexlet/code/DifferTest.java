package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;


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
        expectedJSON = readFixture("expectedJSON.json");
        expectedStylish = readFixture("expectedStylish.txt");
        expectedPlain = readFixture("expectedPlain.txt");
        file1JSON = getPath("file1.json");
        file2JSON = getPath("file2.json");
        file1YAML = getPath("file1.yml");
        file2YAML = getPath("file2.yml");
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
    public void testDefaultFormat() throws Exception {
        assertEquals(expectedStylish, Differ.generate(file1JSON, file2JSON));
        assertEquals(expectedStylish, Differ.generate(file1YAML, file2YAML));
    }

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }

    private static String readFixture(String fileName) throws Exception {
        var path = getFixturePath(fileName);
        return Files.readString(path).trim();
    }

    public static String getPath(String fileName) {
        return String.format("src/test/resources/fixtures/%s", fileName);
    }
}
