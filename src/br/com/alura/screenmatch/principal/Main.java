package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Filme filme3 = new Filme("O poderoso chefão", 1970);
        filme3.setDuracaoEmMinutos(180);
        System.out.println("Duração do filme: " + filme3.getDuracaoEmMinutos());

        filme3.exibeFichaTecnica();
        filme3.avalia(8);
        filme3.avalia(5);
        filme3.avalia(10);
        System.out.println("Total de avaliações: " + filme3.getTotalDeAvaliacoes());
        System.out.println(filme3.pegaMedia());

        Serie serie1 = new Serie("Lost", 2000);
        serie1.exibeFichaTecnica();
        serie1.setTemporadas(10);
        serie1.setEpisodiosPorTemporada(10);
        serie1.setMinutosPorEpisodio(50);
        System.out.println("Duração para maratonar Lost: " + serie1.getDuracaoEmMinutos());

        Filme filme2 = new Filme("Avatar", 2023);
        filme2.setDuracaoEmMinutos(200);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(filme3);
        calculadora.inclui(filme2);
        calculadora.inclui(serie1);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(filme3);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(serie1);
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);

        var filme1 = new Filme("Dogville", 2003);
        filme1.setDuracaoEmMinutos(200);
        filme1.avalia(10);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filme1);
        listaDeFilmes.add(filme3);
        listaDeFilmes.add(filme2);
        System.out.println("Tamanho da lista " + listaDeFilmes.size());
        System.out.println("Primeiro filme " + listaDeFilmes.get(0).getNome());
        System.out.println(listaDeFilmes);
        System.out.println("toString do filme " + listaDeFilmes.get(0).toString());

    }
}