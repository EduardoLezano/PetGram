package com.atuksystems.petgram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
//import android.widget.Toolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FavoritosActivity extends AppCompatActivity {
    ArrayList<Mascota> mascotasFavoritas;
    RecyclerView rvListaFavoritos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        Toolbar miToolbar = findViewById(R.id.miActionBar);
        setSupportActionBar(miToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvListaFavoritos = findViewById(R.id.rvListaFavoritos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvListaFavoritos.setLayoutManager(llm);

        llenarValores();
        iniciarAdapdator();

    }

    private void llenarValores(){
        mascotasFavoritas = new ArrayList<Mascota>();

        mascotasFavoritas.add(new Mascota("Chester",R.drawable.perro2,0));
        mascotasFavoritas.add(new Mascota("Petter",R.drawable.perro1,0));
        mascotasFavoritas.add(new Mascota("Nicro",R.drawable.gato1,0));
        mascotasFavoritas.add(new Mascota("Shadow",R.drawable.gato2,0));
        mascotasFavoritas.add(new Mascota("Jei",R.drawable.conejo1,0));
    }

    public void iniciarAdapdator(){
        MascotaAdaptador mascotaAdaptador = new MascotaAdaptador(mascotasFavoritas,this);
        rvListaFavoritos.setAdapter(mascotaAdaptador);
    }


}