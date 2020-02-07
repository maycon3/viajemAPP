package br.com.alura.aluraviagens.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;

public class ListaPacodeAdapter extends BaseAdapter {

    private Context context;
    private final List<Pacote> pacotes;

    public ListaPacodeAdapter(Context context, List<Pacote> pacotes){
        this.context = context;
        this.pacotes = pacotes;
    }

    @Override
    public int getCount() {
        return this.pacotes.size();
    }

    @Override
    public Pacote getItem(int position) {
        return this.pacotes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewCriado = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false);
        Pacote pacote = this.pacotes.get(position);

        TextView local = viewCriado.findViewById(R.id.item_pacotes_local);
        local.setText(pacote.getLocal());

        ImageView imagem = viewCriado.findViewById(R.id.item_pacotes_imagem);
        Resources resources = context.getResources();
        int idDodrawable = resources.getIdentifier(pacote.getImagem(), "drawable", context.getPackageName());
        Drawable drawableImagemPacote = resources.getDrawable(idDodrawable);
        imagem.setImageDrawable(drawableImagemPacote);

        TextView dias = viewCriado.findViewById(R.id.item_pacotes_dias);
        dias.setText(pacote.getDias() + " dias");

        TextView preco = viewCriado.findViewById(R.id.item_pacotes_preco);
        preco.setText(pacote.getPreco().toString());

        return viewCriado;
    }
}
