public class FeedbackTest {

    public static void main(String[] args) {
        List<Feedback> feedbackList = Arrays.asList(
            new Feedback(1, "Alice", 5, "Great service!"),
            new Feedback(2, "Bob", 3, "Good, but could be better."),
            new Feedback(3, "Charlie", 4, "Satisfied with the service."),
            new Feedback(4, "Dave", 2, "Not very happy."),
            new Feedback(5, "Eve", 1, "Terrible experience!")
        );

        FeedbackService feedbackService = new FeedbackService();

        FeedbackFilter positiveFeedbackFilter = f -> f.getRating() >= 4;
        
        FeedbackProcessor printProcessor = f -> System.out.println("Processing: " + f);

        feedbackService.processFeedback(feedbackList, positiveFeedbackFilter, printProcessor);
    }
}
