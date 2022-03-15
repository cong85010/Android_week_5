package com.example.androidweek5;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.InputEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class CustomListViewActivity extends AppCompatActivity {
    private List<Product> productList;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        listView = (ListView) findViewById(R.id.idListView);
        productList = new ArrayList<>();
        productList.add(new Product(1, "Tasty Donut", "Spicy tasty donut family", 10.0));
        productList.add(new Product(2, "Pink Donut", "Spicy tasty donut family", 12.0));
        productList.add(new Product(3, "Floating Donut", "Spicy tasty donut family", 13.0));
        productList.add(new Product(4, "Floating Donut", "Spicy tasty donut family", 15.0));
        productList.add(new Product(5, "Pink Donut", "Spicy tasty donut family", 15.0));
        productList.add(new Product(6, "Floating Donut", "Spicy tasty donut family", 15.0));
        productList.add(new Product(7, "Pink Donut", "Spicy tasty donut family", 15.0));


        ProductAdapter adapter = new ProductAdapter(this, R.layout.item_listview, productList);
        listView.setAdapter(adapter);
        Button buttonDonut = (Button) findViewById(R.id.donut);
        Button buttonPinkDonut = (Button) findViewById(R.id.pinkDonut);
        Button buttonFloating = (Button) findViewById(R.id.floating);

        EditText inputEvent = (EditText) findViewById(R.id.namefood);

        inputEvent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable text) {
                adapter.filterByText(text);
            }
        });

        buttonDonut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.allDonut();
                setActiveButton(buttonDonut, buttonPinkDonut, buttonFloating);
            }

        });
        buttonPinkDonut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.filterPinkDonut();
                setActiveButton(buttonPinkDonut, buttonDonut, buttonFloating);

            }
        });
        buttonFloating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.filterFloating();
                setActiveButton( buttonFloating, buttonDonut, buttonPinkDonut);

            }
        });

    }
    public void setActiveButton(Button buttonActive, Button btn1, Button btn2) {
        buttonActive.setBackgroundColor(Color.BLUE);
        buttonActive.setTextColor(Color.WHITE);
        btn1.setBackgroundColor(Color.parseColor("#D1CBCB"));
        btn1.setTextColor(Color.BLACK);
        btn2.setTextColor(Color.BLACK);
        btn2.setBackgroundColor(Color.parseColor("#D1CBCB"));
    }

}
