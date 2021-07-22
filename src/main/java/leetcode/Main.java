package leetcode;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

/**
 * Created by stan on 02/05/2021.
 */
public class Main {
    private static final String TEXT = "Mary had a little lamb its fleece was white as snow;" +
            "\nAnd everywhere that Mary went, the lamb was sure to go." +
            "\nIt followed her to school one day, which was against the rule;" +
            "\nIt made the children laugh and play, to see a lamb at school." +
            "\nAnd so the teacher turned it out, but still it lingered near," +
            "\nAnd waited patiently about till Mary did appear." +
            "\n\"Why does the lamb love Mary so?\" the eager children cry;\"Why, Mary loves the lamb, you know\" the teacher did reply.";

    public static void main(String[] args) throws IOException {
//        Class c = java.util.ArrayList.class;
//        String className = Main.class.getName();
//        System.out.println("The fully-qualified name of the class is: " + c.getName());
//
        Class c=Main.class;
        System.out.println(c.getClassLoader());
        //If we print the classloader name of String, it will print null because it is an
        //in-built class which is found in rt.jar, so it is loaded by Bootstrap classloader
        System.out.println(String.class.getClassLoader());
//        List<String> strippedWords = toStrippedWords(TEXT);
//        getAndProcessInput((word, nGram) -> nGramProcessor(strippedWords, word, nGram));
    }

    private static void nGramProcessor(List<String> strippedWords, String word, int nGram) {
        Map<String, Map<String, Integer>> ngramsFrequency = nGrams(strippedWords, nGram);
        System.out.println(probabilities(ngramsFrequency, word));
    }

    private static void getAndProcessInput(BiConsumer<String, Integer> consumer) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;

        while ((line = in.readLine()) != null) {
            String[] input = line.split(",");
            int nGram = Integer.parseInt(input[0]);
            String word = input[1];
            consumer.accept(word, nGram);
        }
    }

    private static Map<String, Map<String, Integer>> nGrams(List<String> strippedWords, int nGram) {
        Map<String, Map<String, Integer>> ngrams = new HashMap<>();


        for (int i = 0; i <= strippedWords.size() - nGram; i++) {
            String word = strippedWords.get(i);
            StringBuilder predict = new StringBuilder();

            for (int j = 1; j < nGram; j++) {
                predict.append(" ").append(strippedWords.get(i + j));
            }

            Map<String, Integer> frequency = ngrams.computeIfAbsent(word, __ -> new HashMap<>());
            frequency.merge(predict.toString().trim(), 1, Integer::sum);
        }

        return ngrams;
    }
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        Map<Integer, Integer> count = new HashMap<>();


        for(int i = 0; i < nums.length; i++) {
            count.merge(nums[i], 1, Integer::sum);
        }

        return count.
                entrySet().stream()
                .sorted(Comparator
                        .comparingInt((ToIntFunction<Map.Entry<Integer, Integer>>) Map.Entry::getValue)
                        .reversed())
                .limit(k)
                .mapToInt(entry -> entry.getKey()).toArray();
    }

    private static String probabilities(Map<String, Map<String, Integer>> ngramsFrequency, String word) {
        int frequencyOfWord = ngramsFrequency.getOrDefault(word, Collections.emptyMap())
                .values()
                .stream()
                .reduce(0, Integer::sum);

        return ngramsFrequency.getOrDefault(word, Collections.emptyMap())
                .entrySet().stream()
                .sorted(Comparator
                        .comparingInt((ToIntFunction<Map.Entry<String, Integer>>) Map.Entry::getValue)
                        .reversed()
                        .thenComparing(Map.Entry::getKey))
                .map((entry) -> entry.getKey() + "," + String.format("%.3f", (double) entry.getValue() / frequencyOfWord))
                .collect(Collectors.joining(";"));
    }

    private static List<String> toStrippedWords(String text) {
        String[] words = text.split("\\s+");
        return Arrays.stream(words)
                .map(Main::strip)
                .collect(Collectors.toList());
    }

    private static String strip(String word) {
        return word.chars()
                .dropWhile(value -> !Character.isLetterOrDigit(value))
                .takeWhile(Character::isLetterOrDigit)
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
    }
}
