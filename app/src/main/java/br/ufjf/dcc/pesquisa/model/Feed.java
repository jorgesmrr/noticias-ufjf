package br.ufjf.dcc.pesquisa.model;

import java.util.ArrayList;

/**
 * Created by Jorge Augusto da Silva Moreira on 30/01/2015.
 */
public class Feed {

    private String titulo;
    private String link;
    private ArrayList<Noticia> noticias;

    public Feed(){

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String title) {
        this.titulo = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public ArrayList<Noticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(ArrayList<Noticia> noticias) {
        this.noticias = noticias;
    }
}
