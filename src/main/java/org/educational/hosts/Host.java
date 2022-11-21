package org.educational.hosts;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

public class Host {

    private String url;
    private InetAddress ipAddress;
    private List<Integer> openPorts;


    public Host(String url, InetAddress ipAddress) throws UnknownHostException {
        this.url = url;
        this.ipAddress = InetAddress.getByName(ipAddress.getHostAddress());
        this.openPorts = openPorts;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public InetAddress getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(InetAddress ipAddress) {
        this.ipAddress = ipAddress;
    }

    public List<Integer> getOpenPorts() {
        return openPorts;
    }

    public void setOpenPorts(List<Integer> openPorts) {
        this.openPorts = openPorts;
    }
}
