package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

public class DifferTest {
    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }

    private static String readFixture(String fileName) throws Exception {
        var path = getFixturePath(fileName);
        return Files.readString(path).trim();
    }

    private String file1 = "file1.json";
    private String file2 = "file2.json";
    private String file3 = "file1.yml";
    private String file4 = "file2.yml";

    @Test
    public void testStylishJson() throws Exception {
        String format = "stylish";
        String expected = readFixture("ExpectedStylishJsonJson.txt");
        var actual = Differ.generate(file1, file2, format);
        assertEquals(expected, actual);
    }
}
