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

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

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

        mostraLocal(viewCriado, pacote);
        mostraImagem(viewCriado, pacote);
        mostraDias(viewCriado, pacote);
        mostraPreco(viewCriado, pacote);

        return viewCriado;
    }


    private void mostraPreco(View viewCriado, Pacote pacote) {
        TextView preco = viewCriado.findViewById(R.id.item_pacotes_preco);
        BigDecimal precoDoPacote = pacote.getPreco();
        NumberFormat formatoBrasileira = DecimalFormat.getCurrencyInstance(new Locale("pt", "br"));
        String moedaBrasileira = formatoBrasileira.format(precoDoPacote);
        preco.setText(moedaBrasileira);
    }

    private void mostraDias(View viewCriado, Pacote pacote) {
        TextView dias = viewCriado.findViewById(R.id.item_pacotes_dias);
        String textoDias = "";
        int quantidadeDeDias = pacote.getDias();
        if(quantidadeDeDias > 1) {
            textoDias = quantidadeDeDias + " dias";
        } else {
            textoDias = quantidadeDeDias + " dia";
        }
        dias.setText(textoDias);
    }

    private void mostraImagem(View viewCriado, Pacote pacote) {
        ImageView imagem = viewCriado.findViewById(R.id.item_pacotes_imagem);
        Resources resources = context.getResources();
        int idDodrawable = resources.getIdentifier(pacote.getImagem(), "drawable", context.getPackageName());
        Drawable drawableImagemPacote = resources.getDrawable(idDodrawable);
        imagem.setImageDrawable(drawableImagemPacote);
    }

    private void mostraLocal(View viewCriado, Pacote pacote) {
        TextView local = viewCriado.findViewById(R.id.item_pacotes_local);
        local.setText(pacote.getLocal());
    }
}
