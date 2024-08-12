
class SalesRecord {
    private int recordId;
    private String salesPerson;
    private String region;
    private String productCategory;
    private double amount;
    private int quantity;
    private LocalDate date;

    public SalesRecord(int recordId, String salesPerson, String region, String productCategory, double amount, int quantity, LocalDate date) {
        this.recordId = recordId;
        this.salesPerson = salesPerson;
        this.region = region;
        this.productCategory = productCategory;
        this.amount = amount;
        this.quantity = quantity;
        this.date = date;
    }

    public int getRecordId() { return recordId; }
    public String getSalesPerson() { return salesPerson; }
    public String getRegion() { return region; }
    public String getProductCategory() { return productCategory; }
    public double getAmount() { return amount; }
    public int getQuantity() { return quantity; }
    public LocalDate getDate() { return date; }

    @Override
    public String toString() {
        return String.format("SalesRecord{id=%d, person='%s', region='%s', category='%s', amount=%.2f, quantity=%d, date=%s}",
                recordId, salesPerson, region, productCategory, amount, quantity, date);
    }
}