package cn.wyy.test;

import java.util.List;
import java.util.Scanner;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.wyy.pojo.Department;
import cn.wyy.pojo.User;
import cn.wyy.service.DepartmentService;

/**
 * 单元测试部门信息
 * 
 * @author 86158
 *
 */
public class DepartmentTest extends BaseJunit4Test {
	@Autowired
	private DepartmentService departmentService;
	Scanner input = new Scanner(System.in);

	/**
	 * 查询全部信息
	 */
	@Test
	public void getDepartmentlist() {
		// 先查询全部的部门员工信息
		List<Department> Departmentlist = departmentService.getdepartmentList();
		System.out.println("部门名称\t\t部门负责人");
		for (Department department : Departmentlist) {
			System.out.println(department.getDepartment_name() + "\t\t" + department.getDepartment_user());
			for (User user : department.getUserList()) {
				System.out.println("员工\t\t" + user.getUser_name());
			}
		}
	}

	/**
	 * 添加员工信息
	 */
	@Test
	public void addUser() {
		System.out.print("请输入员工姓名:");
		String user_name = input.next();
		System.out.print("请分配员工部门:(选填1~4)");
		Integer user_departement = input.nextInt();
		System.out.print("请输入员工工资:");
		Integer user_salary = input.nextInt();
		System.out.print("请输入员工所在住址:");
		String user_address = input.next();

		// 调用对象
		User user = new User();
		user.setUser_name(user_name);
		user.setUser_departement(user_departement);
		user.setUser_salary(user_salary);
		user.setUser_address(user_address);
		// 接收参数
		int row = departmentService.addUser(user);
		if (row > 0) {
			System.out.println("添加员工信息成功");
		} else {
			System.out.println("添加员工信息失败");
		}
		input.close();
	}

	/**
	 * 数据回显和修改员工信息
	 */
	@Test
	public void updateAndechoUser() {
		System.out.print("请输入需要查询的员工id:");
		Integer user_id = input.nextInt();
		User user1 = departmentService.echoUser(user_id);
		System.out.println("姓名:" + user1.getUser_name());
		if (user1.getUser_departement() == 1) {
			System.out.println("员工部门:" + "魏势力");
		}
		if (user1.getUser_departement() == 2) {
			System.out.println("员工部门:" + "蜀势力");
		}
		if (user1.getUser_departement() == 3) {
			System.out.println("员工部门:" + "吴势力");
		}
		if (user1.getUser_departement() == 4) {
			System.out.println("员工部门:" + "群势力");
		}
		System.out.println("员工工资:" + user1.getUser_salary());
		System.out.println("员工住址:" + user1.getUser_address());
		// ==========================================================//

		System.out.print("请输入员工姓名:");
		String user_name = input.next();
		System.out.print("请分配员工部门:(选填1~4)");
		Integer user_departement = input.nextInt();
		System.out.print("请输入员工工资:");
		Integer user_salary = input.nextInt();
		System.out.print("请输入员工所在住址:");
		String user_address = input.next();
		// 调用对象
		User user = new User();
		user.setUser_name(user_name);
		user.setUser_departement(user_departement);
		user.setUser_salary(user_salary);
		user.setUser_address(user_address);
		user.setUser_id(user_id);

		// 接收参数
		int row = departmentService.updateUser(user);
		if (row > 0) {
			System.out.println("修改员工信息成功");
		} else {
			System.out.println("修改员工信息失败");
		}
		
		//修改信息完成后再次回显信息
		User user2 = departmentService.echoUser(user_id);
		System.out.println("姓名:" + user2.getUser_name());
		if (user2.getUser_departement() == 1) {
			System.out.println("员工部门:" + "魏势力");
		}
		if (user2.getUser_departement() == 2) {
			System.out.println("员工部门:" + "蜀势力");
		}
		if (user2.getUser_departement() == 3) {
			System.out.println("员工部门:" + "吴势力");
		}
		if (user2.getUser_departement() == 4) {
			System.out.println("员工部门:" + "群势力");
		}
		System.out.println("员工工资:" + user2.getUser_salary());
		System.out.println("员工住址:" + user2.getUser_address());
		input.close();
	}

	/**
	 * 删除员工信息
	 */
	@Test
	public void deleteUser() {
		System.out.print("请输入需要删除的员工id:");
		Integer user_id = input.nextInt();
		User user1 = departmentService.echoUser(user_id);
		System.out.println("姓名:" + user1.getUser_name());
		if (user1.getUser_departement() == 1) {
			System.out.println("员工部门:" + "魏势力");
		}
		if (user1.getUser_departement() == 2) {
			System.out.println("员工部门:" + "蜀势力");
		}
		if (user1.getUser_departement() == 3) {
			System.out.println("员工部门:" + "吴势力");
		}
		if (user1.getUser_departement() == 4) {
			System.out.println("员工部门:" + "群势力");
		}
		System.out.println("员工工资:" + user1.getUser_salary());
		System.out.println("员工住址:" + user1.getUser_address());
		int row = departmentService.deleteUser(user_id);
		if (row > 0) {
			System.out.println("删除员工信息成功");
		} else {
			System.out.println("删除员工信息失败");
		}
		
		//删除完成之后就查询全部部门员工信息
		List<Department> Departmentlist = departmentService.getdepartmentList();
		System.out.println("部门名称\t\t部门负责人");
		for (Department department : Departmentlist) {
			System.out.println(department.getDepartment_name() + "\t\t" + department.getDepartment_user());
			for (User user : department.getUserList()) {
				System.out.println("员工\t\t" + user.getUser_name());
			}
		}
	}
	
	/**
	 * 模糊查询
	 */
	@Test
	public void getdepartmentLisyByNameAndId() {
		String user_name = "孙";
		Integer user_departement = 0;
		List<Department> Departmentlist = departmentService.getdepartmentLisyByNameAndId(user_name, user_departement);
		for (Department department : Departmentlist) {
			System.out.println(department.getDepartment_name() + "\t\t" + department.getDepartment_user());
			for (User user : department.getUserList()) {
				System.out.println("员工\t\t" + user.getUser_name());
			}
		}
	}
	
	
}
