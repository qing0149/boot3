package design_patterns.decorator;

import cn.hutool.json.JSONUtil;

/**
 * @Description
 * @Date 2024/4/16 14:17
 */
public class JsonDecorator implements DataSource {
    private DataSource dataSource;

    public JsonDecorator(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void writeData(String data) {
        dataSource.writeData(JSONUtil.toJsonStr(data));
    }

    @Override
    public String readData() {
        return JSONUtil.toJsonPrettyStr(dataSource.readData());
    }
}
