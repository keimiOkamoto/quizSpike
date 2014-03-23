import java.rmi.RMISecurityManager;
import java.security.Permission;

public class MySecurityManager extends RMISecurityManager {
    @Override
    public void checkPermission(Permission perm) {
        return;
    }
}
