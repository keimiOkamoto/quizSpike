import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerImpl {

    private QuizContainerImpl quizContainer;

    public ServerImpl() throws RemoteException {
        quizContainer = new QuizContainerImpl();
    }

    public static void main(String[] args) {
        try {
            ServerImpl server = new ServerImpl();
            server.launch();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    private void launch() {
        if (System.getSecurityManager() == null) {
            System.getSecurityManager();
        }
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("ListMaker", new ListMakerImpl());
            registry.rebind("quizContainer", quizContainer);

            System.out.println("Server is ready.");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}

