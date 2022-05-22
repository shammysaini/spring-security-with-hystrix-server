package user.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import user.services.entity.User;
import user.services.repository.UserRepository;
import user.services.service.UserService;
import user.services.vo.Department;
import user.services.vo.ResponseTemplateVO;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public User saveUser(User user) {
		log.info("Enter in saveUser method inside in UserServiceImpl class");
		return userRepository.save(user);

	}

	@Override
	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		log.info("Enter in getUserWithDepartment method inside in UserServiceImpl class");
		ResponseTemplateVO vo = new ResponseTemplateVO();
		User user = userRepository.findByUserId(userId);
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId()
				,Department.class);
		vo.setUser(user);
		vo.setDepartment(department);
		return vo;

	}

}
