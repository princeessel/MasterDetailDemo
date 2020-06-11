package com.example.masterdetaildemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ItemListActivity extends AppCompatActivity implements ItemListFragment.OnListItemSelectedListener {

    private ItemModel itemModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void onItemSelected(ItemModel itemModel) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("item", itemModel);
        startActivity(intent);
    }
}
