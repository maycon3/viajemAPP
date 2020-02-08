package br.com.alura.aluraviagens.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import br.com.alura.aluraviagens.model.Pacote;

public class ResourceUtil  {

    public static  Drawable devolveDrawable(Context context, String imagem) {
        Resources resources = context.getResources();
        int idDodrawable = resources.getIdentifier(imagem, "drawable", context.getPackageName());
        return resources.getDrawable(idDodrawable);
    }
}
