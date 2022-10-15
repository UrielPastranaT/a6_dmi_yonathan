package com.example.recyclerviewyupt;

import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    ArrayList<String> listDatos;
    RecyclerView recycler;

    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recycler = (RecyclerView)findViewById(R.id.recyclerId);

        if(this.recycler.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            recycler.setLayoutManager(new GridLayoutManager(this, 2));
        }
        else if(this.recycler.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            recycler.setLayoutManager(new GridLayoutManager(this, 4));
        }

        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(MainActivity.this, R.dimen.spacingGridRecyclerView);
        recycler.addItemDecoration(itemDecoration);

        listDatos = new ArrayList<String>();

        for (int i=0; i<=50; i++)
        {
            listDatos.add("Dato No." + i + "");
        }

        AdapterDatos adapter = new AdapterDatos(listDatos);
        recycler.setAdapter(adapter);
    }
}