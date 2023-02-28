package top.hang.oa.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.hang.oa.entity.Department;
import top.hang.oa.service.DepartmentService;
import top.hang.oa.service.impl.DepartmentServiceImpl;
import top.hang.oa.utils.ResponseUtils;

import java.io.IOException;

/**
 * @author Ahang
 * @version 1.0
 * @description TODO
 * @date 2023/2/28 14:32
 */
@WebServlet("/api/department")
public class DepartmentServlet extends HttpServlet {
    private DepartmentService departmentService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        departmentService = new DepartmentServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String departmentId = req.getParameter("departmentId");
        Department department = departmentService.selectById(Long.parseLong(departmentId));
        String toJsonString = new ResponseUtils().put("department", department).toJsonString();
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(toJsonString);
    }
}
