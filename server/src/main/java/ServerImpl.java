import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl implements Service {
    @Override
    public int storeQuestions() {

        return 0;
    }

    public static void main(String args[]) {

        try {
            ServerImpl aServer = new ServerImpl();
            Service stub = (Service) UnicastRemoteObject.exportObject(aServer, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Hello", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
