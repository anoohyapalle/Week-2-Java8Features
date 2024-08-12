import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SalesAnalysis {

    public static void main(String[] args) {

        List<SalesRecord> records = new ArrayList<>();
        records.add(new SalesRecord(1, "Anoohya", "North", "Electronics", 1500.00, 10, LocalDate.of(2024, 8, 10)));
        records.add(new SalesRecord(2, "Bobby", "South", "Furniture", 2000.00, 5, LocalDate.of(2024, 8, 12)));
        records.add(new SalesRecord(3, "Praise", "North", "Electronics", 2500.00, 7, LocalDate.of(2024, 8, 13)));
        records.add(new SalesRecord(4, "Devika", "East", "Books", 1800.00, 20, LocalDate.of(2024, 8, 14)));
        records.add(new SalesRecord(5, "Bobby", "South", "Furniture", 2100.00, 8, LocalDate.of(2024, 8, 15)));

        long startTime = System.nanoTime();
        List<SalesRecord> sortedRecords = records.stream()
                .filter(record -> "Electronics".equals(record.getProductCategory()))
                .sorted(Comparator.comparing(SalesRecord::getDate))
                .collect(Collectors.toList());
        long endTime = System.nanoTime();
        System.out.println("Sequential Stream Time: " + (endTime - startTime) + " ns");

        System.out.println("Filtered and Sorted Records for Electronics Category:");
        sortedRecords.forEach(System.out::println);


        double averageSales = records.stream()
                .filter(record -> "North".equals(record.getRegion()))
                .mapToDouble(SalesRecord::getAmount)
                .average()
                .orElse(0.0);

        System.out.println("Average Sales for North Region: " + averageSales);

        Optional<SalesRecord> topRecord = records.stream()
                .max(Comparator.comparing(SalesRecord::getAmount));

        System.out.println("Top Sales Record:");
        topRecord.ifPresent(System.out::println);


        startTime = System.nanoTime();
        List<SalesRecord> parallelSortedRecords = records.parallelStream()
                .filter(record -> "Electronics".equals(record.getProductCategory()))
                .sorted(Comparator.comparing(SalesRecord::getDate))
                .collect(Collectors.toList());
        endTime = System.nanoTime();
        System.out.println("Parallel Stream Time: " + (endTime - startTime) + " ns");

        System.out.println("Filtered and Sorted Records for Electronics Category (Parallel):");
        parallelSortedRecords.forEach(System.out::println);
    }
}


