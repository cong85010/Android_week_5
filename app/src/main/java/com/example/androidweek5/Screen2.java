package com.example.androidweek5;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Screen2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle bundle = getIntent().getExtras();
        int id = bundle.getInt("id", 1);
        String title = bundle.getString("title", "test1");
        String desciption = bundle.getString("description", "test1");
        String price = bundle.getString("price", "test1");
        System.out.println(title);
        System.out.println(title);
        System.out.println(title);
        TextView tvTitle = (TextView) findViewById(R.id.ids2);
        TextView tvdesciption = (TextView) findViewById(R.id.des2);
        TextView tvprice = (TextView) findViewById(R.id.prices2);
        tvTitle.setText(title);
        tvdesciption.setText(desciption);
        tvprice.setText(price);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        switch (id) {
            case 1:
                imageView.setImageResource(R.drawable.donut_red_1);
                break;
            case 2:
                imageView.setImageResource(R.drawable.tasty_donut_1);
                break;
            case 3:
                imageView.setImageResource(R.drawable.green_donut_1);
                break;
            case 4:
                imageView.setImageResource(R.drawable.donut_red_1);
                break;
            case 5:
                imageView.setImageResource(R.drawable.donut_red_1);
                break;
            case 6:
                imageView.setImageResource(R.drawable.donut_red_1);
                break;
            case 7:
                imageView.setImageResource(R.drawable.donut_red_1);
                break;
            case 8:
                imageView.setImageResource(R.drawable.donut_red_1);
                break;
            default:
                break;
        }
    }
}
