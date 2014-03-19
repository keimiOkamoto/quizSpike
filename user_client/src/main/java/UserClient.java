import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class UserClient {

        private UserClient() {}

        public static void main(String[] args) {
            String host = (args.length < 1) ? null : args[0];
            try {
                Registry registry = LocateRegistry.getRegistry(host);
                Server stub = (Server) registry.lookup("Hello");
                String response = stub.storeQuestions();
                System.out.println("response: " + response);
            } catch (Exception e) {
                System.err.println("Client exception: " + e.toString());
                e.printStackTrace();
            }
        }
}
