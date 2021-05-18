package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import model.Employee;

@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeDao employeeDao;

    public void init() {
        employeeDao = new EmployeeDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String name = request.getParameter("name");
        String mst = request.getParameter("mst");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String pin = request.getParameter("pin");

        Employee employee = new Employee();
        employee.setName(name);
        employee.setMst(mst);
        employee.setPassword(password);
        employee.setEmail(email);
        employee.setAddress(address);
        employee.setPhone(phone);
        employee.setPin(pin);

        try {
            int check = employeeDao.registerEmployee(employee);
            if (check != 0)
            	response.sendRedirect("employeedetails.jsp");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

//        response.sendRedirect("employeedetails.jsp");
    }
}
