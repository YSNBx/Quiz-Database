package engine;

import engine.Quiz;

import java.util.List;
import java.util.Optional;

public interface QuizService {
    List<Quiz> getAllQuizzes();
    Optional<Quiz> getQuizById(Long id);
    Quiz saveQuiz(Quiz quiz);
    boolean isValidQuiz(Quiz quiz);
}
