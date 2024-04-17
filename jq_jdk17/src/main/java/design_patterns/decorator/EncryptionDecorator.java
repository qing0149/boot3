package design_patterns.decorator;

import java.util.Base64;

/**
 * @program: Boot3
 * @description:
 * @author:
 * @create: 2024-03-08 13:50
 **/
public class EncryptionDecorator implements DataSource {
    private DataSource dataSource;

    public EncryptionDecorator(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void writeData(String data) {
        dataSource.writeData(this.encode(data));
        System.out.println("加密后"+dataSource.readData());
    }

    @Override
    public String readData() {
        return decode(dataSource.readData());
    }

    private String encode(String data) {
        byte[] result = data.getBytes();
        for (int i = 0; i < result.length; i++) {
            result[i] += (byte) 1;
        }
        return Base64.getEncoder().encodeToString(result);
    }

    private String decode(String data) {
        byte[] result = Base64.getDecoder().decode(data);
        for (int i = 0; i < result.length; i++) {
            result[i] -= (byte) 1;
        }
        return new String(result);
    }

}
