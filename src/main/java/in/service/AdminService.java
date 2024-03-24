package in.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.entity.ClassList;
import in.repository.ClassListRepo;

@Service
public class AdminService {

	@Autowired
	ClassListRepo clRepo;
	@Autowired
	TimeTable ttService;

	public boolean createClass(String className) {
		try {
			ClassList cls = new ClassList();

			cls.setClassName(className);
			ClassList cl = clRepo.save(cls);
			ttService.createTimeTableForClass(cl);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
