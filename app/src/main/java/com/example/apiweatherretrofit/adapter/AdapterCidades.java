package com.example.apiweatherretrofit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apiweatherretrofit.R;
import com.example.apiweatherretrofit.interfaces.OnClick;
import com.example.apiweatherretrofit.models.ModelCidades;

import java.util.List;

public class AdapterCidades extends RecyclerView.Adapter<AdapterCidades.MyHolderCidades> {

    Context context;
    List<ModelCidades> cidadesList;
    OnClick onClick;

    public AdapterCidades(Context _context, List<ModelCidades> _cidadesList, OnClick onClick) {
        this.context = _context;
        this.cidadesList = _cidadesList;
        this.onClick = onClick;
    }

    @NonNull
    @Override
    public MyHolderCidades onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.lista_cidade, parent,false);
        return new MyHolderCidades(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolderCidades holder, int position) {
        ModelCidades itemCidade = cidadesList.get(position);

        holder.city.setText(itemCidade.getCidade());
        holder.country.setText(itemCidade.getSys().getPais());
        holder.temperaturaMin.setText(itemCidade.getMain().getTempMin().toString());
        holder.temperaturaMax.setText(itemCidade.getMain().getTempMax().toString());
        holder.humidade.setText(itemCidade.getMain().getHumidade().toString());

        holder.itemView.setOnClickListener(v -> onClick.onLongClickNoItem(itemCidade));

    }

    @Override
    public int getItemCount() {
        return cidadesList.size();
    }

    public class MyHolderCidades extends RecyclerView.ViewHolder {
        TextView city, country, temperaturaMax, temperaturaMin,humidade;

        public MyHolderCidades(@NonNull View itemView) {
            super(itemView);

            city = itemView.findViewById(R.id.text_city);
            country = itemView.findViewById(R.id.text_country);
            temperaturaMin = itemView.findViewById(R.id.temperatura_min);
            temperaturaMax = itemView.findViewById(R.id.temperatura_max);
            humidade = itemView.findViewById(R.id.humidade);


        }
    }
}
