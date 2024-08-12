import java.io.Serializable;
import java.time.LocalDate;

public class SalesRecord implements Serializable {
    private int recordId;
    private String salesPerson;
    private String region;
    private double amount;
    private LocalDate date;

    public SalesRecord(int recordId, String salesPerson, String region, double amount, LocalDate date) {
        this.recordId = recordId;
        this.salesPerson = salesPerson;
        this.region = region;
        this.amount = amount;
        this.date = date;
    }
    public int getRecordId() { return recordId; }
    public String getSalesPerson() { return salesPerson; }
    public String getRegion() { return region; }
    public double getAmount() { return amount; }
    public LocalDate getDate() { return date; }

    @Override
    public String toString() {
        return String.format("SalesRecord{id=%d, person='%s', region='%s', amount=%.2f, date=%s}",
                recordId, salesPerson, region, amount, date);
    }
}
