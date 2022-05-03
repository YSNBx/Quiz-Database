package engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("api")
public class QuizController {

    @Autowired
    private QuizService quizService;
    @Autowired
    private QuizResponse quizResponse;


    @GetMapping("/quizzes")
    public List<Quiz> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }

    @GetMapping("/quizzes/{id}")
    public Quiz getQuiz(@PathVariable Long id) {
        if (quizService.getQuizById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return quizService.getQuizById(id).get();
    }

    @PostMapping("/quizzes")
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        if (!quizService.isValidQuiz(quiz)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return quizService.saveQuiz(quiz);
    }

    @PostMapping("/quizzes/{id}/solve")
    public QuizResponse solveAQuiz(@PathVariable Long id, @NotNull @RequestBody ClientAnswer clientAnswer) {
        if (quizService.getQuizById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        quizResponse.setSuccess(
                clientAnswer.getAnswer()
                        .equals(quizService.getQuizById(id)
                            .get()
                            .getAnswers()
                        )
        );
        return quizResponse;
    }
}