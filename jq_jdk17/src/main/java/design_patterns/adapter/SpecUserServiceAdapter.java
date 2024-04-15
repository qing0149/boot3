package design_patterns.adapter;

import cn.hutool.json.JSONUtil;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Date 2024/4/15 19:23
 */
public class SpecUserServiceAdapter implements SpecUserService {
    private IUserService userService;

    public SpecUserServiceAdapter(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public List<String> teacherListJson() {
        List<String> teacheredList = userService.teacherList();
        List<String> teacheredListJson = teacheredList.stream().map(JSONUtil::toJsonStr).collect(Collectors.toList());
        return teacheredListJson;
    }

    @Override
    public List<String> studentListJson() {
        return null;
    }
}
