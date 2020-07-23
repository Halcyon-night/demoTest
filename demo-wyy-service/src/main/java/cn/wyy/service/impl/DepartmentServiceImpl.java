package cn.wyy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wyy.mapper.DepartmentMapper;
import cn.wyy.pojo.Department;
import cn.wyy.pojo.User;
import cn.wyy.service.DepartmentService;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	private DepartmentMapper departmentMapper;
	
	
	@Override
	/**
	 * 查询全部部门/员工下的信息
	 */
	public List<Department> getdepartmentList() {
		return departmentMapper.getdepartmentList();
	}

	@Override
	/**
	 * 数据回显
	 */
	public User echoUser(Integer user_id) {
		return departmentMapper.echoUser(user_id);
	}

	@Override
	/**
	 * 添加一条员工信息
	 */
	public int addUser(User user) {
		int row = departmentMapper.addUser(user);
		if(row > 0) {
			return row;
		}else {
			return -1;
		}
	}

	@Override
	/**
	 * 修改一条员工信息
	 */
	public int updateUser(User user) {
		int row = departmentMapper.updateUser(user);
		if(row > 0) {
			return row;
		}else {
			return -1;
		}
	}

	@Override
	/**
	 * 删除一条员工信息
	 */
	public int deleteUser(Integer user_id) {
		int row = departmentMapper.deleteUser(user_id);
		if(row > 0) {
			return row;
		}else {
			return -1;
		}
	}

	@Override
	/**
	 * 模糊查询
	 */
	public List<Department> getdepartmentLisyByNameAndId(String user_name, Integer user_departement) {
		return departmentMapper.getdepartmentLisyByNameAndId(user_name, user_departement);
	}

}
