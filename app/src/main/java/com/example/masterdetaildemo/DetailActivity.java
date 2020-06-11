package com.example.masterdetaildemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class DetailActivity extends AppCompatActivity {

    ItemDetailFragment itemDetailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ItemModel itemModel = (ItemModel) getIntent().getSerializableExtra("item");

        if (savedInstanceState == null) {
            itemDetailFragment = ItemDetailFragment.newInstance(itemModel);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.detailfragmentContainer, itemDetailFragment);
            ft.commit();
        }
    }
}
