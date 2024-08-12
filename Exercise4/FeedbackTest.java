public class FeedbackTest {

    public static void main(String[] args) {
        List<Feedback> feedbackList = Arrays.asList(
            new Feedback(1, "Anoohya", 5, "Great service!"),
            new Feedback(2, "Bobby", 3, "Good, but could be better."),
            new Feedback(3, "Rahul", 4, "Satisfied with the service."),
            new Feedback(4, "Devika", 2, "Not very happy."),
            new Feedback(5, "Praisee", 1, "Terrible experience!")
        );

        FeedbackService feedbackService = new FeedbackService();

        FeedbackFilter positiveFeedbackFilter = f -> f.getRating() >= 4;
        
        FeedbackProcessor printProcessor = f -> System.out.println("Processing: " + f);

        feedbackService.processFeedback(feedbackList, positiveFeedbackFilter, printProcessor);
    }
}
