package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class DifferTest {
    private String file1 = "src/test/resources/fixtures/IdenticalJson1.json";
    private String file2 = "src/test/resources/fixtures/IdenticalJson2.json";
    private String file3 = "src/test/resources/fixtures/AddedJson1.json";
    private String file4 = "src/test/resources/fixtures/RemoteJson1.json";
    private String file5 = "src/test/resources/fixtures/ModifiedJson1.json";
    private String file6 = "src/test/resources/fixtures/EmptyJson1.json";
    private String file7 = "src/test/resources/fixtures/EmptyJson2.json";
    private String file8 = "src/test/resources/fixtures/DifferentJson1.json";
    private String file9 = "src/test/resources/fixtures/IdenticalYaml1.yaml";
    private String file10 = "src/test/resources/fixtures/IdenticalYaml2.yml";
    private String file11 = "src/test/resources/fixtures/AddedYaml1.yaml";
    private String file12 = "src/test/resources/fixtures/RemoteYaml1.yaml";
    private String file13 = "src/test/resources/fixtures/ModifiedYaml1.yaml";
    private String file14 = "src/test/resources/fixtures/EmptyYaml1.yaml";
    private String file15 = "src/test/resources/fixtures/EmptyYaml2.yml";
    private String file16 = "src/test/resources/fixtures/DifferentYaml1.yaml";

    @Test
    public void testIdenticalJsonJson() throws Exception {
        String format = "stylish";
        String expected = "{\n    host: hexlet.io\n    timeout: 50\n}";
        var actual = Differ.generate(file1, file2, format);
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        assertEquals(expected, actual);
    }

    @Test
    public void testAddedJsonJson() throws Exception {
        String format = "stylish";
        String expected = "{\n  + country: France\n    host: hexlet.io\n    timeout: 50\n}";
        var actual = Differ.generate(file1, file3, format);
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoteJsonJson() throws Exception {
        String format = "stylish";
        String expected = "{\n    host: hexlet.io\n  - timeout: 50\n}";
        var actual = Differ.generate(file1, file4, format);
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        assertEquals(expected, actual);
    }

    @Test
    public void testModifiedJsonJson() throws Exception {
        String format = "stylish";
        String expected = "{\n    host: hexlet.io\n  - timeout: 50\n  + timeout: 100\n}";
        var actual = Differ.generate(file1, file5, format);
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        assertEquals(expected, actual);
    }

    @Test
    public void testEmptyJsonJson() throws Exception {
        String format = "stylish";
        String expected = "{\n\n}";
        var actual = Differ.generate(file6, file7, format);
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        assertEquals(expected, actual);
    }

    @Test
    public void testDifferentJsonJson() throws Exception {
        String format = "stylish";
        String expected = "{\n  + currency: $\n  + domain: .com\n  - host: hexlet.io\n  - timeout: 50\n}";
        var actual = Differ.generate(file1, file8, format);
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        assertEquals(expected, actual);
    }

    @Test
    public void testIdenticalYamlYml() throws Exception {
        String format = "stylish";
        String expected = "{\n    host: hexlet.io\n    timeout: 50\n}";
        var actual = Differ.generate(file9, file10, format);
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        assertEquals(expected, actual);
    }

    @Test
    public void testAddedYamlYaml() throws Exception {
        String format = "stylish";
        String expected = "{\n  + country: France\n    host: hexlet.io\n    timeout: 50\n}";
        var actual = Differ.generate(file9, file11, format);
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoteYamlYaml() throws Exception {
        String format = "stylish";
        String expected = "{\n    host: hexlet.io\n  - timeout: 50\n}";
        var actual = Differ.generate(file9, file12, format);
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        assertEquals(expected, actual);
    }

    @Test
    public void testModifiedYamlYaml() throws Exception {
        String format = "stylish";
        String expected = "{\n    host: hexlet.io\n  - timeout: 50\n  + timeout: 100\n}";
        var actual = Differ.generate(file9, file13, format);
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        assertEquals(expected, actual);
    }

    @Test
    public void testEmptyYamlYaml() throws Exception {
        String format = "stylish";
        String expected = "{\n\n}";
        var actual = Differ.generate(file14, file15, format);
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        assertEquals(expected, actual);
    }

    @Test
    public void testDifferentYamlYaml() throws Exception {
        String format = "stylish";
        String expected = "{\n  + currency: $\n  + domain: .com\n  - host: hexlet.io\n  - timeout: 50\n}";
        var actual = Differ.generate(file9, file16, format);
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        assertEquals(expected, actual);
    }
}
