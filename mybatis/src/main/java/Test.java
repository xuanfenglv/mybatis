import dao.UserMapper;
import model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @Author:Lvxingqing
 * @Description:
 * @Date:Create in 13:55 2018/5/30
 * @Modified By:
 */
public class Test {
    public static void main(String[] args) throws Exception {

//        User user = session.selectOne("dao.UserMapper.select",1);
        testSelect();
//        testInsert();
//        testUpdate();
//        testDelete();
//        testSelectByParams();
//        testSelectAsMap();
//        testSelectInArray();
//        testSelectInList();
//        testSelectInSet();
//        testInsertBatch();
    }

    public static SqlSession getSession() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession(true);
        return session;
    }

    public static void testSelect()  {
        SqlSession session = getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.select(1);
        System.out.println("查询的结果："+user);
        session.close();


    }

    public static void testInsert()  {
        SqlSession session = getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setName("斯坦李");
        user.setAge((byte)97);

        int total = mapper.insert(user);
        System.out.println("插入总数："+total);
        System.out.println(user.getName()+"的id："+user.getId());
        session.close();
    }
    public static void testUpdate()  {
        SqlSession session = getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setId((byte)3);
        user.setName(null);
        user.setAge((byte)58);

        int total = mapper.update(user);
        System.out.println("修改总数："+total);
        session.close();
    }

    public static void testDelete() {
        SqlSession session = getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        int total = mapper.delete(1);
        System.out.println("删除总数："+total);
        session.close();
    }
    public static void testSelectByParams() {
        SqlSession session = getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setId(1);
//        user.setName("四");
        user.setAge((byte)43);

        List<User> users = mapper.selectByParams(user);
        System.out.println("users："+users);
        session.close();
    }

    public static void testSelectAsMap() {
        SqlSession session = getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<Map> map = mapper.selectAsMap();
        System.out.println("map："+map);
        session.close();
    }

    public static void testSelectInArray() {
        SqlSession session = getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        int[] arr = {1,2,3,4};
        List<User> users = mapper.selectInArray(arr);
        System.out.println("users："+users);
        session.close();
    }

    public static void testSelectInList() {
        SqlSession session = getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        List<User> users = mapper.selectInList(list);
        System.out.println("users："+users);
        session.close();
    }

    public static void testSelectInSet() {
        SqlSession session = getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        Set set = new HashSet();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        List<User> users = mapper.selectInSet(set);
        System.out.println("users："+users);
        session.close();
    }

    public static void testInsertBatch() {
        SqlSession session = getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List list = new ArrayList();
        User user1 = new User("李5",(byte)25);
        User user2 = new User("李6",(byte)25);
        User user3 = new User("李7",(byte)25);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        int total = mapper.insertBatch(list);
        System.out.println("插入总数："+total);
        System.out.println("users："+list);
        session.close();
    }
}
