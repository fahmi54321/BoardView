package com.android.a88boardview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.allyants.boardview.BoardView;
import com.allyants.boardview.SimpleBoardAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<SimpleBoardAdapter.SimpleColumn> data = new ArrayList<>();
    ArrayList<String> list = new ArrayList<>();
    BoardView boardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boardView = findViewById(R.id.boardView);

        //create item
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");
        list.add("Item 4");

        data.add(new SimpleBoardAdapter.SimpleColumn("Column 1",list));
        data.add(new SimpleBoardAdapter.SimpleColumn("Column 2",list));
        data.add(new SimpleBoardAdapter.SimpleColumn("Column 3",list));

        SimpleBoardAdapter simpleBoardAdapter = new SimpleBoardAdapter(this,data);

        boardView.setAdapter(simpleBoardAdapter);

        boardView.setOnItemClickListener(new BoardView.ItemClickListener() {
            @Override
            public void onClick(View view, int column_pos, int item_pos) {
                Toast.makeText(MainActivity.this, ""+data.get(column_pos).items.get(item_pos), Toast.LENGTH_SHORT).show();
            }
        });
        boardView.setOnHeaderClickListener(new BoardView.HeaderClickListener() {
            @Override
            public void onClick(View view, int i) {
                Toast.makeText(MainActivity.this, ""+data.get(i).header, Toast.LENGTH_SHORT).show();
            }
        });

    }
}