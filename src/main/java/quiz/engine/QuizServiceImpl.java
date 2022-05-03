package engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Override
    public List<Quiz> getAllQuizzes() {
        return (List<Quiz>) quizRepository.findAll();
    }

    @Override
    public Optional<Quiz> getQuizById(Long id) {
        return quizRepository.findById(id);
    }

    @Override
    public Quiz saveQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public boolean isValidQuiz(Quiz quiz) {
        if (quiz.getOptions() == null) {
            return false;
        }

        if (quiz.getOptions().size() < 2) {
            return false;
        }

        if (quiz.getAnswers() == null) {
            quiz.setAnswer(new ArrayList<>(0));
        }

        return true;
    }
}
