package com.example.apiweatherretrofit.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apiweatherretrofit.R;
import com.example.apiweatherretrofit.adapter.AdapterCidades;
import com.example.apiweatherretrofit.interfaces.OnClick;
import com.example.apiweatherretrofit.models.ModelCidades;
import com.example.apiweatherretrofit.repository.ConfigRetrofit;
import com.tsuryo.swipeablerv.SwipeLeftRightCallback;
import com.tsuryo.swipeablerv.SwipeableRecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements OnClick {

    Retrofit retrofit;
    Button btnConsultar;
    EditText editTextPesquisar;
    AdapterCidades adapterCidades;
    ModelCidades itemCidade;
    List<ModelCidades> list = new ArrayList<>();
    private SwipeableRecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciandoComponentes();
        iniciandoRecyclerView();
        iniciarChamada();
    }

    private void iniciandoComponentes() {
        btnConsultar = findViewById(R.id.btn_consultar);
        editTextPesquisar = findViewById(R.id.editText_pesquisar);
        recyclerView = findViewById(R.id.reclycer_view);
    }

    private void iniciandoRecyclerView() {
        adapterCidades = new AdapterCidades(this,list, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterCidades);
        recyclerView.setListener(new SwipeLeftRightCallback.Listener() {

            @Override
            public void onSwipedLeft(int position) {
                list.remove(position);
                adapterCidades.notifyItemRemoved(position);
                Toast.makeText(MainActivity.this, getText(R.string.excluir), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSwipedRight(int position) {
                list.remove(position);
                adapterCidades.notifyItemRemoved(position);
                Toast.makeText(MainActivity.this, getText(R.string.excluir), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void iniciarChamada() {
        btnConsultar.setOnClickListener(v -> {
            if (editTextPesquisar.length() == 0){
                Toast.makeText(this, getText(R.string.messagem_vazia), Toast.LENGTH_LONG).show();
            }else {
                recebendoCidades();
            }
        });
    }

    private void recebendoCidades() {
        Call<ModelCidades> call = new ConfigRetrofit(retrofit)
                .getCidades()
                .webService(editTextPesquisar.getText().toString(),
                        "70c7006c98c1a2e32a1cdb95e763da0f",
                        "pt_br",
                        "metric");

        call.enqueue(new Callback<ModelCidades>() {
            @Override
            public void onResponse(Call<ModelCidades> call, Response<ModelCidades> response) {
                if (response.isSuccessful()) {
                    itemCidade = response.body();
                    list.add(itemCidade);
                    adapterCidades.notifyDataSetChanged();
                    editTextPesquisar.setText("");
                }
            }
            @Override
            public void onFailure(Call<ModelCidades> call, Throwable t) {
                Toast.makeText(MainActivity.this, getString(R.string.erro) +t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public void onLongClickNoItem(ModelCidades position) {

    }
}