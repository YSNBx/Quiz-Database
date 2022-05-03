package quiz.engine;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String text;

    private ArrayList<String> options;

    @JsonIgnore
    private ArrayList<Integer> answers;

    public Quiz() {}

    public Quiz(Long id, String title, String text, ArrayList<String> options, ArrayList<Integer> answers) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.options = options;
        this.answers = answers;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<String> getOptions() {
        return this.options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArrayList<Integer> getAnswers() {
        return this.answers;
    }

    public void setAnswer(ArrayList<Integer> answers) {
        this.answers = answers;
    }
}