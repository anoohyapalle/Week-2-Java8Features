import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SalesAnalysis {

    public static void main(String[] args) {
        List<SalesRecord> records = new ArrayList<>();
        records.add(new SalesRecord(1, "Anoohya", "North", 1500.00, LocalDate.of(2024, 8, 10)));
        records.add(new SalesRecord(2, "Bobby", "South", 2000.00, LocalDate.of(2024, 8, 12)));
        records.add(new SalesRecord(3, "Praise", "North", 2500.00, LocalDate.of(2024, 8, 13)));
        records.add(new SalesRecord(4, "Devika", "East", 1800.00, LocalDate.of(2024, 8, 14)));
        records.add(new SalesRecord(5, "Bobby", "South", 2100.00, LocalDate.of(2024, 8, 15)));

        List<SalesRecord> northRegionRecords = records.stream()
                .filter(record -> "North".equals(record.getRegion()))
                .collect(Collectors.toList());

        System.out.println("Filtered Records for North Region:");
        northRegionRecords.forEach(System.out::println);

        List<Double> salesAmounts = northRegionRecords.stream()
                .map(SalesRecord::getAmount)
                .collect(Collectors.toList());

        System.out.println("Sales Amounts for North Region:");
        salesAmounts.forEach(System.out::println);

        double totalSales = northRegionRecords.stream()
                .mapToDouble(SalesRecord::getAmount)
                .sum();

        System.out.println("Total Sales for North Region: " + totalSales);

        Map<String, List<SalesRecord>> salesByPerson = records.stream()
                .collect(Collectors.groupingBy(SalesRecord::getSalesPerson));

        System.out.println("Sales Grouped by Salesperson:");
        salesByPerson.forEach((salesPerson, salesRecords) -> {
            System.out.println("Salesperson: " + salesPerson);
            salesRecords.forEach(System.out::println);
        });

        Map<String, Double> salesReport = records.stream()
                .collect(Collectors.groupingBy(
                    SalesRecord::getSalesPerson,
                    Collectors.summingDouble(SalesRecord::getAmount)
                ));

        System.out.println("Sales Report:");
        salesReport.forEach((salesPerson, totalAmount) ->
            System.out.println("Salesperson: " + salesPerson + ", Total Sales: " + totalAmount)
        );
    }
}
