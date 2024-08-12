import java.util.*;
import java.util.stream.*;

public class FeedbackProcessorApp {

    public static void main(String[] args) {
        List<Feedback> feedbackList = Arrays.asList(
            new Feedback(1, "Alice", 5, "Great service!"),
            new Feedback(2, "Bob", 3, "Good, but could be better."),
            new Feedback(3, "Charlie", 4, "Satisfied with the service."),
            new Feedback(4, "Dave", 2, "Not very happy."),
            new Feedback(5, "Eve", 1, "Terrible experience!")
        );

        List<Feedback> filteredFeedback = feedbackList.stream()
            .filter(f -> f.getRating() >= 4)
            .collect(Collectors.toList());

        List<String> customerComments = filteredFeedback.stream()
            .map(f -> f.getCustomerName() + ": " + f.getComments())
            .collect(Collectors.toList());

        Map<String, Long> feedbackSummary = feedbackList.stream()
            .collect(Collectors.groupingBy(f -> f.getRating() >= 4 ? "Positive" : "Negative", Collectors.counting()));

        System.out.println("Filtered Feedback: " + filteredFeedback);
        System.out.println("Customer Comments: " + customerComments);
        System.out.println("Feedback Summary: " + feedbackSummary);
    }
}
