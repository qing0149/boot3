package design_test.command;

import java.util.List;

/**
 * @Description
 * @Date 2024/3/27 20:03
 */
public class SyncTimeCommand implements Command{
    public List<ApplicationServer> applicationServerList;

    public SyncTimeCommand(List<ApplicationServer> applicationServerList) {
        this.applicationServerList = applicationServerList;
    }

    @Override
    public void execute() {
        for (ApplicationServer applicationServer : applicationServerList) {
            applicationServer.syncTime();
        }
    }
}
