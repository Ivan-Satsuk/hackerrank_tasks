package score_stat;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class mainApp {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        System.out.println();

        List<Integer> result = climbingLeaderboard(ranked, player);

        result.stream().forEach(System.out::println);

        bufferedReader.close();

    }

    public static List<Integer> climbingLeaderboard (List<Integer> ranked, List<Integer> player){

        TreeSet<Integer> ranks = new TreeSet<> (Comparator.reverseOrder());
        ranks.addAll(ranked);
        List<Integer> result = new LinkedList<>();


        for (Integer score: player) {
            ranks.add(score);
            result.add(ranks.headSet(score).size()+1);
        }


        return result;
    }

}
