package com.atuksystems.petgram;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pet_cardview,parent,false);

        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);

        holder.tvNombre.setText(mascota.getNombre());
        holder.tvLikes.setText(String.valueOf(mascota.getLikes()));
        holder.imgFoto.setImageResource(mascota.getFoto());

        holder.imageButtonLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "You like: " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                mascota.addLike();
                holder.tvLikes.setText(String.valueOf(mascota.getLikes()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private TextView tvNombre;
        TextView tvLikes;
        ImageView imgFoto;
        ImageButton imageButtonLike;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFoto = itemView.findViewById(R.id.imgFoto);
            tvNombre = itemView.findViewById(R.id.tvNombreCV);
            tvLikes = itemView.findViewById(R.id.tvLikesCV);
            imageButtonLike = itemView.findViewById(R.id.imgButtonLike);

        }
    }
}
