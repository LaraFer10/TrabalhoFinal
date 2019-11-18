package com.example.trabalhoum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UsuariosAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<Usuario> usuariosCadastrados;

    public UsuariosAdapter(Context context, List<Usuario> usuariosCadastrados) {
        this.context = context;
        this.usuariosCadastrados = usuariosCadastrados;
    }

    public UsuariosAdapter() {

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        //Inflando o layout_item dentro de um objeto View
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_usuarios, viewGroup, false);
        //Acessando a nossa classe do ViewHolder e atribuindo o objeto View ao seu construtor
        UsuariosViewHolder exemploVH = new UsuariosViewHolder(view);

        return exemploVH;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {

        UsuariosViewHolder exemploVH  = (UsuariosViewHolder) viewHolder;

        exemploVH.tvItemNome.setText(usuariosCadastrados.get(i).getUser());
        exemploVH.tvItemConteudo.setText(usuariosCadastrados.get(i).getIdade()+", "+usuariosCadastrados.get(i).getProfissao());

        exemploVH.ibItemExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Recuperando o id do item
               // int id = listaValores.get(i).getId();
                //Acessando o banco de dados local do aplicativo
                //BancoDeDados bd = new BancoDeDados(context, 1);
                /*if(bd.remover(id)){
                    //Indicar que o item da posição foi alterado
                    notifyItemChanged(i);
                    //Atualizar a contagem de itens lista no RecyclerView
                    notifyItemRangeChanged(i, getItemCount());
                    //Remover o item também da nossa listaValores
                    listaValores.remove(i);

                    //Exibição de mensagem
                    Toast.makeText(context, "Removido", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(context, "Não foi possível remover", Toast.LENGTH_LONG).show();
                }*/
            }
        });

    }

    @Override
    public int getItemCount() {
        return usuariosCadastrados.size();
    }
}
