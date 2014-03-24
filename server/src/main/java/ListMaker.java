import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ListMaker extends Remote {
    int createList(String title, QuizContainer quizContainer) throws RemoteException;
}


