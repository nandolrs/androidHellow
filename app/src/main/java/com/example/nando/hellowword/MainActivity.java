package com.example.nando.hellowword;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.net.URL;
import java.text.NumberFormat;

import static java.lang.Integer.parseInt;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int valor=2;
    int preco=12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        setContentView(R.layout.activity_main_order);
/*
        setContentView(R.layout.activity_menu);
*/

        Intent i = new Intent(this, MenuActivity.class);
        startActivity(i);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        display(valor);
        displayPrice(preco);
        OrganizacaoBuscar();
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
        android.util.Log.i("INFO",">>> DISPLAY <<<");

    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    public void increment(View view) {
        display(valor++);
    }

    public void decrement(View view) {
        if(valor-1 > 0)
        {
            display(--valor);
        }
    }

    void OrganizacaoBuscar()
    {

        //java.net.URL url = new java.net.URL("http", "localhost");
        String[] urls = new String[]{null};
        String urlIn = "";
        String urlOut = "";


        new UrlTratar().execute(urlIn);

        int i = 0;



    }

/*    public void OrganizacaoSelecionar(View view) {
        Intent i = new Intent(this, OrganizacaoSelecionarActivity.class);
        startActivity(i);
    }*/
    public void UsuarioListar(View view) {

    }

    public void OrcamentoListar(View view) {

    }

}
