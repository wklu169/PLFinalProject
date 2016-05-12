import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class ListComprehension {

    // SELECT * FROM bib;
    public static ArrayList<String> selectAll() throws IOException {
        ArrayList<Bible> bib = new ArrayList<>();

        String path = System.getProperty("user.dir");
        File file = new File(path + "/bible.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        while ((line = br.readLine()) != null) {
            String substr = line.substring(1, line.length() - 1);
            List<String> bibList = Arrays.asList(substr.split(","));
            for (int i = 0; i < bibList.size(); i++) {
                bibList.set(i, bibList.get(i).trim());
            }
            Bible b = new Bible(bibList.get(0), bibList.get(1), bibList.get(2), bibList.get(3), bibList.get(4));
            bib.add(b);
        }

        ArrayList<String> result = new ArrayList<>();

        bib.stream()
                .forEach(b -> {
                    String row = b.getId() + " | " + b.getName() + " | " + b.getAuthor() + " | " + b.getChapters() + " | " + b.getVerses();
                    result.add(row);
                });

        return result;
    }

    // SELECT name, author, chapters, verses FROM bib ORDER BY name;
    public static ArrayList<String> Alphabetical() throws IOException {
        ArrayList<Bible> bib = new ArrayList<>();

        String path = System.getProperty("user.dir");
        File file = new File(path + "/bible.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        while ((line = br.readLine()) != null) {
            String substr = line.substring(1, line.length() - 1);
            List<String> bibList = Arrays.asList(substr.split(","));
            for (int i = 0; i < bibList.size(); i++) {
                bibList.set(i, bibList.get(i).trim());
            }
            Bible b = new Bible(bibList.get(0), bibList.get(1), bibList.get(2), bibList.get(3), bibList.get(4));
            bib.add(b);
        }

        ArrayList<String> result = new ArrayList<>();

        bib.stream()
                .sorted((b1, b2) -> b1.getName().compareTo(b2.getName()))
                .forEach(b -> {
                    String row = b.getName() + " | " + b.getAuthor() + " | " + b.getChapters() + " | " + b.getVerses();
                    result.add(row);
                });

        return result;
    }

    // SELECT name, chapters FROM bib WHERE chapters </> num;
    public static ArrayList<String> greaterThanChapters(int num, boolean tf) throws IOException {
        ArrayList<Bible> bib = new ArrayList<>();

        String path = System.getProperty("user.dir");
        File file = new File(path + "/bible.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        while ((line = br.readLine()) != null) {
            String substr = line.substring(1, line.length() - 1);
            List<String> bibList = Arrays.asList(substr.split(","));
            for (int i = 0; i < bibList.size(); i++) {
                bibList.set(i, bibList.get(i).trim());
            }
            Bible b = new Bible(bibList.get(0), bibList.get(1), bibList.get(2), bibList.get(3), bibList.get(4));
            bib.add(b);
        }

        ArrayList<String> result = new ArrayList<>();

        if (tf) {
            bib.stream()
                    .filter(b -> (Integer.parseInt(b.getChapters()) > num))
                    .forEach(b -> {
                        String row = b.getName() + " | " + b.getChapters();
                        result.add(row);
                    });
        } else {
            bib.stream()
                    .filter(b -> (Integer.parseInt(b.getChapters()) < num))
                    .forEach(b -> {
                        String row = b.getName() + " | " + b.getChapters();
                        result.add(row);
                    });
        }

        return result;
    }

    // SELECT author, count(chapter) FROM bib GROUP BY author
    public static ArrayList<String> countAuthorChapters() throws IOException {
        ArrayList<Bible> bib = new ArrayList<>();

        String path = System.getProperty("user.dir");
        File file = new File(path + "/bible.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        while ((line = br.readLine()) != null) {
            String substr = line.substring(1, line.length() - 1);
            List<String> bibList = Arrays.asList(substr.split(","));
            for (int i = 0; i < bibList.size(); i++) {
                bibList.set(i, bibList.get(i).trim());
            }
            Bible b = new Bible(bibList.get(0), bibList.get(1), bibList.get(2), bibList.get(3), bibList.get(4));
            bib.add(b);
        }

        ArrayList<String> result = new ArrayList<>();

        bib.stream()
                .collect(Collectors.groupingBy(Bible::getAuthor))
                .entrySet()
                .stream()
                .map(a -> a.getValue())
                .forEach (bibList -> {
                    int total = bibList
                            .stream()
                            .mapToInt(b -> Integer.parseInt(b.getChapters()))
                            .sum();
                    String author = bibList.get(0).getAuthor();
                    String row = author + " | " + total;
                    result.add(row);
                });

        return result;
    }
}