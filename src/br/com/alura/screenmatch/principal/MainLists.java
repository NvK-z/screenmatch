package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MainLists {
    public static void main(String[] args) {
        Filme filme3 = new Filme("O poderoso chefão", 1970);
        filme3.avalia(9);
        Filme filme2 = new Filme("Avatar", 2023);
        filme2.avalia(6);
        var filme1 = new Filme("Dogville", 2003);
        filme1.avalia(10);
        Serie serie1 = new Serie("Lost", 2000);

        Filme f1 = filme1;

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filme1);
        lista.add(filme3);
        lista.add(filme2);
        lista.add(serie1);
        for (Titulo item: lista) {
            System.out.println(item.getNome());
            if (item instanceof  Filme filme && filme.getClassificacao() > 2) {
                System.out.println("Classificação " + filme.getClassificacao());
            }
        }

        List<String> buscaPorArtista = new LinkedList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Paulo");
        buscaPorArtista.add("Jacqueline");
        System.out.println(buscaPorArtista);

        Collections.sort(buscaPorArtista);
        System.out.println("Depois da ordenação");
        System.out.println(buscaPorArtista);
        System.out.println("Lista de titulos ordenados");
        Collections.sort(lista);
        System.out.println(lista);
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Ordenando por ano");
        System.out.println(lista);
    }
}