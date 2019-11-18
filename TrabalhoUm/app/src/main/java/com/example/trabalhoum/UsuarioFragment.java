package com.example.trabalhoum;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;

import com.example.trabalhoum.R;

import java.util.List;

public class UsuarioFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private List<Usuario> mList;

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_usuarios, container, false);

       // mRecyclerView = view.findViewById(R.id.rv_list);
        mRecyclerView.setHasFixedSize(true);
       // mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener());

        return view;
    }
}
