package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MainSearch {
    static void main() throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o nome do filme para busca:");
        var busca = leitura.nextLine();

        String endereco = "http://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=996e7daa";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            System.out.println(json);

            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();

            TituloOmdb tituloOmdb = gson.fromJson(json, TituloOmdb.class);
            System.out.println(tituloOmdb);
            Titulo meuTitulo = new Titulo(tituloOmdb);
            System.out.println("Titulo convertido e Ano de Lançamento: ");
            System.out.println(meuTitulo);
        } catch (NumberFormatException e) {
            System.out.println("Ocorreu um erro ao converter o ano de lançamento do filme: " + e.getMessage());
            System.out.println("Verifique se os dados fornecidos estão corretos.");
        } catch (IllegalArgumentException e) {
            System.out.println("Ocorreu um erro ao processar a requisição: " + e.getMessage());
            System.out.println("Verifique se o nome do filme foi digitado corretamente.");
        } finally {
            System.out.println("Busca finalizada.");
        }
    }
}