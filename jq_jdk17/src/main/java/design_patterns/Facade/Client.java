package design_patterns.Facade;

/**
 * @Description
 * @Date 2024/4/15 16:11
 */
public class Client {
    public static void main(String[] args) {
        new CacheManager().initRedis();
        new DatabaseManager().startDatabaseCluster();
        new WebServerManager().loadWebApp();
        //替换成
        ApplicationFacade applicationFacade = new ApplicationFacade();
        applicationFacade.initSystem();

    }

}
