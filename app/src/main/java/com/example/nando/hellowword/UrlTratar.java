package com.example.nando.hellowword;

import android.os.AsyncTask;

import java.net.URL;

/**
 * Created by nando on 15/03/2018.
 */


public class UrlTratar extends android.os.AsyncTask <String, Void, String>
{
    public String organizacaoJSON = "";

    @Override
    protected String doInBackground(String... params)
    {
        OrganizacaoBuscar();

        return organizacaoJSON;
    }

    @Override
    protected void onPostExecute(String result) {
        //showDialog("Downloaded " + result + " bytes");
        organizacaoJSON = result;
    }

    boolean OrganizacaoBuscar()
    {
        boolean retorno = false;
        try
        {
            String urlString = "http://localhost:59177/Service1.svc/OrganizacaoPesquisar";
            urlString = "http://10.0.2.2:59177/Service1.svc/OrganizacaoPesquisar";
            urlString = "http://4evolve-test.sa-east-1.elasticbeanstalk.com/3w4evolve/Service1.svc/OrganizacaoPesquisar";


            java.net.URL url = new java.net.URL(urlString);

            url.openConnection();

            String msg = "Não deu erro";

            java.util.Scanner scn = new java.util.Scanner( url.openStream());
            scn.useDelimiter("\\A");

            if(scn.hasNext())
            {
                String resposta = scn.next();

                int i = 0;

                organizacaoJSON = resposta;
                retorno = true;

            }

        }
        catch (Exception e)
        {

            String msg = e.getMessage();

            int i = 0;

        }

        return retorno;
    }



}

