package com.example.david.gandalf;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.david.gandalf.models.Produto;
import com.example.david.gandalf.tasks.LojaTask;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class LojaFragment extends Fragment {

    private ViewGroup mensagens;

    public ImageView imgP;
    public TextView nomeP, precoP;

    private RecyclerView recyclerView;
    private CustomAdapter adapter;
    private List<Produto> data_list;


    public LojaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_loja, container, false);
        new LojaTask(LojaFragment.this).execute();

        recyclerView = (RecyclerView) view.findViewById(R.id.recyvler_view_produtos);
        data_list = new ArrayList<>();

        adapter = new CustomAdapter(this, data_list);
        recyclerView.setAdapter(adapter);



        nomeP = (TextView) view.findViewById(R.id.txtNomeProd);
        precoP = (TextView) view.findViewById(R.id.txtPreco);
        imgP = (ImageView) view.findViewById(R.id.imagemProd);


        mensagens = (ViewGroup) view.findViewById(R.id.container);

        addItem(nomeP, precoP);

        return view;
    }

    private void addItem(TextView nomeProd, TextView precoP) {

        CardView cardView = (CardView) LayoutInflater.from(getActivity()).inflate(R.layout.cardview_pagina_carrinho, mensagens, false);

        TextView nome = (TextView) cardView.findViewById(R.id.txtNomeProd);
        nome.setText((CharSequence) nomeProd);

        TextView preco = (TextView) cardView.findViewById(R.id.txtPreco);
        preco.setText((CharSequence) precoP);

//        mensagens.addView(cardView);

    }

}