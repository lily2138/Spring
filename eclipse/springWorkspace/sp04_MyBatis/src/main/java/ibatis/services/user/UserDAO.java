package ibatis.services.user;

import java.util.List;

import ibatis.services.domain.User;

/*
 * 	비지니스 로직의 템플릿이 들어있다.
 *  5개....mybatis-userservice-mapping10.xml
 *  mapping10.xml의 쿼리문 id값이 비지니스 로직의 이름이 된다.
 *  비지니스 로직의 인자값은 parameterType을 참조
 *  비지니스 로직의 리턴값은 resultType을 참조
 */
public interface UserDAO {
	int addUser(User user) throws Exception;
	int updateUser(User user) throws Exception;
	int removeUser(String userId) throws Exception;
	
	User getUser(String userId) throws Exception;
	List<User> getUserList(User user) throws Exception;
}
