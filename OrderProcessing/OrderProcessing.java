import java.util.ArrayList;
import java.util.List;

public class OrderProcessing {

    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("1", "Anoohya", 150.00, "Pending"));
        orders.add(new Order("2", "Bobby", 80.00, "Shipped"));
        orders.add(new Order("3", "Praisee", 200.00, "Delivered"));
        orders.add(new Order("4", "Devika", 50.00, "Pending"));

        OrderFilter highValueFilter = order -> order.getOrderAmount() > 100;
        List<Order> highValueOrders = filterOrders(orders, highValueFilter);

        System.out.println("High Value Orders:");
        highValueOrders.forEach(System.out::println);

        OrderProcessor statusUpdater = order -> order.setStatus("Processed");
        processOrders(orders, statusUpdater);

        System.out.println("All Orders After Processing:");
        orders.forEach(System.out::println);
    }

    public static List<Order> filterOrders(List<Order> orders, OrderFilter filter) {
        List<Order> result = new ArrayList<>();
        for (Order order : orders) {
            if (filter.filter(order)) {
                result.add(order);
            }
        }
        return result;
    }

    public static void processOrders(List<Order> orders, OrderProcessor processor) {
        for (Order order : orders) {
            processor.process(order);
        }
    }
}
