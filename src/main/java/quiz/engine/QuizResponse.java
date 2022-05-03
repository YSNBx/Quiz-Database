package quiz.engine;

import org.springframework.stereotype.Component;

@Component
public class QuizResponse {

    private boolean success;
    private String feedback;

    public QuizResponse(boolean success, String feedback) {
        this.success = success;
        this.feedback = feedback;
    }

    public QuizResponse() {}

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
        setFeedback(
                success ? "Congratulations, you're right!" : "Wrong answer! Please, try again."
        );
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}