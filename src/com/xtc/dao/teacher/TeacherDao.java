package com.xtc.dao.teacher;

import java.util.List;
import com.xtc.bean.teacher.Teacher;

/***
 * @author 范文聪
 * @date 2016-8-9
 **/
public interface TeacherDao {
	//插入数据
     public void insert(Teacher teacher); 
     //删除数据
     public void deleteById(String id); 
     //查询全部数据
     public List<Teacher> getAllTeacher(); 
     //查询一条数据
     public Teacher getById(String id); 
     //修改数据
     public void update(Teacher teacher); 
     //根据教师名称查询
     public List<Teacher> getTeacherByName(String name); 
     //登录查询
	 public Integer login(String name,String password);
	 
}
