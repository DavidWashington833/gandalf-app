package com.example.david.gandalf.tasks;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import com.example.david.gandalf.CategoriaFragment;
import com.example.david.gandalf.R;
import com.example.david.gandalf.WebClient;
import com.example.david.gandalf.adapter.ProdutoAdapter;
import com.example.david.gandalf.models.Produto;
import com.google.gson.Gson;

import java.util.Arrays;

/**
 * Created by Gabriel_Montibeller on 18/11/2017.
 */


public class PegaProdutosCategoriaTask extends AsyncTask<Void, Void, String> {
    private CategoriaFragment context;
    private ViewGroup container;
    private ProgressDialog dialog;

    public PegaProdutosCategoriaTask(CategoriaFragment context, ViewGroup container) {
        this.context = context;
        this.container = container;
    }
    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show(context.getContext(), "Aguarde", "Carregando Produtos...", true, false);
    }

    @Override
    protected String doInBackground(Void... params) {
        WebClient client = new WebClient();
        EditText id = (EditText) context.getActivity().findViewById(R.id.hiddenIdCat);
        String resposta = client.get("http://192.168.15.8:8084/Gandalf/rest/produto/categoria/" + id.getText().toString());
        dialog.dismiss();

        return resposta;
    }

    @Override
    protected void onPostExecute(String resposta) {

        if (!resposta.equals("null")) {
            Produto[] produtos = new Gson().fromJson(resposta, Produto[].class);
            ProdutoAdapter adapter = new ProdutoAdapter(context.getContext(), Arrays.asList(produtos));
            final ListView listView = (ListView) context.getActivity().findViewById(android.R.id.list);

            listView.setAdapter(adapter);
        }

    }

}