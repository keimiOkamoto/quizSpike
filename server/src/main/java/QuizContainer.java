import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuizContainer implements Serializable {
    Map<String, List<String>> mapOfQuizzes = new HashMap<>();

    public void addQuiz(List<String> quiz, String title) {
        mapOfQuizzes.put(title, quiz);
    }
}
