package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List<String> validate(Object object) {
        ArrayList<String> result = new ArrayList<>();
        Class<?> aClass = object.getClass();
        try {
            Field[] fields = aClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(NotNull.class) && field.get(object) == null) {
                    result.add(field.getName());
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static Map<String, List<String>> advancedValidate(Object object) {
        HashMap<String, List<String>> result = new HashMap<>();
        Class<?> aClass = object.getClass();
        try {
            Field[] fields = aClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                ArrayList<String> errors = new ArrayList<>();
                if (field.isAnnotationPresent(MinLength.class)) {
                    MinLength minLength = field.getAnnotation(MinLength.class);
                    if (field.get(object).toString().length() < minLength.minLength()) {
                        errors.add("length less than " + minLength.minLength());
                    }
                }
                if (field.isAnnotationPresent(NotNull.class) && field.get(object) == null) {
                    errors.add("can not be null");
                }
                if (!errors.isEmpty()) {
                    result.put(field.getName(), errors);
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
// END
