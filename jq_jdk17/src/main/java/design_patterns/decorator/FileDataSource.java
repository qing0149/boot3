package design_patterns.decorator;

import java.io.*;

/**
 * @program: Boot3
 * @description:
 * @author:
 * @create: 2024-03-08 13:48
 **/
public class FileDataSource implements DataSource {
    private String name;
    public FileDataSource(String name) {
        this.name = name;
    }
    @Override
    public void writeData(String data) {
        File file = new File(name);
        try (OutputStream fos = new FileOutputStream(file)) {
            fos.write(data.getBytes(), 0, data.length());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String readData() {
        char[] buffer = null;
        File file = new File(name);
        try (FileReader reader = new FileReader(file)) {
            buffer = new char[(int) file.length()];
            reader.read(buffer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new String(buffer);
    }
}
