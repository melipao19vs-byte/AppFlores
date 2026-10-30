package com.example.galeriaflores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.List;

public class FlorAdapter extends RecyclerView.Adapter<FlorAdapter.FlorViewHolder> {

    private List<Flor> listaFlores;

    public FlorAdapter(List<Flor> listaFlores) {
        this.listaFlores = listaFlores;
    }

    @NonNull
    @Override
    public FlorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_flor, parent, false);
        return new FlorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlorViewHolder holder, int position) {
        Flor flor = listaFlores.get(position);
        holder.tvNombreFlor.setText(flor.getNombre());
        holder.tvDescripcionFlor.setText(flor.getDescripcion());


        Picasso.with(holder.itemView.getContext())
                .load(flor.getImagenResId())
                .into(holder.imgFlor);
    }

    @Override
    public int getItemCount() {
        return listaFlores.size();
    }

    public static class FlorViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imgFlor;
        TextView tvNombreFlor, tvDescripcionFlor;

        public FlorViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFlor = itemView.findViewById(R.id.imgFlor);
            tvNombreFlor = itemView.findViewById(R.id.tvNombreFlor);
            tvDescripcionFlor = itemView.findViewById(R.id.tvDescripcionFlor);
        }
    }
}