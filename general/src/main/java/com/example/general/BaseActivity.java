package com.example.general;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public abstract class BaseActivity extends AppCompatActivity {

    protected RecyclerView itemsRecyclerView;
    protected Button addItemButton;
    protected GenericAdapter adapter;
    protected EditText inputItemText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        itemsRecyclerView = findViewById(R.id.itemsRecyclerView);
        addItemButton = findViewById(R.id.addItemButton);
        inputItemText = findViewById(R.id.inputItemText);

        adapter = new GenericAdapter(new ArrayList<>());
        itemsRecyclerView.setAdapter(adapter);
        itemsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = inputItemText.getText().toString();
                if (!item.isEmpty()) {
                    adapter.addItem(item);
                    inputItemText.setText("");
                } else {
                    Toast.makeText(BaseActivity.this, "Please enter text to add", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
