package design_patterns.adapter;

import java.util.List;

/**
 * @Description
 * @Date 2024/4/15 19:21
 */
public interface IUserService {
    public List<String> teacherList();

    public List<String> studentList();
}
