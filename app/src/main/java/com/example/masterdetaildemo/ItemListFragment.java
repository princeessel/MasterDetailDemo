package com.example.masterdetaildemo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class ItemListFragment extends Fragment {
    private ArrayAdapter<ItemModel> adapter;
    private ListView listView;
    OnListItemSelectedListener listener;

    public interface OnListItemSelectedListener {
        void onItemSelected(ItemModel item);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<ItemModel> itemModels = ItemModel.getItems();
        adapter = new ArrayAdapter<ItemModel>(getActivity(), android.R.layout.simple_list_item_activated_1, itemModels);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
        listView = view.findViewById(R.id.list_items);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemModel item = adapter.getItem(position);
                listener.onItemSelected(item);
            }
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof OnListItemSelectedListener) {
            listener = (OnListItemSelectedListener) context;
        } else {
            throw new ClassCastException(
                    context.toString() + " must implement ItemsListFragment.OnListItemSelectedListener");
        }
    }
}
