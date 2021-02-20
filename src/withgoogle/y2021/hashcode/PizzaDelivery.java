package withgoogle.y2021.hashcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class PizzaDelivery {
    public static void main(String[] args) {
        String[] problems = new String[] {
                "a_example",
                "b_little_bit_of_everything",
                "c_many_ingredients",
                "d_many_pizzas",
                "e_many_teams",
        };
        String filename = "src/withgoogle/y2021/hashcode/" + problems[0];
        InputResponse parsedRes = parseInput(filename);
        prepareData(parsedRes);
        List<List<Integer>> solution = mainLogic(parsedRes);
        String output = formatOutput(solution);
        System.out.println(output);
        writeToSolutionFiles(output, filename + "_solution");
    }

    private static InputResponse parseInput(String filename) {
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            String line1 = myReader.nextLine();
            String[] arr = line1.split(" ");
            int pizzaCount = Integer.parseInt(arr[0]);
            int t2Count = Integer.parseInt(arr[1]);
            int t3Count = Integer.parseInt(arr[2]);
            int t4Count = Integer.parseInt(arr[3]);
            List<List<String>> pizzas = new ArrayList<>(pizzaCount);
            for (int i = 0; i < pizzaCount; i++) {
                String[] pizzaInfo = myReader.nextLine().split(" ");
                int ingreCount = Integer.parseInt(pizzaInfo[0]);
                List<String> ingredients = new ArrayList<>(ingreCount);
                for (int j = 0; j < ingreCount; j++) ingredients.add(pizzaInfo[j + 1]);
                pizzas.add(ingredients);
            }
            myReader.close();
            return new InputResponse(pizzaCount, t2Count, t3Count, t4Count, pizzas);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }

    static class InputResponse {
        int pizzaCount;
        int t2Count;
        int t3Count;
        int t4Count;

        List<List<String>> pizzas;

        public InputResponse (int pizzaCount, int t2Count, int t3Count, int t4Count, List<List<String>> pizzas) {
            this.pizzaCount = pizzaCount;
            this.t2Count = t2Count;
            this.t3Count = t3Count;
            this.t4Count = t4Count;
            this.pizzas = pizzas;
        }
    }

    static void prepareData(InputResponse inputRes) {
        Collections.sort(inputRes.pizzas, Comparator.comparingInt((List value) -> value.size()).reversed());
    }

    static List<List<Integer>> mainLogic(InputResponse inputRes) {
        List<List<Integer>> res = new ArrayList<>();

        int currPizzaCount = inputRes.pizzaCount;
        int m4TeamsToDeliver = inputRes.t4Count;

        // in case not enough pizzas for all 4-member teams
        if (currPizzaCount / 4 < inputRes.t4Count) {
            m4TeamsToDeliver = currPizzaCount / 4;
        }

        if (m4TeamsToDeliver > 0) {
            List<List<Integer>> m4Deliveries = distributePizzasToTeams(inputRes.pizzas, 0, m4TeamsToDeliver * 4, m4TeamsToDeliver);
            res.addAll(m4Deliveries);
        }

        // -------------------------------------------------------

        currPizzaCount = currPizzaCount - (m4TeamsToDeliver * 4);
        int m3TeamsToDeliver = inputRes.t3Count;

        if (currPizzaCount / 3 < inputRes.t3Count) {
            m3TeamsToDeliver = currPizzaCount / 3;
        }

        if (m3TeamsToDeliver > 0) {
            List<List<Integer>> m3Deliveries = distributePizzasToTeams(
                    inputRes.pizzas,
                    m4TeamsToDeliver * 4,
                    m4TeamsToDeliver * 4 + m3TeamsToDeliver * 3,
                    m3TeamsToDeliver);
            res.addAll(m3Deliveries);
        }
        // -------------------------------------------------------

        currPizzaCount = currPizzaCount - m3TeamsToDeliver * 3;

        int m2TeamsToDeliver = inputRes.t2Count;

        if (currPizzaCount / 2 < inputRes.t2Count) {
            m2TeamsToDeliver = currPizzaCount / 2;
        }

        if (m2TeamsToDeliver > 0) {
            List<List<Integer>> m2Deliveries = distributePizzasToTeams(
                    inputRes.pizzas,
                    m4TeamsToDeliver * 4 + m3TeamsToDeliver * 3,
                    m4TeamsToDeliver * 4 + m3TeamsToDeliver * 3 + m2TeamsToDeliver * 2,
                    m2TeamsToDeliver);
            res.addAll(m2Deliveries);
        }

        return  res;
    }

    static List<List<Integer>> distributePizzasToTeams(List<List<String>> pizzas, int start, int end, int tCount) {
        int size = end - start;
        int pizzasPerTeam = size / tCount;
        List<List<Integer>> teams = new ArrayList<>(tCount);
        List<Set<String>> uniqueIngredients = new ArrayList<>(tCount);


        for (int i = 0; i < tCount; i++) {
            teams.add(new ArrayList<>(4));
            uniqueIngredients.add(new HashSet<>());
        }

        for (int i = start; i < end; i++) {
            List<String> pizza = pizzas.get(i);
            int minDups = Integer.MAX_VALUE;
            int min = -1;
            for (int j = 0; j < tCount; j++) {
                Set<String> uniqueIng = uniqueIngredients.get(j);
                List<Integer> team = teams.get(j);

                if (team.size() == pizzasPerTeam) continue;

                int duplicateCount = calculateDuplicateCount(uniqueIng, pizza);

                if (duplicateCount < minDups) {
                    minDups = duplicateCount;
                    min = j;
                }

                if (minDups == 0) break;
            }

            Set<String> bucket = uniqueIngredients.get(min);
            bucket.addAll(pizza);
            teams.get(min).add(i);
        }

        return teams;
    }

    static int calculateDuplicateCount(Set<String> ingredients, List<String> newIngredients) {
        int count = 0;
        for (String ingredient : newIngredients) {
            if (ingredients.contains(ingredient)) {
                count++;
            }
        }
        return count;
    }

    static String formatOutput(List<List<Integer>> solution) {
        StringBuilder builder = new StringBuilder();
        builder.append(solution.size()).append("\n");

        for (List<Integer> item : solution) {
            builder.append(item.size());
            for (Integer i : item) {
                builder.append(" ").append(i);
            }
            builder.append("\n");
        }

        return builder.toString();
    }

    static void writeToSolutionFiles(String content, String filename) {
        try {
            FileWriter myWriter = new FileWriter(filename);
            myWriter.write(content);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
