package top.hang.oa.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.hang.oa.entity.Department;
import top.hang.oa.entity.Employee;
import top.hang.oa.entity.Node;
import top.hang.oa.service.DepartmentService;
import top.hang.oa.service.EmployeeService;
import top.hang.oa.service.NodeService;
import top.hang.oa.service.impl.DepartmentServiceImpl;
import top.hang.oa.service.impl.EmployeeServiceImpl;
import top.hang.oa.service.impl.NodeServiceImpl;
import top.hang.oa.utils.ResponseUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ahang
 * @version 1.0
 * @description TODO
 * @date 2023/2/27 18:45
 */
@WebServlet("/api/user")
public class UserInfoServlet extends HttpServlet {
    private EmployeeService employeeService;
    private NodeService nodeService;
    private DepartmentService departmentService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        employeeService = new EmployeeServiceImpl();
        nodeService = new NodeServiceImpl();
        departmentService = new DepartmentServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        String eid = request.getParameter("eid");
        String uid = request.getParameter("uid");
        Employee employee = employeeService.selectById(Long.parseLong(eid));
        Department department = departmentService.selectById(employee.getDepartmentId());
        List<Node> nodes = nodeService.selectNodeByUserId(Long.parseLong(uid));
        List<Map<String, Object>> treeList = new ArrayList<>();
        Map<String, Object> module = null;
        for (Node node : nodes) {
            if (node.getNodeType() == 1) {
                module = new LinkedHashMap<>();
                module.put("node", node);
                module.put("children", new ArrayList<Node>());
                treeList.add(module);
            } else if (node.getNodeType() == 2) {
                // assert !=null 含义是：如果module不为空，那么就执行后面的代码，如果为空，那么就抛出异常
                assert module != null;
                List<Node> children = (List<Node>) module.get("children");
                children.add(node);
            }

        }

        String toJsonString = new ResponseUtils().put("employee", employee).put("department", department).put(
                "nodeList", treeList).toJsonString();
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(toJsonString);
    }
}
