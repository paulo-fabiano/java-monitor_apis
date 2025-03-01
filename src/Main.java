import checkUrl.CheckUrl;
import listaUrls.Url;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("[INFO] Script rodando...");

        // URLs que serão utilizadas no Script
        Url youtube = new Url("https://youtube.com");
        Url google = new Url("https://google.com");
        Url httpbin = new Url("https://httpbin.org/get");
        List<Url> listaUrls = new ArrayList<>();
        listaUrls.add(youtube);
        listaUrls.add(google);
        listaUrls.add(httpbin);

        CheckUrl checkUrl = new CheckUrl();
        System.out.println("[INFO] Verificando URLs...");
        checkUrl.verificarUrl(listaUrls);

        System.out.println("[INFO] Script finalizado.");

    }

}