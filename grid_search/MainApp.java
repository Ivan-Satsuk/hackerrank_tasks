package grid_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainApp {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(bufferedReader.readLine().trim());
        IntStream.range(0, a).forEach(intStr -> {
            try {
                String[] searchAreaSize = bufferedReader.readLine().split(" ");
                int R = Integer.parseInt(searchAreaSize[0]);

                List<String> searchArea = IntStream.range(0, R).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException e) {
                        throw new RuntimeException();
                    }
                }).collect(Collectors.toList());

                System.out.println("\n" + searchArea);

                String[] searchValueSize = bufferedReader.readLine().split(" ");
                int r = Integer.parseInt(searchValueSize[0]);
                List<String> searchValue = IntStream.range(0, r).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException e) {
                        throw new RuntimeException();
                    }
                }).collect(Collectors.toList());

                System.out.println("\n" + searchValue);
                gridSearch(searchArea, searchValue);

            } catch (IOException e) {
                throw new RuntimeException();
            }

        });


        bufferedReader.close();


    }

    public static void gridSearch(List<String> searchArea, List<String> searchValue) {
        int sizeSearchArea = searchArea.size();
        int sizeSearchValue = searchValue.size();
        int length = searchArea.get(0).length() - searchValue.get(0).length();

        OUTER:
        for (int i = 0; i < sizeSearchArea - sizeSearchValue + 1; i++) {
            int L = searchValue.get(0).length();
            int score = sizeSearchValue;
            int s = 0;
            MIDDLE:
            for (int j = 0; j <= length; j++) {
                for (int k = 0; k < sizeSearchValue; k++) {
//
                    if (i == length) {
                        if (searchValue.get(k).equals(searchArea.get(i + k).substring(j))) {
                            s++;
                            if (s == score) {
                                System.out.println("Yes");
                            }
                        } else {
                            s = 0;
                            L++;
                            continue MIDDLE;
                        }
                    }
                    if (searchValue.get(k).equals(searchArea.get(i + k).substring(j, L))) {
                        s += 1;
                        if (s == score) {
                            System.out.println("Yes");
                            return;
                        }
                    } else {
                        s = 0;
                        L++;
                        continue MIDDLE;
                    }
                }
                L++;
            }
        }
        System.out.println("NO");

    }
}
