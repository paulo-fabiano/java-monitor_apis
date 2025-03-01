package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {

    protected static String databaseUrl = "jdbc:postgresql://localhost:5432/monitoramento";
    protected static String databaseUser = "postgres";
    protected static String databasePassword = "12345";

    public Database() {}

    public void insert(String url,
                       int status_code
                       ) throws SQLException {
        String query = "INSERT INTO public.monitoramento_apis (url, status_code) VALUES (?, ?)";

        try (
                Connection connection = DriverManager.getConnection(databaseUrl, databaseUser, databasePassword);
                PreparedStatement preparedStatement = connection.prepareStatement(query)
                ){
            preparedStatement.setString(1, url);
            preparedStatement.setInt(2, status_code);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.err.println("[ERRO] Erro ao inserir no banco de dados:  " + e.getMessage());
        }

    }

}
