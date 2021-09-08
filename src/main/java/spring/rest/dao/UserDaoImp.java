package spring.rest.dao;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import spring.rest.entity.Post;
import spring.rest.entity.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImp implements UserDao, InitializingBean {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public String findNameById(Long id) {
        String sql = "SELECT last_name FROM public.\"user\" WHERE id = :id";
        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("id", id);
        return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, String.class);
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT id, name, last_name FROM public.\"user\"";
        return namedParameterJdbcTemplate.query(sql, (ResultSet rs, int rowNum) -> {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setLastName(rs.getString("last_name"));
            return user;
        });
    }

    @Override
    public List<User> findAllWithPosts() {
        String sql = "SELECT u.id, u.name, u.last_name, u.bio, u.create_date, u.email, u.password, u.username, "
                + "p.id AS post_id, p.caption, p.likes, p.location, p.title, p.created_date FROM \"user\" u "
                + "LEFT JOIN post p on u.id = p.user_id";
//        return namedParameterJdbcTemplate.query(sql, new UserWithPostsExtractor());
        return namedParameterJdbcTemplate.query(sql, (ResultSet resultSet) -> {
            Map<Long, User> map = new HashMap<>();
            User user;
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                user = map.get(id);
                if (user == null) {
                    user = new User();
                    user.setId(id);
                    user.setName(resultSet.getString("name"));
                    user.setLastName(resultSet.getString("last_name"));
                    user.setBio(resultSet.getString("bio"));
                    user.setCreateDate(resultSet.getDate("create_date"));
                    user.setEmail(resultSet.getString("email"));
                    user.setPassword(resultSet.getString("password"));
                    user.setUsername(resultSet.getString("username"));
                    map.put(id, user);
                }
                Long postId = resultSet.getLong("post_id");
                if (postId > 0) {
                    Post post = new Post();
                    post.setId(postId);
                    post.setUserId(id);
                    post.setCaption(resultSet.getString("caption"));
                    post.setLikes(resultSet.getInt("likes"));
                    post.setLocation(resultSet.getString("location"));
                    post.setTitle(resultSet.getString("title"));
                    post.setCreateDate(resultSet.getDate("created_date"));
                    user.setPost(post);
                }
            }
            return new ArrayList<>(map.values());
        });
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (namedParameterJdbcTemplate == null) {
            throw new BeanCreationException("Null namedParameterJdbcTemplate on SingerDao");
        }
    }

//    private static final class UserMapper implements RowMapper<User> {
//
//        @Override
//        public User mapRow(ResultSet resultSet, int i) throws SQLException {
//            User user = new User();
//            user.setId(resultSet.getLong("id"));
//            user.setName(resultSet.getString("name"));
//            user.setLastName(resultSet.getString("last_name"));
//            return user;
//        }
//    }

//    private static final class UserWithPostsExtractor implements ResultSetExtractor<List<User>> {
//
//        @Override
//        public List<User> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
//            Map<Long, User> map = new HashMap<>();
//            User user;
//            while (resultSet.next()) {
//                Long id = resultSet.getLong("id");
//                user = map.get(id);
//                if (user == null) {
//                    user = new User();
//                    user.setId(id);
//                    user.setName(resultSet.getString("name"));
//                    user.setLastName(resultSet.getString("last_name"));
//                    user.setBio(resultSet.getString("bio"));
//                    user.setCreateDate(resultSet.getDate("create_date"));
//                    user.setEmail(resultSet.getString("email"));
//                    user.setPassword(resultSet.getString("password"));
//                    user.setUsername(resultSet.getString("username"));
//                    map.put(id, user);
//                }
//                Long postId = resultSet.getLong("post_id");
//                if (postId > 0) {
//                    Post post = new Post();
//                    post.setId(postId);
//                    post.setUserId(id);
//                    post.setCaption(resultSet.getString("caption"));
//                    post.setLikes(resultSet.getInt("likes"));
//                    post.setLocation(resultSet.getString("location"));
//                    post.setTitle(resultSet.getString("title"));
//                    post.setCreateDate(resultSet.getDate("created_date"));
//                    user.setPost(post);
//                }
//            }
//            return new ArrayList<>(map.values());
//        }
//    }


}
