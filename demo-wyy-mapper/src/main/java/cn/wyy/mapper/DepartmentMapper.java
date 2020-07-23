package cn.wyy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.wyy.pojo.Department;
import cn.wyy.pojo.User;

/**
 * 部门信息dao层信息
 * @author 86158
 *
 */
public interface DepartmentMapper {
	
	/**
	 * 查询全部部门信息和员工信息
	 * @return
	 */
	public List<Department> getdepartmentList();
	
	/**
	 * 数据回显
	 * @param user_id
	 * @return
	 */
	public User echoUser(@Param("user_id")Integer user_id);
	
	
	/**
	 * 添加一条员工信息
	 * @param user
	 * @return
	 */
	public int addUser(User user);
	
	/**
	 * 修改一条员工信息
	 * @param user
	 * @return
	 */
	public int updateUser(User user);
	
	/**
	 * 删除一条员工信息
	 * @param user_id
	 * @return
	 */
	public int deleteUser(@Param("user_id")Integer user_id);
	
	
	/**
	 * 模糊查询
	 * @param user_name
	 * @param user_departement
	 * @return
	 */
	public List<Department> getdepartmentLisyByNameAndId(@Param("user_name") String user_name, @Param("user_departement")Integer user_departement);
}
