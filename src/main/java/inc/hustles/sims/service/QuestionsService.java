package inc.hustles.sims.service;

import inc.hustles.sims.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuestionsService {

    private Map<Integer, Question> questions = new HashMap<>();

    public List<Question> loadQuizzes(){
        return new ArrayList<>(questions.values());
    }

    public Question addQuiz(Question question) {
        if (question.getId() <= 0) {
            throw new IllegalArgumentException("Question ID cannot be null");
        }

        questions.put(question.getId(), question);
        return question;
    }

    public Question editQuiz(Question updatedQuestion) {
        int id = updatedQuestion.getId();

        if (id <= 0 || !questions.containsKey(id)) {
            throw new NoSuchElementException("Question with ID " + id + " not found");
        }

        questions.put(id, updatedQuestion);
        return updatedQuestion;
    }

    public boolean deleteQuiz(Long id) {
        if (!questions.containsKey(id)) {
            throw new NoSuchElementException("Question with ID " + id + " not found");
        }

        questions.remove(id);
        return true;
    }
}
