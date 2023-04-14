import java.sql.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Application {

    public static void main(String[] args) throws SQLException {

        Employee employee = new Employee(1, "Иван", "Иванов", "male", 23,new City(1, "Moscow"));
        City city = new City(1, "Moscow");
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        CityDAO cityDAO = new CityDAOImpl();
        employeeDAO.add(employee);
        employeeDAO.getAllEmployee().forEach(System.out::println);
        Integer employeeID = employeeDAO.add(employee);
        System.out.println(employeeDAO.getAllEmployee());
        System.out.println();
        employeeDAO.updateEmployee(employeeID, employee);
        employeeDAO.deleteEmployee(employeeDAO.getBuyId(employeeID));
        System.out.println(employeeDAO.getBuyId(4));
    }
}





