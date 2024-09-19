package hexlet.code;

import java.io.File;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class Differ {
    private static final Logger logger = Logger.getLogger(Differ.class.getName());
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void generate(String filepath1, String filepath2, String format) throws Exception {
        Path firstFile = Paths.get(filepath1).toAbsolutePath().normalize();
        Path secondFile = Paths.get(filepath2).toAbsolutePath().normalize();

        validateFileExists(firstFile, filepath1);
        validateFileExists(secondFile, filepath2);

        try {
            Map<String, Object> contentFirstFile = readFile(firstFile.toFile());
            Map<String, Object> contentSecondFile = readFile(secondFile.toFile());
        } catch (Exception e) {
            logger.log(Level.SEVERE, "File not created", e);
            throw e;
        }
    }

    private static void validateFileExists(Path absFilePath, String relFilePath) throws Exception {
        if (!Files.exists(absFilePath)) {
            throw new Exception("File '" + relFilePath + "' does not exist");
        }
    }

    private static Map<String, Object> readFile(File file) throws Exception {
        return objectMapper.readValue(file, new TypeReference<Map<String, Object>>() {
        });
    }
}
