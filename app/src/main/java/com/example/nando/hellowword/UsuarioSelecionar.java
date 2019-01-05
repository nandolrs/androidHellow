package com.example.nando.hellowword;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.things.pio.PeripheralManager;

import java.util.List;

public class UsuarioSelecionar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_selecionar);

        TextView inputPortas  = (TextView) findViewById(R.id.inputPortas);

        try
        {

            inputPortas.setText("Aguarde ...");

            PeripheralManager manager = PeripheralManager.getInstance();

            List<String> lista = manager.getGpioList();
            if(!lista.isEmpty())
            {

                inputPortas.setText(lista.size() +";"+  lista.toString());
            }
        }
        catch(Exception e)
        {
            inputPortas.setText("Erro ..." + e.getMessage());
        }



    }
}
