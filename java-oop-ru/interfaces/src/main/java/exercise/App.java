package exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> apartments, int countOfElements) {
        ArrayList<Home> temp = new ArrayList<>(apartments);
        temp.sort(Comparator.comparing(Home::getArea));
        ArrayList<String> result = new ArrayList<>();
        if (countOfElements > apartments.size()) {
            countOfElements = apartments.size();
        }
        for (int i = 0; i < countOfElements; i++) {
            result.add(temp.get(i).toString());
        }

        return result;
    }
}
// END
