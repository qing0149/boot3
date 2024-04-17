package design_patterns.Compose;

/**
 * @Description
 * @Date 2024/4/16 11:39
 */
public class OssFile implements OssNode {
    private String fileName;
    private OssDirectory ossDirectory;

    public OssFile(OssDirectory dir, String fileName) {
        this.ossDirectory = dir;
        dir.addChild(this);
        this.fileName = fileName;
    }

    @Override
    public String getPath() {
        return ossDirectory.getPath() + fileName;
    }
}
