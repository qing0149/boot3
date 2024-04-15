package design_patterns.command;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.net.ServerSocket;

/**
 * @program: Boot3
 * @description:
 * @author:
 * @create: 2024-03-08 15:50
 **/
@Data
@AllArgsConstructor
public class ApplicationServer {
    private String ip;

    //备份数据库
    public void dump() {
        System.out.println("备份数据库");
    }

    //进行时间的校准
    public void syncTime() {
        System.out.println("进行时间的校准");
    }

    //对应服务器关机
    public void shutdown() {
        System.out.println("对应服务器关机");
    }

}
