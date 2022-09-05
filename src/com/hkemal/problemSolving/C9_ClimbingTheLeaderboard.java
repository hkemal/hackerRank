package com.hkemal.problemSolving;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class C9_ClimbingTheLeaderboard {
    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
        int rankedCount = Integer.parseInt(in.nextLine().trim());
        String[] arr = in.nextLine().replaceAll("\\s+$", "").split(" ");
        int[] vals = new int[rankedCount];
        for (int i = 0; i < arr.length; i++) {
            if (i != 0 && i != arr.length - 1) {
                if (vals[i - 1] ==vals[i]) continue;
                    vals[i] = Integer.parseInt(arr[i]);
            } else if (i == 0) {
                vals[i] = Integer.parseInt(arr[i]);
            } else if (i == arr.length - 1) {
                vals[i] = Integer.parseInt(arr[i]);
            }

        }
        IntStream distinct = Arrays.stream(vals).distinct();

        //List<Integer> ranked = Stream.of(in.nextLine().replaceAll("\\s+$", "").split(" "))
        //     .map(Integer::parseInt).collect(Collectors.toList());
        int playerCount = Integer.parseInt(in.nextLine().trim());
        //List<Integer> player = Stream.of(in.nextLine().replaceAll("\\s+$", "").split(" "))
        //      .map(Integer::parseInt).collect(Collectors.toList());
        String[] arr1 = in.nextLine().replaceAll("\\s+$", "").split(" ");
        int[] vals1 = new int[playerCount];
        for (int i = 0; i < arr.length; i++) {
            vals[i] = Integer.parseInt(arr[i]);
        }
        //List<Integer> result = ResultClimbingTheLeaderboard.climbingLeaderboard3(ranked, player);
        //result.stream().forEach(item -> System.out.println(item));
    }
}

class ResultClimbingTheLeaderboard {
    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */
    public static List<Integer> climbingLeaderboard1(List<Integer> ranked, List<Integer> player) {
        // Write your code here
        List<Integer> ranksNewPlayers = new ArrayList<>();
        //Collections.sort(ranked, Collections.reverseOrder());
        IntStream.range(0, player.size()).forEach(item -> {
            ranked.add(player.get(item));
            Set<Integer> rankedSet = ranked.stream().collect(Collectors.toSet());
            List<Integer> subList = rankedSet.stream().collect(Collectors.toList());
            Collections.sort(subList, Collections.reverseOrder());
            ranksNewPlayers.add(subList.indexOf(player.get(item)) + 1);
        });
        return ranksNewPlayers;
    }

    public static List<Integer> climbingLeaderboard2(List<Integer> ranked, List<Integer> player) {
        // Write your code here
        List<Integer> ranksNewPlayers = new ArrayList<>();
        Set<Integer> rankedSet = ranked.stream().collect(Collectors.toSet());
        for (int i = 0; i < player.size(); i++) {
            rankedSet.add(player.get(i));
            List<Integer> subList = rankedSet.stream().collect(Collectors.toList());
            Collections.sort(subList, Collections.reverseOrder());
            ranksNewPlayers.add(subList.indexOf(player.get(i)) + 1);
        }
        return ranksNewPlayers;
    }

    public static List<Integer> climbingLeaderboard3(List<Integer> ranked, List<Integer> player) {
        // Write your code here
        List<Integer> ranksNewPlayers = new ArrayList<>();
        Set<Integer> rankedSet = ranked.stream().collect(Collectors.toSet());
        List<Integer> subList = rankedSet.stream().collect(Collectors.toList());
        subList.toArray();
        player.toArray();
        Collections.sort(subList, Collections.reverseOrder());
        for (int i = 0; i < player.size(); i++) {
            for (int j = subList.size(); j > 0; j--) {
                if (subList.get(0) < player.get(i)) {
                    ranksNewPlayers.add(1);
                    break;
                } else if (player.get(i) == subList.get(j - 1)) {
                    ranksNewPlayers.add(j);
                    break;
                } else if (player.get(i) > subList.get(j - 1) && player.get(i) < subList.get(j - 2)) {
                    ranksNewPlayers.add(j);
                    break;
                } else if (player.get(i) < subList.get(j - 1)) {
                    ranksNewPlayers.add(j + 1);
                    break;
                }
            }
        }
        return ranksNewPlayers;
    }

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here
        List<Integer> ranksNewPlayers = new ArrayList<>();
        Set<Integer> rankedSet = ranked.stream().collect(Collectors.toSet());
        List<Integer> subList = rankedSet.stream().collect(Collectors.toList());
        //Collections.sort(ranked, Collections.reverseOrder());
        IntStream.range(0, player.size()).forEach(item -> {
            ranksNewPlayers.add(subList.indexOf(player.get(item)) + 1);
            if (!subList.contains(player.get(item))) {
                subList.add(player.get(item));
                Collections.sort(subList, Collections.reverseOrder());
            }
            ranked.add(player.get(item));
        });
        return ranksNewPlayers;
    }

    public void test2() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] scores = new int[n];
        int[] ranks = new int[n]; //The dense ranking of the scores

        //Initialize dense ranking and scores
        for (int i = 0, rank = 1; i < n; i++) {
            int s = in.nextInt();
            scores[i] = s;
            if (i > 0 && scores[i - 1] != s)
                rank++;
            ranks[i] = rank;
        }

        //Interate over Alice's level scores
        //int level = 0;
        int aliceRank = ranks[ranks.length - 1] + 1; //Set it to worst rank+1
        int leaderboardIndex = n - 1;
        int m = in.nextInt();

        int prevScore = -1; //Last score we saw

        for (int aliceScores = 0; aliceScores < m; aliceScores++) {
            int levelScore = in.nextInt();

            //We iterate 1 past the front of the array incase we are greater than the best score
            for (int i = leaderboardIndex; i >= -1; i--) {
                if (i < 0 || scores[i] > levelScore) {
                    System.out.println(aliceRank);
                    break;
                } else if (scores[i] < levelScore) {
                    if (scores[i] != prevScore)//We have went up a ranking
                    {
                        aliceRank--;
                    }
                    leaderboardIndex--;
                } else//scores[i] == alice[level]
                {
                    leaderboardIndex--;
                    aliceRank = ranks[i];
                }
                prevScore = scores[i];
            }
        }
    }

    public static void printScores(int n, int[] scores, int[] alice) {
        ArrayList<Integer> places = new ArrayList<Integer>();
        int place = 1;
        places.add(scores[0]);
        for (int i = 1; i < scores.length; i++) {
            int currPlace = place - 1;
            int currScore = scores[i];
            if (currScore != places.get(currPlace)) {
                place++;
                places.add(currScore);
            }
        }

        int currPlace = places.size() + 1;
        for (int i = 0; i < alice.length; i++) {
            currPlace = getPlace(currPlace, alice[i], places);
            System.out.println(currPlace);
        }

    }

    public static int getPlace(int currPlace, int currScore, ArrayList<Integer> places) {
        for (int i = currPlace - 1; i > 0; i--) {
            int index = i - 1;
            if (currScore < places.get(index)) {
                return i + 1;
            }
        }
        return 1;
    }
}



