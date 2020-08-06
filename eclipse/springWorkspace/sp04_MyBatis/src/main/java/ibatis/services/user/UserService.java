package ibatis.services.user;

import java.util.List;

import ibatis.services.domain.User;
/*
 * 데이타 가공 레이어....
 * 
 */
public interface UserService {
	void addUser(User user) throws Exception;
	void updateUser(User user) throws Exception;
	
	User getUser(String userId) throws Exception;
	List<User> getUserList(User user) throws Exception;
}
