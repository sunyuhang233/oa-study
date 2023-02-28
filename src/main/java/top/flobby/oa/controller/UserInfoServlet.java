package top.flobby.oa.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.flobby.oa.entity.Employee;
import top.flobby.oa.service.EmployeeService;
import top.flobby.oa.service.UserService;
import top.flobby.oa.service.impl.EmployeeServiceImpl;
import top.flobby.oa.service.impl.UserServiceImpl;
import top.flobby.oa.utils.ResponseUtils;

import java.io.IOException;

/**
 * @author Ahang
 * @version 1.0
 * @description TODO
 * @date 2023/2/27 18:45
 */
@WebServlet("/api/user")
public class UserInfoServlet extends HttpServlet {
    private EmployeeService employeeService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        employeeService = new EmployeeServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eid = request.getParameter("eid");
        Employee employee = employeeService.selectById(Long.parseLong(eid));
        String toJsonString = new ResponseUtils().put("employee", employee).toJsonString();
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(toJsonString);
    }
}
