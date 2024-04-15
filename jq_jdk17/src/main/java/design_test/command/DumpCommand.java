package design_test.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Date 2024/3/27 19:58
 */
public class DumpCommand implements Command {
    List<ApplicationServer> applicationServerList = new ArrayList<>();

    public DumpCommand(List<ApplicationServer> applicationServerList) {
        this.applicationServerList = applicationServerList;
    }

    @Override
    public void execute() {
        for (ApplicationServer applicationServer : applicationServerList) {
            applicationServer.dump();
        }
    }
}
