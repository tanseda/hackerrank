package interviews;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by stan on 05/2021.
 */
public class ABTesting {
    List<Integer> userIds;
    List<Long> hashCodes;

        /*

        0  17  34  50 51    67  99
        25%  Variant A
        16 bucket (16 * 0.25) = 4
        Variant A:
        Control:
        |                       |           |            |           |           |
        | Control   |           | Group A   |            |  Group B  |           |
        |           |           |           |            |           |           |
        0                       > 50                     >66.7                   |


         */

    public static void main(String[] args) {
        ABTesting testing = new ABTesting();
        String group = testing.findExperimentGroup(1234567, 0.5, 2, "experiment1", 100);
        System.out.println(group);

        group = testing.findExperimentGroup(1234568, 0.5, 2, "experiment1", 100);
        System.out.println(group);

        group = testing.findExperimentGroup(12345679, 0.5, 2, "experiment1", 100);
        System.out.println(group);


        group = testing.findExperimentGroup(2343255, 0.5, 2, "experiment1", 100);
        System.out.println(group);

        group = testing.findExperimentGroup(1234567, 0.5, 2, "experiment2", 100);
        System.out.println(group);


        group = testing.findExperimentGroup(1234567, 0.5, 2, "experiment54654", 100);
        System.out.println(group);
        //userId, double samplePercentage, int numberOfVariants, String experimentName, int bucketSize
//        testing.initUsers();
//        testing.initHashCodes("experiment1", 100);
        //.      System.out.println(testing.findExperimentGroup (1234567, 100));
    }


    private String findExperimentGroup(int userId, double samplePercentage, int numberOfVariants, String experimentName, int bucketSize) {
        Integer bucketIndex = createHashCode(userId, experimentName, bucketSize);

        int variantsBucket = (int) Math.ceil((double) bucketSize / (1 + numberOfVariants));
        int bucketSizePerVariant = findBucketSizePerVariant(bucketSize, samplePercentage, numberOfVariants);

        System.out.println(bucketIndex);
        int i = 0;
        while (!((variantsBucket * i) < bucketIndex && bucketIndex < (variantsBucket * i) + bucketSizePerVariant - 1) && i <= numberOfVariants) {
            //      System.out.println ( " " + (variantsBucket * i) + ",  " + ((variantsBucket * i) + bucketSizePerVariant - 1));
            i++;
        }
        return String.valueOf(i);

    }

    private void initUsers() {
        userIds = List.of(1234567,
                1234568,
                12345679,
                2343255,
                3453453);
    }

    private void initHashCodes(String experimentName, int bucketSize) {

        hashCodes = userIds.stream()
                .map(it -> Hashing.sha256().hashString(it.toString() + experimentName, Charsets.UTF_8).toString())
                .map(it -> it.substring(0, 15).toUpperCase())
                .map(it -> Long.valueOf(it, 16))
                .collect(Collectors.toList());

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.valueOf("FFFFFFFFFFFFFFF", 16));
        // 1152921504606846975
        System.out.println(hashCodes);
        IntStream.range(0, hashCodes.size())
                .map(it -> findBucketIndex(it, bucketSize))
                .forEach(System.out::println);
    }

    private Integer createHashCode(Integer userId, String experimentName, int bucketSize) {
        String hashCode = Hashing.md5().hashString(userId.toString() + experimentName, Charset.defaultCharset()).toString();
        hashCode = hashCode.substring(0, 15).toUpperCase();

        return (int) (Long.valueOf(hashCode, 16) % bucketSize);
    }

    private int findBucketIndex(int index, int bucketSize) {
        int bucketIndex = (int) (hashCodes.get(index) % bucketSize);

        return bucketIndex;
    }

    private int findBucketSizePerVariant(int numberOfTotalBuckets, double sampleSizePercentage, int numberOfVariant) {

        int bucketSizePerVariant = (int) Math.ceil((numberOfTotalBuckets * sampleSizePercentage) / (1 + numberOfVariant));
        //System.out.println(bucketSizePerVariant);
        return bucketSizePerVariant;
    }

    private String findExperimentGroup(int userId, int bucketSize) {
        int numberOfTotalBuckets = 100;
        double sampleSizePercentage = 0.5;
        int numberOfVariant = 2;

        int index = userIds.indexOf(userId);

        int bucketIndex = findBucketIndex(index, bucketSize);
        //System.out.println("bucketIndex " + bucketIndex);
        int bucketSizePerVariant = findBucketSizePerVariant(numberOfTotalBuckets, sampleSizePercentage, numberOfVariant);
        int variantBuckets = numberOfTotalBuckets / (1 + numberOfVariant);


        // Buckets [00–33] get reserved for the control variant, [34–66] for variant A and [67–99] for variant B.
        //Buckets [00–17] get assigned to control, buckets [34–51] to variant A and buckets [67–84] to variant B

        if (0 < bucketIndex && bucketIndex < bucketSizePerVariant) {
            return "control";
        } else if (variantBuckets < bucketIndex && bucketIndex < variantBuckets + bucketSizePerVariant - 1) {
            return "Pool A";
        } else if (variantBuckets * 2 < bucketIndex && bucketIndex < (variantBuckets * 2) + bucketSizePerVariant - 1) {
            return "Pool B";
        } else if (variantBuckets * 3 < bucketIndex && bucketIndex < (variantBuckets * 3) + bucketSizePerVariant - 1) {
            return "Pool C";
        } else if (variantBuckets * 4 < bucketIndex && bucketIndex < (variantBuckets * 4) + bucketSizePerVariant - 1) {
            return "Pool D";
        } else {
            return "couldn't find";
        }
    }

}
