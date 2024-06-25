package basic;

import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPrac {
    //Count the number of names starting with alphabet A in list
    public static void main(String[] args) throws InterruptedException, IOException {
//        List<String> names = new ArrayList<String>();
//        names.add("Anjing");
//        names.add("Bangsat");
//        names.add("Cicing");
//        names.add("Suat");
//        names.add("Adam");
////        int count = 0;
////
////        for(int i = 0; i < names.size(); i++) {
////            String actual = names.get(i);
////            if (actual.startsWith("A")) {
////                count++;
////            }
////        }
////        System.out.println(count);
//
//        Long c = names.stream().filter(s -> s.startsWith("A")).count();
//        System.out.println(c);
//
//        Long d = Stream.of("Anjing", "Bangsat", "Cicing", "Suat", "Adam").filter(s ->
//        {
//            s.startsWith("A");
//            return true;
//        }).count();
//
//        System.out.println(d);
//
////        names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
//        names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
//

//        streamMap();
        streamCollect();


    }

    public void streamFilter() {
        List<String> names = new ArrayList<String>();
        names.add("Anjing");
        names.add("Bangsat");
        names.add("Cicing");
        names.add("Suat");
        names.add("Adam");

        Long c = names.stream().filter(s->s.startsWith("A")).count();
        System.out.println(c);
    }

    public static void streamMap() {

        List<String> names = new ArrayList<String>();
        names.add("Anjing");
        names.add("Bangsat");
        names.add("Cicing");
        names.add("Suat");
        names.add("Adam");
        
        Stream.of("Anjinga", "Bangsat", "Cicinga", "Suata", "Adam").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase(Locale.ROOT))
                .forEach(s -> System.out.println(s));
        //print names which have first letter as a with uppercase and sorted

        List<String>names1=Arrays.asList("Anjinga", "Bangsat", "ACicinga", "Suata", "Adam");
        names1.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase(Locale.ROOT)).forEach(s -> System.out.println(s));

        //merging 2 different lists

        Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
//        newStream.sorted().forEach(s -> System.out.println(s));

        boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("Anjinga"));
        Assert.assertTrue(flag);
    }

    public static void streamCollect() {
        List<String> ls = Stream.of("Anjinga", "Bangsat", "Cicinga", "Suata", "Adam").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase(Locale.ROOT))
                .collect(Collectors.toList());
        System.out.println(ls.get(0));

        List<Integer>values=Arrays.asList(3,2,2,7,5,1,9,7);
        //print unique number from this array
        //sort the array
        values.stream().distinct().forEach(s -> System.out.println(s));
        List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(li.get(2));


    }

}
