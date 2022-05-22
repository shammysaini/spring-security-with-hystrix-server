package user.services.service;

import user.services.entity.User;
import user.services.vo.ResponseTemplateVO;

public interface UserService {
	
	User saveUser(User user);
	
	ResponseTemplateVO getUserWithDepartment(Long userId);

}
