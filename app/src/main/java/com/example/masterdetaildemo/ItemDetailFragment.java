package com.example.masterdetaildemo;

import android.content.ClipData;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ItemDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ItemDetailFragment extends Fragment {
    private ItemModel itemModel = new ItemModel();
    TextView tvtitle;
    TextView tvbody;

    public static ItemDetailFragment newInstance(ItemModel itemModel) {
        ItemDetailFragment fragment = new ItemDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable("item", itemModel);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            itemModel = (ItemModel) getArguments().getSerializable("item");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item_detail, container, false);
        tvtitle = (TextView) view.findViewById(R.id.title_tv);
        tvbody = (TextView) view.findViewById(R.id.body_tv);
        tvtitle.setText(itemModel.getTitle());
        tvbody.setText(itemModel.getBody());

        return view;
    }
}
