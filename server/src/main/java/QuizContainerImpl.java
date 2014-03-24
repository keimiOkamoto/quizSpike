import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuizContainerImpl extends UnicastRemoteObject implements QuizContainer {
    Map<String, List<String>> mapOfQuizzes = new HashMap<>();

    protected QuizContainerImpl() throws RemoteException {
    }

    @Override
    public void addQuiz(List<String> quiz, String title) throws RemoteException {
        mapOfQuizzes.put(title, quiz);
    }

    @Override
    public List<String> getQuiz(String title) throws RemoteException {
        return mapOfQuizzes.get(title);
    }
}
