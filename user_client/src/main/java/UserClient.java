    import java.rmi.NotBoundException;
    import java.rmi.RemoteException;
    import java.rmi.registry.LocateRegistry;
    import java.rmi.registry.Registry;

    public class UserClient {
        public static void main(String[] args) {
            try {
                Registry registry = LocateRegistry.getRegistry("localhost", 1099);
                ListMaker aListMaker = (ListMaker) registry.lookup("ListMaker");

                int answer = aListMaker.createList("Quiz about cats");
                System.out.println("Returned list ID is " + answer);
            } catch (RemoteException | NotBoundException e) {
                e.printStackTrace();
            }
        }
    }
