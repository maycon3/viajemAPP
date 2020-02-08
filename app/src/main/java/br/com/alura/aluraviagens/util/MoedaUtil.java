package br.com.alura.aluraviagens.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import br.com.alura.aluraviagens.model.Pacote;

public class MoedaUtil {

    public static final String PORTUGUES = "pt";
    public static final String BRASIL = "br";

    public static String formataParaBrasileiro(BigDecimal precoDoPacote) {
        NumberFormat formatoBrasileira = DecimalFormat.getCurrencyInstance(new Locale(PORTUGUES, BRASIL));
        return formatoBrasileira.format(precoDoPacote);
    }
}
