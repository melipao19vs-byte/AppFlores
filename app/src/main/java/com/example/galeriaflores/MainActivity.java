package com.example.galeriaflores;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvFlores;
    private LinearLayout layoutConfiguracion;
    private TextView tvUsuarioLogueado;
    private Button btnCerrarSesion;
    private BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvFlores = findViewById(R.id.rvFlores);
        layoutConfiguracion = findViewById(R.id.layoutConfiguracion);
        tvUsuarioLogueado = findViewById(R.id.tvUsuarioLogueado);
        btnCerrarSesion = findViewById(R.id.btnCerrarSesion);
        bottomNavigation = findViewById(R.id.bottomNavigation);

        String usuario = getIntent().getStringExtra("NOMBRE_USUARIO");
        if (usuario != null && !usuario.isEmpty()) {
            tvUsuarioLogueado.setText(usuario);
        }

        rvFlores.setLayoutManager(new GridLayoutManager(this, 2));

        List<Flor> lista = new ArrayList<>();
        lista.add(new Flor("Rosas", "Flores clásicas de pétalos aterciopelados y aroma dulce. Símbolo universal de elegancia y amor.", R.drawable.rosas));
        lista.add(new Flor("Girasoles", "Grandes flores doradas que buscan la luz solar. Irradian alegría, energía y calidez natural.", R.drawable.girasoles));
        lista.add(new Flor("Tulipanes", "Flores primaverales de forma acampanada con colores intensos y porte fino y simétrico.", R.drawable.tulipanes));
        lista.add(new Flor("Margaritas", "Pétalos blancos radiantes con un botón amarillo en el centro. Representan pureza y frescura campestre.", R.drawable.margaritas));

        FlorAdapter adapter = new FlorAdapter(lista);
        rvFlores.setAdapter(adapter);

        bottomNavigation.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.nav_inicio) {
                rvFlores.setVisibility(View.VISIBLE);
                layoutConfiguracion.setVisibility(View.GONE);
                return true;
            } else if (itemId == R.id.nav_configuracion) {
                rvFlores.setVisibility(View.GONE);
                layoutConfiguracion.setVisibility(View.VISIBLE);
                return true;
            }
            return false;
        });

        btnCerrarSesion.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }
}