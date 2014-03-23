import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerImpl {
    public static void main(String[] args) {
        try {
            System.setSecurityManager(new RMISecurityManager());

            /*
            registry.rebind("ListMaker", new ListMakerImpl());
            */

            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://localhost/ListMaker", new ListMakerImpl());

            System.out.println("Server is ready.");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}

