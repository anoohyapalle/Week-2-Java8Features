import java.util.List;

class FeedbackService {

    public void processFeedback(List<Feedback> feedbackList, FeedbackFilter filter, FeedbackProcessor processor) {
        feedbackList.stream()
            .filter(filter::filter)
            .forEach(processor::process);
    }
}
