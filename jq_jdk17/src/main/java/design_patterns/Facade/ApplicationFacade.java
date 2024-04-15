package design_patterns.Facade;

/**
 * @Description
 * @Date 2024/4/15 16:12
 */
public class ApplicationFacade {
    private CacheManager cacheManager = new CacheManager();
    private DatabaseManager databaseManager = new DatabaseManager();
    private WebServerManager webServerManager = new WebServerManager();
    public void initSystem(){
        databaseManager.startDatabaseCluster();
        cacheManager.initRedis();
        webServerManager.loadWebApp();
    }
}
