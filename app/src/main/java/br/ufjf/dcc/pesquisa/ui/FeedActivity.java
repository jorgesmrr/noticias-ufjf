package br.ufjf.dcc.pesquisa.ui;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import br.ufjf.dcc.pesquisa.R;
import br.ufjf.dcc.pesquisa.model.Noticia;
import br.ufjf.dcc.pesquisa.model.Feed;
import br.ufjf.dcc.pesquisa.util.WebHelper;

public class FeedActivity extends ActionBarActivity implements ListaFragment.Listener {
    private Feed feed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.noticias));

        new FeedTask().execute();
    }

    @Override
    public void onNoticiaSelecionada(int posicao) {
        Bundle args = new Bundle();
        args.putParcelable(NoticiaFragment.ARG_NOTICIA, feed.getNoticias().get(posicao));

        NoticiaFragment fragment = new NoticiaFragment();
        fragment.setArguments(args);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.feed_container, fragment)
                .addToBackStack(null)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    @Override
    public ArrayList<Noticia> getNoticias() {
        return feed.getNoticias();
    }

    private class FeedTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            try {
                feed = WebHelper.readFeed("http://www.ufjf.br/secom/rss").getFeed();
            } catch (IOException | SAXException | ParserConfigurationException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.feed_container, new ListaFragment())
                    .commit();
        }
    }
}