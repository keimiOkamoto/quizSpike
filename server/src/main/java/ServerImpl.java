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
            /*
            registry.rebind("ListMaker", new ListMakerImpl());
            */
            LocateRegistry.createRegistry(1099);
            ListMakerImpl aListMaker = new ListMakerImpl();

            String host = "//localhost/";
            String serviceName = "createList";
            Naming.rebind(host + serviceName, aListMaker);

            System.out.println("Server is ready.");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}

