/*package hexlet.code;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class DifferTest {

    private static final Path PATH_TO_FILE_1 = Paths.get("./src/test/resources/fixtures/file1.json")
            .toAbsolutePath()
            .normalize();
    private static final Path PATH_TO_FILE_2 = Paths.get("./src/test/resources/fixtures/file2.json")
            .toAbsolutePath()
            .normalize();
    private static final Path PATH_TO_FILE_3 = Paths.get("./src/test/resources/fixtures/file1.yml")
            .toAbsolutePath()
            .normalize();
    private static final Path PATH_TO_FILE_4 = Paths.get("./src/test/resources/fixtures/file2.yml")
            .toAbsolutePath()
            .normalize();

    private static String resultStylish;

    @BeforeEach
    public void beforeEach() throws Exception {
        resultStylish = Differ.getData("./src/test/resources/fixtures/result_stylish.txt");
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    @DisplayName("Test stylish format")
    public void testStylishFormat(String format) throws Exception {
        Path filePath1 = Paths.get("./src/test/resources/fixtures/file1." + format).toAbsolutePath().normalize();
        Path filePath2 = Paths.get("./src/test/resources/fixtures/file2." + format).toAbsolutePath().normalize();
        assertThat(Differ.generate(filePath1.toString(), filePath2.toString(), "stylish")).isEqualTo(resultStylish);
    }
}*/
