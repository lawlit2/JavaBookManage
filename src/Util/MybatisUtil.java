package Util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MybatisUtil {
    private static SqlSessionFactory sqlSessionFactory;
    static{
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build((new FileInputStream("src/mybatis-config.xml")));
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        }
    }
    public static SqlSession GetSession(boolean Autocomic){
        return sqlSessionFactory.openSession(Autocomic);
    }
}
