package com.xtc.controller.teacher;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xtc.bean.teacher.Teacher;
import com.xtc.service.teacher.TeacherService;
/**
 * @author 范文聪
 * @date 2016-08-05
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {

	
	@Autowired
	private TeacherService teacherService;
	
	/***
	 * 获取全部信息
	 **/
	@RequestMapping(value="/getAllTeacher")
	public ModelAndView getAllTeachers() {
		Map< String, Object> map=new HashMap<String, Object>();
		List<Teacher> teachers=teacherService.getAllTeacher();
		List< String> dateList=new ArrayList<>();
		if(false==teachers.isEmpty()){
			for (Teacher teacher : teachers) {
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String date=sdf.format(teacher.getRegistDate());
				dateList.add(date);
			}
		}
		map.put("teacherList", teachers);
		map.put("dateList", dateList);
		return new ModelAndView("showAllTeacher",map);
	}
	
	/*
	 *  教师登录
	 **/
	@RequestMapping(value="/login")
	public ModelAndView login(@RequestParam("name") String name,@RequestParam("password") String password) {
		Integer i=teacherService.login(name, password);
		if (i>0) {
			
			return new ModelAndView("LoginSuccess");
		} else {
			return new ModelAndView("error");
		}
	}
	
	/***
	 *根据名字查找教师 
	 ***/
	@RequestMapping(value="/getTeacherByName")
	public ModelAndView getTeacherByName(@RequestParam("getName") String name) {
		Map< String, Object> map=new HashMap<String, Object>();
		List<Teacher> teachers=teacherService.getTeacherByName(name);
		List< String> dateList=new ArrayList<>();
		if(false==teachers.isEmpty()){
			for (Teacher teacher : teachers) {
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String date=sdf.format(teacher.getRegistDate());
				dateList.add(date);
			}
		}
		map.put("teacherList", teachers);
		map.put("dateList", dateList);
		return new ModelAndView("showAllTeacher",map);
	}
	
	/***
	 *跳转到添加教师页面 
	 **/
	@RequestMapping("/insert")
	public String toAddTeacherPage(){
		return "insert";
	}
	
	/**
	 *删除教师 
	 **/
	@RequestMapping(value="/delete/{id}")
	public String deleteById(@PathVariable("id") String id){
		teacherService.deleteById(id);
		return "deleteSuccess";
	}
	
	/***
	 *跳转到修改教师的页面
	 **/
	@RequestMapping(value="/update/{id}")
	public ModelAndView updateById(@PathVariable("id") String id){
		Map< String, Object> map=new HashMap<String, Object>();
		Teacher teacher=teacherService.getById(id);
		map.put("teacher", teacher);
		return new ModelAndView("update",map);
	}
	
	/***
	 *添加教师 
	 **/
	@RequestMapping("/addTeacher")
	public ModelAndView addTeacher(@Valid Teacher teacher,BindingResult result){
		
		Map< String, Object> map=new HashMap<String, Object>();
		
		if (result.hasErrors()) {
			List<FieldError> errors=result.getFieldErrors();
			for (FieldError fieldError : errors) {
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return new ModelAndView("insert",map);
		}
		else {
			teacher.setId(uutil.UUIDUtil.getUUID());
			teacher.setRegistDate(new Date());
			teacherService.insert(teacher);
			return new ModelAndView("success");
		}
	}
	
	/***
	 *修改教师 
	 **/
	@RequestMapping("/update/updateTeacher")
	public ModelAndView updateTeacher(@Valid Teacher teacher,BindingResult result){
		Map< String, Object> map=new HashMap<String, Object>();
		
		if (result.hasErrors()) {
			List<FieldError> errors=result.getFieldErrors();
			for (FieldError fieldError : errors) {
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return new ModelAndView("update",map);
		}
		else {
		teacherService.update(teacher);
		return new ModelAndView("success");
		}
	}
}
