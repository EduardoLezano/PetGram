package com.atuksystems.petgram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
//import android.widget.Toolbar;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvListaMascotas;
    private ArrayList<Mascota> mascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miToolbar = findViewById(R.id.miActionBar);
        setSupportActionBar(miToolbar);

        rvListaMascotas = findViewById(R.id.rvListaMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvListaMascotas.setLayoutManager(llm);

        llenarValores();
        iniciarAdapdator();
    }

    private void llenarValores(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Chester",R.drawable.perro2,0));
        mascotas.add(new Mascota("Petter",R.drawable.perro1,0));
        mascotas.add(new Mascota("Nicro",R.drawable.gato1,0));
        mascotas.add(new Mascota("Shadow",R.drawable.gato2,0));
        mascotas.add(new Mascota("Jei",R.drawable.conejo1,0));
        mascotas.add(new Mascota("Lucas",R.drawable.conejo2,0));

    }

    public void iniciarAdapdator(){
        MascotaAdaptador mascotaAdaptador = new MascotaAdaptador(mascotas,this);
        rvListaMascotas.setAdapter(mascotaAdaptador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_options,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_favoritos:
                Intent intent = new Intent(this, FavoritosActivity.class);
                startActivity(intent);
                break;
            default:
                Toast.makeText(this, "Menú desconocido", Toast.LENGTH_SHORT).show();
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}