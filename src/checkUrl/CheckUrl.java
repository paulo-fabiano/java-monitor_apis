package checkUrl;

import database.Database;
import listaUrls.Url;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLException;
import java.util.List;

public class CheckUrl {

    Database database = new Database();

    public CheckUrl() {}

    public String verificarUrl(List<Url> listaUrls){

        HttpClient httpClient = HttpClient.newHttpClient();
        if (!listaUrls.isEmpty()) {
            try {
                for (Url u : listaUrls) {
                    System.out.println("[INFO] Verificando a URL: "+u.getUrl());
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(new URI(u.getUrl()))
                            .GET()
                            .build();

                    HttpResponse<String> response = httpClient.send(
                            request,
                            HttpResponse.BodyHandlers.ofString()
                    );
                    try {
                        database.insert(
                                u.getUrl(),
                                response.statusCode()
                        );
                    }
                    catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            } catch (URISyntaxException e) {
                System.out.println("[ERRO] URL inválida" + e.getMessage());
            }
            catch (IOException e) {
                System.out.println("[ERRO] Falha ao verificar URL" + e.getMessage());
            }
            catch (InterruptedException e) {
                System.out.println("[ERRO] Falha ao verificar URL" + e.getMessage());
            }

        }
        else {
            return "[ERRO] A lista está vazia.";
        }

        return "[ERRO] Nenhuma URL processada.";

    }

}
