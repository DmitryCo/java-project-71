package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Parser {
    private static final Logger LOGGER = Logger.getLogger(Parser.class.getName());
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static Map<String, Object> parsing(Path absFilePath, String relFilePath) throws Exception {
        validateFileExists(absFilePath, relFilePath);
        Map<String, Object> contentFile;

        try {
            contentFile = readFile(absFilePath.toFile());
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "File not created", e);
            throw e;
        }
        return contentFile;
    }

    private static void validateFileExists(Path absFilePath, String relFilePath) throws Exception {
        if (!Files.exists(absFilePath)) {
            throw new Exception("File '" + relFilePath + "' does not exist");
        }
    }

    private static Map<String, Object> readFile(File file) throws Exception {
        return OBJECT_MAPPER.readValue(file, new TypeReference<Map<String, Object>>() {
        });
    }
}
