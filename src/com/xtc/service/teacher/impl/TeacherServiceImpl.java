package com.xtc.service.teacher.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtc.bean.teacher.Teacher;
import com.xtc.dao.teacher.TeacherDao;
import com.xtc.service.teacher.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
    private TeacherDao teacherDao;
    
	@Override
	public void insert(Teacher teacher) {
		teacherDao.insert(teacher);
		
	}

	@Override
	public List<Teacher> getAllTeacher() {
		List<Teacher> teacherList=teacherDao.getAllTeacher();
		return teacherList;
	}

	@Override
	public void deleteById(String id) {
		teacherDao.deleteById(id);
		
	}

	@Override
	public Teacher getById(String id) {
		
		return teacherDao.getById(id);
	}

	@Override
	public void update(Teacher teacher) {
		teacherDao.update(teacher);
		
	}

	@Override
	public List<Teacher> getTeacherByName(String name) {
		return teacherDao.getTeacherByName(name);
	}

	@Override
	public Integer login(String name, String password) {
		return teacherDao.login(name, password);
	}

}
