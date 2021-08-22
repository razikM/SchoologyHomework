package homework10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        System.out.println(namesWithOddIndex(Arrays.asList("a","b","c","d","e","f","g")));
//        System.out.println(sortUpperCase(Arrays.asList("a","b","c","d","e","f","g")));
//        System.out.println(sortedArrayToString(new String[]{"1,2,0", "4,5"}));
//       randomStream(25214903917L,11L, (long)Math.pow(2,48), 1).forEach(System.out :: println);
//        System.out.println(zip(Arrays.asList(1,2,3,8,9,10,11).stream(),Arrays.asList(4,5,6,7).stream()).collect(Collectors.toList()));
    }

    public static String namesWithOddIndex(List<String> names){
        String result = names.stream()
                .filter(e -> names.indexOf(e) % 2 == 1)
                .reduce("",(acc,e) -> acc + names.indexOf(e) + ". " + e + ", ");
        return result.substring(0, result.length() - 2);
    }

    public static List<String> sortUpperCase(List<String> names){
        return names.stream()
                .map(String :: toUpperCase)
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
    }

    public static String sortedArrayToString(String[] array){
       return Arrays.stream(array)
               .map(e -> Arrays.asList(e.split(",")))
               .reduce(new ArrayList<String>(),(acc,e) -> {acc.addAll(e); return acc;})
               .stream()
               .sorted()
               .collect(Collectors.toList())
               .toString();
    }

    public static Stream<Long> randomStream(long a, long c, long m, long seed){
        return Stream.iterate(seed, e -> (a * e + c) % m);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){
        ArrayList<T> f = (ArrayList<T>) first.collect(Collectors.toList());
        ArrayList<T> s = (ArrayList<T>) second.collect(Collectors.toList());

        if(f.size() < s.size()){
            return f.stream()
                    .map(e -> {
                        ArrayList<T> result = new ArrayList<>();
                        result.add(e);
                        return result;
                    })
                    .reduce(new ArrayList<T>(), (acc, e) -> {
                        acc.addAll(e);
                        acc.add(s.get(f.indexOf(e.get(0))));
                        return acc;
            }).stream();
        } else {
            return s.stream()
                    .map(e -> {
                        ArrayList<T> result = new ArrayList<>();
                        result.add(e);
                        return result;
                    })
                    .reduce(new ArrayList<T>(), (acc, e) -> {
                        acc.addAll(e);
                        acc.add(f.get(s.indexOf(e.get(0))));
                        return acc;
                    }).stream();
        }
    }
}
