package cn.wyy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.wyy.utils.ReturnResult;

import cn.wyy.pojo.Department;
import cn.wyy.pojo.User;
import cn.wyy.service.DepartmentService;

@Controller
public class DepartmentServlet {
	@Autowired
	private DepartmentService departmentService;
	
	/**
	 * 测试jsp弹窗样式
	 * @return
	 */
	@RequestMapping("/MyJsp")
	public String MyJsp() {
		return "MyJsp";
	}
	
	/**
	 * 直接访问主页面
	 * @return
	 */
	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
	
	
	/**
	 * 查询全部员工信息
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping({"/index","/"})
	public String index(Model model,HttpServletRequest request,HttpServletResponse response) {
		List<Department> departmentlist = departmentService.getdepartmentList();
		model.addAttribute("departmentlist", departmentlist);
		return "index";
	}
	
	/**
	 * 页面跳转同时展示下拉框信息--addUser.jsp
	 * @return
	 */
	@RequestMapping("/jumpaddUser")
	public String jumpaddUser(Model model) {
		List<Department> departmentlist = departmentService.getdepartmentList();
		model.addAttribute("departmentlist", departmentlist);
		return "addUser";
	}
	
	/**
	 * 	进行添加员工信息
	 *  @param response
	 *  @param user
	 */
	@RequestMapping("/addUser")
	public void addUser(HttpServletResponse response,User user) {
		ReturnResult result = new ReturnResult();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int row = departmentService.addUser(user);
		String json = null;
		if(row > 0) {
			json = JSONObject.toJSONString(result.getSuccess("添加成功!"));
		}else {
			json = JSONObject.toJSONString(result.getFail("添加失败!"));
		}
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 页面跳转--展示数据回显
	 * @param model
	 * @return
	 */
	@RequestMapping("/jumpechoUser")
	public String jumpechoUser(Model model,Integer user_id) {
		User user = departmentService.echoUser(user_id);
		model.addAttribute("user", user);
		return "echo";
	}
	
	/**
	 * 页面跳转同时展示下拉框信息--updateUser.jsp
	 * @param model
	 * @param user_id
	 * @return
	 */
	@RequestMapping("/jumpupdateUser")
	public String jumpupdateUser(Model model,Integer user_id) {
		List<Department> departmentlist = departmentService.getdepartmentList();
		model.addAttribute("departmentlist", departmentlist);
		User user = departmentService.echoUser(user_id);
		model.addAttribute("user", user);
		return "updateUser";
	}
	
	/**
	 * 进行修改员工信息
	 * @param user
	 * @param response
	 */
	@RequestMapping("/updateUser")
	public void updateUser(User user,HttpServletResponse response) {
		ReturnResult result = new ReturnResult();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int row = departmentService.updateUser(user);
		String json = null;
		if(row >0) {
			json = JSONObject.toJSONString(result.getSuccess("修改成功!"));
		}else {
			json = JSONObject.toJSONString(result.getFail("修改失败!"));
		}
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 进行删除员工信息
	 * @param user_id
	 * @param response
	 */
	@RequestMapping("/deleteUser")
	public void deleteUser(Integer user_id,HttpServletResponse response) {
		ReturnResult result = new ReturnResult();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int row = departmentService.deleteUser(user_id);
		String json = null;
		if(row >0) {
			json = JSONObject.toJSONString(result.getSuccess("删除成功!"));
		}else {
			json = JSONObject.toJSONString(result.getFail("删除失败!"));
		}
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 模糊查询
	 * @param model
	 * @param user_name
	 * @param user_departement
	 */
	@RequestMapping("Fuzzyquery")
	public String Fuzzyquery(Model model, String user_name,Integer user_departement,HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {
		List<Department> departmentlist = departmentService.getdepartmentLisyByNameAndId(user_name, user_departement);
		model.addAttribute("departmentlist", departmentlist);
		return "index";
	}
	
}
