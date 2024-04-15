package design_patterns.adapter;

import java.util.List;

/**
 * @Description
 * @Date 2024/4/15 19:23
 */
public interface SpecUserService {
    public List<String> teacherListJson();

    public List<String> studentListJson();
}
