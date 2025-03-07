package exercise;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        for (var keyAndValue : storage.toMap().entrySet()) {
            String tempKey = keyAndValue.getKey();
            String tempValue = keyAndValue.getValue();
            storage.unset(keyAndValue.getKey());
            storage.set(tempValue, tempKey);
        }
    }
}
// END
