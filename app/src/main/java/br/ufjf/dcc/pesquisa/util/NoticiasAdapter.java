package br.ufjf.dcc.pesquisa.util;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import br.ufjf.dcc.pesquisa.R;
import br.ufjf.dcc.pesquisa.model.Noticia;
import br.ufjf.dcc.pesquisa.ui.ListaFragment;

public class NoticiasAdapter extends RecyclerView.Adapter<NoticiasAdapter.ItemHolder> {

    private final ArrayList<Noticia> noticias;
    private final ListaFragment.Listener listener;

    public NoticiasAdapter(ArrayList<Noticia> noticias, ListaFragment.Listener listener){
        this.noticias = noticias;
        this.listener = listener;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_noticia, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        ((TextView) holder.itemView).setText(noticias.get(position).getTitulo());
        holder.posicao = position;
    }

    @Override
    public int getItemCount() {
        return noticias.size();
    }

    protected class ItemHolder extends RecyclerView.ViewHolder {
        int posicao;

        public ItemHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onNoticiaSelecionada(posicao);
                }
            });
        }
    }
}
