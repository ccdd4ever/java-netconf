import com.tailf.jnc.Capabilities;
import com.tailf.jnc.Device;
import com.tailf.jnc.DeviceUser;
import com.tailf.jnc.Element;
import com.tailf.jnc.JNCException;
import com.tailf.jnc.XMLParser;

import java.io.IOException;
import java.net.URL;

public class NetconfClient {

    public static void main(String[] args) throws IOException, JNCException {
        String localUserName = "admin";
        DeviceUser deviceUser = new DeviceUser(localUserName, "admin", "admin");
        Device mydev = new Device("mydev", deviceUser, "192.168.1.1", 830);
        mydev.connect(localUserName);
        mydev.newSession("cfg");
        XMLParser xmlParser = new XMLParser();

        //获取交换机支持的netconf功能
        Capabilities capabilities = mydev.getSession("cfg").getCapabilities();

        URL resource = ClassLoader.getSystemResource("gettype.xml");
        Element state = xmlParser.readFile(resource.getPath());
        Element cfg = mydev.getSession("cfg").rpc(state);
        System.out.println(cfg.toXMLString());
    }
}
