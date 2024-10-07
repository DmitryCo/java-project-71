package hexlet.code;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Objects;

public class DiffTreeBuilder {
    public static List<Map<String, Object>> generateDiffTree(Map<String, Object> contentFile1,
                                                             Map<String, Object> contentFile2) {
        List<Map<String, Object>> diffTree = new ArrayList<>();
        Set<String> allKeys = new TreeSet<>(contentFile1.keySet());
        allKeys.addAll(contentFile2.keySet());

        for (var key : allKeys) {
            Map<String, Object> diff = createDiffEntry(key, contentFile1, contentFile2);
            diffTree.add(diff);
        }
        return diffTree;
    }

    public static Map<String, Object> createDiffEntry(String key, Map<String, Object> contentFile1,
                                                      Map<String, Object> contentFile2) {
        Map<String, Object> diffEntry = new LinkedHashMap<>();
        diffEntry.put("key", key);

        if (contentFile1.containsKey(key) && !contentFile2.containsKey(key)) {
            diffEntry.put("oldValue", contentFile1.get(key));
            diffEntry.put("changeType", ChangeType.REMOVED);
        } else if (!contentFile1.containsKey(key) && contentFile2.containsKey(key)) {
            diffEntry.put("newValue", contentFile2.get(key));
            diffEntry.put("changeType", ChangeType.ADDED);
        } else if (Objects.equals(contentFile1.get(key), contentFile2.get(key))) {
            diffEntry.put("oldValue", contentFile1.get(key));
            diffEntry.put("changeType", ChangeType.UNCHANGED);
        } else if (!Objects.equals(contentFile1.get(key), contentFile2.get(key))) {
            diffEntry.put("oldValue", contentFile1.get(key));
            diffEntry.put("newValue", contentFile2.get(key));
            diffEntry.put("changeType", ChangeType.CHANGED);
        } else {
            throw new RuntimeException("Unknown key type: " + key);
        }
        return diffEntry;
    }

    public enum ChangeType {
        ADDED, REMOVED, CHANGED, UNCHANGED
    }
}
