package design_patterns.Compose;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Date 2024/4/16 11:31
 */
public class OssDirectory implements OssNode {
    private List<OssNode> subNodes = new ArrayList<>();
    String path = null;

    public OssDirectory(String path) {
        this.path = path;
    }

    //当全部目录的路径是什么
    @Override
    public String getPath() {
        return path;
    }

    public OssDirectory(OssDirectory parent,String dirName) {
        parent.addChild(this);
        this.path=parent.getPath()+dirName;
    }

    public void addChild(OssNode ossNode) {
        this.subNodes.add(ossNode);
    }

    public void removeChild(OssNode ossNode) {
        this.subNodes.remove(ossNode);

    }

    public List<OssNode> getChildres() {
        return this.subNodes;
    }

}
