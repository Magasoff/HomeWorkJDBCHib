import java.sql.*;

public class Application {

    public static void main(String[] args) throws SQLException {

        // Задаем параметры для подключения к базе данных:
        // имя пользователя, пароль и URL
        final String user = "postgres";
        final String password = "2w3c4a6RR";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (final Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE ID = (?)")) {
            statement.setInt(1, 4);
            final ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = "Имя: " + resultSet.getString("first_name");
                String lastname = "Фамилия: " + resultSet.getString("last_name");
                String gender = "Пол: " + resultSet.getString(4);
                int age = resultSet.getInt(5);

                System.out.println(name);
                System.out.println(lastname);
                System.out.println(gender);
                System.out.println("Возраст: " + age);
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к БД!");
            e.printStackTrace();
        }
    }
}

