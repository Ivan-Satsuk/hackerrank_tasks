package contacts_application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<String>> map = new HashMap();
        int a = Integer.parseInt(bufferedReader.readLine());
        IntStream.range(0, a).forEach(i -> {
                    try {
                        String[] curLine = bufferedReader.readLine().split(" ");
                        String op = curLine[0];
                        String word = curLine[1];

                        if (!map.containsKey(op)) {
                            map.put(op, new LinkedList<>());
                        }
                        map.get(op).add(word);


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );
<<<<<<< HEAD

=======
  
>>>>>>> e2f7910f3a61422e4d1d45ff6be70524696fc3b2
        List<String> names = new LinkedList<>();
        for (Map.Entry<String, List<String>> e : map.entrySet()) {

            if (e.getKey().equals("add")) {
                names.addAll(map.get(e.getKey()));
            } else {

                for (String searchingSubString : e.getValue()) {
                    int res = 0;

                    for (String name : names) {
                        if (name.startsWith(searchingSubString)) {
                            res++;
                        }
                    }
                    System.out.println(res);

                }

            }
        }
    }
}
