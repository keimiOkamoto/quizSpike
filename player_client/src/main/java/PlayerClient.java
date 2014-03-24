import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class PlayerClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            QuizContainer quizContainer = (QuizContainer) registry.lookup("quizContainer");

            List<String> quiz = quizContainer.getQuiz("Quiz about cats");
            String element1 = quiz.get(0);
            String element2 = quiz.get(1);
            System.out.print(element1 + "\n" + element2);

        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}
