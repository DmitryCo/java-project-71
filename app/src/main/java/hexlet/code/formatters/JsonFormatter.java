package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;
import java.io.IOException;

public class JsonFormatter {
    public static String jsonFormat(List<Map<String, Object>> diffTree) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(diffTree).trim();
    }
}
