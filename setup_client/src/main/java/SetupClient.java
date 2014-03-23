import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class SetupClient {
    public static void main(String[] args) {

        try {
            /*
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            ListMaker aListMaker = (ListMaker) registry.lookup("ListMaker");
            */
            Remote listMaker = Naming.lookup("//127.0.0.1:1099/createList");
            ListMaker aListMaker = (ListMaker) listMaker;

            int answer = aListMaker.createList("Quiz about cats");
            System.out.println("Returned list ID is " + answer);
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}

