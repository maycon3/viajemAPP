package br.com.alura.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.dao.PacoteDao;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.ui.adapter.ListaPacodeAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        setTitle(TITULO_APPBAR);
    }

    @Override
    protected void onResume() {
        super.onResume();
        CarregaListaDePacotes();
    }

    private void CarregaListaDePacotes() {
        List<Pacote> listaPacote = new PacoteDao().lista();
        ListView listaDePacotes = findViewById(R.id.item_pacotes_listview);
        listaDePacotes.setAdapter(new ListaPacodeAdapter(this,listaPacote ));
    }
}
