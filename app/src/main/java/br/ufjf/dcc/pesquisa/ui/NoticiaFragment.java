package br.ufjf.dcc.pesquisa.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.ufjf.dcc.pesquisa.R;
import br.ufjf.dcc.pesquisa.model.Noticia;

public class NoticiaFragment extends Fragment {
    public static final String ARG_NOTICIA = "noticia";

    private Noticia noticia;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        noticia = getArguments().getParcelable(ARG_NOTICIA);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_noticia, container, false);

        TextView titulo = ((TextView) view.findViewById(R.id.titulo));
        TextView descricao = ((TextView) view.findViewById(R.id.descricao));

        titulo.setText(noticia.getTitulo());
        descricao.setText(Html.fromHtml(noticia.getDescricao()));
        descricao.setMovementMethod(LinkMovementMethod.getInstance());

        return view;
    }
}