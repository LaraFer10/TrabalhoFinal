package com.example.trabalhoum;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UsuariosViewHolder extends RecyclerView.ViewHolder {

    TextView tvItemNome, tvItemConteudo;
    ImageButton ibItemExcluir;

    public UsuariosViewHolder(@NonNull View itemView) {
        super(itemView);

        tvItemNome = itemView.findViewById(R.id.tv_item_Nome);
        tvItemConteudo = itemView.findViewById(R.id.tv_item_conteudo);

    }
}
