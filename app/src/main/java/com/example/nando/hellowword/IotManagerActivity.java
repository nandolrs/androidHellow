package com.example.nando.hellowword;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import com.cflib.Cabecalho;
import com.cflib.SegCore;

public class IotManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iot_manager);
    }

    public void IotComandoIr(View v) // go
    {
        IotComando(EN_IOT_COMANDOS.IR);
    }

    public void IotComandoVoltar(View v) // back
    {
        IotComando(EN_IOT_COMANDOS.VOLTAR);
    }

    public void IotComandoDireita(View v) // turn rigth
    {
        IotComando(EN_IOT_COMANDOS.DIREITA);
    }

    public void IotComandoEsquerda(View v) // go back
    {
        IotComando(EN_IOT_COMANDOS.ESQUERDA);
    }

    public void IotComandoLigarDesligar(View v) // go back
    {
        IotComando(EN_IOT_COMANDOS.LIGAR_DESLIGAR);
    }

    public enum EN_IOT_COMANDOS {IR, VOLTAR, DIREITA, ESQUERDA, LIGAR_DESLIGAR};

    void IotComando(EN_IOT_COMANDOS comando)
    {
        TextView inputDispositivoOrigem   = (TextView) findViewById(R.id.inputDispositivoOrigemIp);
        TextView inputDispositivoDestino  = (TextView) findViewById(R.id.inputDispositivoDestinoIp);
        TextView inputDispositivoRetorno  = (TextView) findViewById(R.id.inputDispositivoRetorno);
        TextView inputMensagem            = (TextView) findViewById(R.id.inputMensagem);

        String url = inputDispositivoDestino.getText().toString();

        String comandoFrase = "/" + comando.toString();

//        if(comando == EN_IOT_COMANDOS.IR) // go
//        {
//            comandoFrase += "/ir_go";
//        }
//        else if (comando == EN_IOT_COMANDOS.VOLTAR) // go back
//        {
//            comandoFrase += "/voltar_goback";
//        }
//        else if (comando == EN_IOT_COMANDOS.DIREITA) // turn rigth
//        {
//            comandoFrase += "/direita_turnRigth";
//        }
//        else if (comando == EN_IOT_COMANDOS.ESQUERDA) // turn left
//        {
//            comandoFrase += "/esquerda_turnLeft";
//        }
//        else if (comando == EN_IOT_COMANDOS.LIGAR_DESLIGAR) // turn on/off
//        {
//            comandoFrase += "/ligarDesligar_turnOnOf";
//        }

        EnviarComando(url, comandoFrase, inputDispositivoRetorno);

    }


    void EnviarComando(String url, String comandoFrase, TextView inputSaida)
    {
        try
        {
            //TextView inputUsuario  = (TextView) findViewById(R.id.inputUsuario);
            //TextView inputSenha  = (TextView) findViewById(R.id.inputSenha);
            //TextView inputMensagem = (TextView) findViewById(R.id.inputMensagem);

            inputSaida.setText("Aguarde ....");

            //

/*
            SegCore segCore = new SegCore();

            String usuarioAberto = inputUsuario.getText().toString();
            String usuarioFechado = segCore.Cifrar(usuarioAberto);

            String senhaAberta = inputSenha.getText().toString();
            String senhaFechada = segCore.Cifrar(senhaAberta);;
*/

/*
            org.json.JSONObject credenciais = new org.json.JSONObject();
            credenciais.put("nome",usuarioFechado);
            credenciais.put("senha",senhaFechada ); // senhaFechada
*/

/*
            Spinner inputURL  = (Spinner) findViewById(R.id.inputURL);
            String url = (String) inputURL.getSelectedItem();
*/

            com.cflib.Rede rede = new com.cflib.Rede();
            rede.setUrl(url);

/*
            Cabecalho cabecalho = new Cabecalho();
            cabecalho.nome="w3seguranca.credenciais";
            cabecalho.valor = usuarioFechado + "." + senhaFechada + "." + usuarioFechado + "." + senhaFechada;
*/

            Cabecalho[] cabecalhos = new Cabecalho[0];
/*
            cabecalhos[0] = cabecalho;
*/

            rede.setHeaders(cabecalhos);

            //rede.setJson(credenciinputMensagemais);
            rede.setSaida(inputSaida); // mensagem de saída do sistema
            rede.setMensagem(comandoFrase);
            rede.execute("", null, "");
        }
        catch(Exception e)
        {

        }
        finally
        {

        }
    }

}
