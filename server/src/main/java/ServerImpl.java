import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerImpl {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("ListMaker", new ListMakerImpl());

            System.out.println("Server is ready.");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}

