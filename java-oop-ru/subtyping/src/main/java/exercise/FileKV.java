package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private HashMap<String, String> storage;
    private String path;

    FileKV(String path, Map<String, String> storage) {
        this.path = path;
        this.storage = new HashMap<>(storage);
    }

    @Override
    public void set(String key, String value) {
        this.storage.put(key, value);
    }

    @Override
    public void unset(String key) {
        this.storage.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return this.storage.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(storage);
    }

    public void saveData() {
        String json = Utils.serialize(storage);
        Utils.writeFile(path, json);
    }

    public Map<String, String> downloadData() {
        String content = Utils.readFile(path);
        Map<String, String> data = Utils.deserialize(content);
        return data;
    }
}
// END
