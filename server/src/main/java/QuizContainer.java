import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface QuizContainer extends Remote {
    public void addQuiz(List<String> quiz, String title) throws RemoteException;

    public List<String> getQuiz(String title) throws RemoteException;

}
