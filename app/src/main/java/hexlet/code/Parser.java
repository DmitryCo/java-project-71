package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;

public class Parser {
    private static final Logger LOGGER = Logger.getLogger(Parser.class.getName());
    private static final ObjectMapper JSON_OBJECT_MAPPER = new ObjectMapper();
    private static final ObjectMapper YAML_OBJECT_MAPPER = new ObjectMapper(new YAMLFactory());

    public static Map<String, Object> parsing(Path absFilePath, String relFilePath) throws Exception {
        validateFileExists(absFilePath, relFilePath);
        String fileFormat = getFileFormat(relFilePath);
        Map<String, Object> contentFile;

        try {
            if ("yaml".equalsIgnoreCase(fileFormat) || "yml".equalsIgnoreCase(fileFormat)) {
                contentFile = readYamlFile(absFilePath.toFile());
            } else if ("json".equalsIgnoreCase(fileFormat)) {
                contentFile = readJsonFile(absFilePath.toFile());
            } else {
                throw new IllegalArgumentException("Unsupported file format: " + fileFormat);
            }
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

    private static String getFileFormat(String relFilePath) {
        return relFilePath.substring(relFilePath.indexOf(".") + 1);
    }

    private static Map<String, Object> readJsonFile(File file) throws IOException {
        return JSON_OBJECT_MAPPER.readValue(file, new TypeReference<Map<String, Object>>() {
        });
    }

    private static Map<String, Object> readYamlFile(File file) throws IOException {
        return YAML_OBJECT_MAPPER.readValue(file, new TypeReference<Map<String, Object>>() {
        });
    }
}
