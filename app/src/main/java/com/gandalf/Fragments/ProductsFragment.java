package com.gandalf.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.gandalf.R;
import com.gandalf.tasks.PegaProdutosTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductsFragment extends Fragment {

    EditText hiddenId;

    public ProductsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_produto, container, false);

        hiddenId = (EditText) view.findViewById(R.id.hiddenIdProd);

        new PegaProdutosTask(ProductsFragment.this).execute();

        return view;
    }

}