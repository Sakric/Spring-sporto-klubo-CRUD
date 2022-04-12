package lt.ku.studentai.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.ku.studentai.entities.Group;
import lt.ku.studentai.repositories.GroupRepository;

@Service
public class GroupService {
	@Autowired
	GroupRepository groupRepository;
	
	public Group addGroup(Group group) {
		return groupRepository.save(group);
	}
	
	public List<Group> getGroups(){
		return groupRepository.findAll();
	}
	
	public Group updateGroup(Group group) {
		Group old=groupRepository.getById(group.getId());
		old.setName(group.getName());
		old.setSurname(group.getSurname());
		old.setEmail(group.getEmail());
		old.setPhone(group.getPhone());
		groupRepository.save(old);
		return old;
	}
	
	public void deleteGroup(Integer id) {
		groupRepository.deleteById(id);
	}
	
	public Group getGroup(Integer id) {
		return groupRepository.getById(id);
	}
	
}
