import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ServerImpl {
    public static void main(String[] args) {
        ServerImpl server = new ServerImpl();
        server.launch();
    }

    private void launch() {
        SecurityManager sm = new MySecurityManager();
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(sm);
        }
        try {
            LocateRegistry.createRegistry(1099);
            Naming.rebind("//localhost/createList", new ListMakerImpl());

            System.out.println("Server is ready.");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}

