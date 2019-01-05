package com.example.nando.hellowword;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void OrganizacaoSelecionar(View view) {
        Intent i = new Intent(this, OrganizacaoSelecionarActivity.class);
        startActivity(i);
    }

    public void RecycleviewListar(View view) {
        Intent i = new Intent(this, MainRecycleActivity.class);
        startActivity(i);
    }

    public void UsuarioListar(View view) {
        Intent i = new Intent(this, UsuarioSelecionar.class);
        startActivity(i);
    }

    public void IotListar(View view) {
        Intent i = new Intent(this, IotManagerActivity.class);
        startActivity(i);
    }


}
