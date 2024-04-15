package design_patterns.adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Date 2024/4/15 19:22
 */
public class UserService implements IUserService{

    @Override
    public List<String> teacherList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("teacher1");
        list.add("teacher2");
        list.add("teacher3");
        list.add("teacher4");
        list.add("teacher5");
        return list;
    }
    @Override
    public List<String> studentList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("student1");
        list.add("student2");
        list.add("student3");
        list.add("student4");
        list.add("student5");
        return list;
    }
}
