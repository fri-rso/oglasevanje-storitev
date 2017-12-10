package si.jaklic.adverts;

import com.kumuluz.ee.discovery.annotations.RegisterService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@RegisterService(value = "ws-orders", ttl = 20, environment = "dev", version = "1.0.0")
@ApplicationPath("/")
public class OrdersApplication extends Application {
}
