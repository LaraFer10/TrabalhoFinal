package com.example.trabalhoum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UsuariosAdapter extends RecyclerView.Adapter<UsuariosAdapter.UsuariosViewHolder>{
    private ArrayList<Usuario> usuariosCadastrados;

    public UsuariosAdapter(ArrayList<Usuario> u) {
        this.usuariosCadastrados = u;
    }

    @NonNull
    @Override
    public UsuariosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.adapter_lista_usuarios, parent, false);
        return new UsuariosViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuariosViewHolder holder, int position) {
        Usuario user = usuariosCadastrados.get(position);
        holder.tvItemNome.setText(user.getUser());
        holder.tvItemConteudo.setText(user.getProfissao());
    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class UsuariosViewHolder extends RecyclerView.ViewHolder{

        TextView tvItemNome, tvItemConteudo;

        public UsuariosViewHolder(View itemView) {
            super(itemView);
            tvItemNome = itemView.findViewById(R.id.txtNome);
            tvItemConteudo = itemView.findViewById(R.id.txtProf);
        }
    }


}
