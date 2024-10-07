package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.Map;
import java.io.IOException;

public class Parser {
    public static Map<String, Object> parse(String data, String formatType) throws IOException {
        ObjectMapper objectMapper;
        switch (formatType) {
            case "json":
                objectMapper = new ObjectMapper();
                break;
            case "yml", "yaml":
                objectMapper = new ObjectMapper(new YAMLFactory());
                break;
            default:
                throw new IllegalArgumentException("Unsupported format type: " + formatType);
        }
        try {
            return objectMapper.readValue(data, new TypeReference<Map<String, Object>>() {
            });
        } catch (IOException e) {
            throw new IOException("Failed to parse " + formatType + " data: " + e.getMessage(), e);
        }
    }
}
