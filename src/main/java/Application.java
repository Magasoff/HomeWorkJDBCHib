import java.sql.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Application {

    public static void main(String[] args) throws SQLException {

        Employee employee = new Employee();
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        employeeDAO.getAllEmployee().forEach(System.out::println);
        Integer employeeID = employeeDAO.add(employee);
        System.out.println(employeeDAO.getAllEmployee());
        System.out.println();
        employeeDAO.updateEmployee(employeeID, employee);
        employeeDAO.deleteEmployee(employeeDAO.getBuyId(employeeID));
        System.out.println(employeeDAO.getBuyId(4));
    }
}


