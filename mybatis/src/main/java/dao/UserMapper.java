package dao;

import model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author:Lvxingqing
 * @Description:
 * @Date:Create in 13:57 2018/5/30
 * @Modified By:
 */
public interface UserMapper {
    User select(int id);

    int insert(User user);

    // 选择性更新
    int update(User user);

    int delete(int id);

    // 按条件模糊查询
    List<User> selectByParams(User user);

    // 查出的结果放在map中
    List<Map> selectAsMap();

    // 数组批量查询
    List<User> selectInArray(int[] arr);

    // list批量查询
    List<User> selectInList(List list);

    // set批量查询
    List<User> selectInSet(Set set);

    // 批量插入
    int insertBatch(List<User> users);

}
