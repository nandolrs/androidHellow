package com.example.nando.hellowword;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.cflib.Cabecalho;
import com.cflib.SegCore;

public class OrganizacaoSelecionarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizacao_selecionar);
        CarregarURL();



    }

    void CarregarURL()
    {
        Spinner inputURL  = (Spinner) findViewById(R.id.inputURL);
        String[] urls =
                {
                         "http://w3evolve.sa-east-1.elasticbeanstalk.com/seguranca/service1.svc/TokenObter"
                        ,"http://localhost:57570/service1.svc/TokenObter"
                        ,"http://192.168.0.7:57570/service1.svc/TokenObter"
                        ,"http://192.168.0.7/seguranca/service1.svc/TokenObter"
                        ,"http://192.168.0.7/seguranca/service1.svc/TokenObter"
                        ,"http://192.168.0.7/seguranca-teste/service1.svc/TokenObter"
                        ,"http://10.0.2.2/seguranca/service1.svc/TokenObter"
                        ,"http://10.0.2.2/seguranca-teste/service1.svc/TokenObter"

                };

        ArrayAdapter arrayAdapter  =  new ArrayAdapter(this, android.R.layout.simple_spinner_item, urls);
        inputURL.setAdapter(arrayAdapter);

    }

    public void UsuarioAutenticar(View v)
    {
        EnviarJSON();
    }

    void EnviarJSON()
    {
        try
        {
            TextView inputUsuario  = (TextView) findViewById(R.id.inputUsuario);
            TextView inputSenha  = (TextView) findViewById(R.id.inputSenha);
            TextView inputMensagem = (TextView) findViewById(R.id.inputMensagem);

            inputMensagem.setText("Aguarde ....");

            //

            SegCore segCore = new SegCore();

            String usuarioAberto = inputUsuario.getText().toString();
            String usuarioFechado = segCore.Cifrar(usuarioAberto);

            String senhaAberta = inputSenha.getText().toString();
            String senhaFechada = segCore.Cifrar(senhaAberta);;

            org.json.JSONObject credenciais = new org.json.JSONObject();
            credenciais.put("nome",usuarioFechado);
            credenciais.put("senha",senhaFechada ); // senhaFechada

            Spinner inputURL  = (Spinner) findViewById(R.id.inputURL);
            String url = (String) inputURL.getSelectedItem();

            com.cflib.Token token = new com.cflib.Token();
            token.setUrl(url);

            Cabecalho cabecalho = new Cabecalho();
            cabecalho.nome="w3seguranca.credenciais";
            cabecalho.valor = usuarioFechado + "." + senhaFechada + "." + usuarioFechado + "." + senhaFechada;

            Cabecalho[] cabecalhos = new Cabecalho[1];
            cabecalhos[0] = cabecalho;

            token.setHeaders(cabecalhos);

            token.setJson(credenciais);
            token.setSaida(inputMensagem);
            token.execute("", null, "");
        }
        catch(Exception e)
        {

        }
        finally
        {

        }
    }
}
