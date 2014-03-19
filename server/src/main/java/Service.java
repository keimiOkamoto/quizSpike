import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Service extends Remote {

    int storeQuestions() throws RemoteException;
}
