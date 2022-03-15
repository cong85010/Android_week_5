package com.example.androidweek5;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends BaseAdapter {
    private Context context;
    private int idLayout;
    private List<Product> listProduct;
    private List<Product> listProductFilter;
    private int positionSelect = -1;

    public ProductAdapter(Context context, int idLayout, List<Product> listProduct) {
        this.context = context;
        this.idLayout = idLayout;
        this.listProduct = listProduct;
        listProductFilter = listProduct;
    }

    @Override
    public int getCount() {
        if (listProductFilter.size() != 0 && !listProductFilter.isEmpty()) {
            return listProductFilter.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(idLayout, parent, false);
        }

        TextView txTitle = (TextView) convertView.findViewById(R.id.idTitle);
        TextView description = (TextView) convertView.findViewById(R.id.idDescription);
        TextView price = (TextView) convertView.findViewById(R.id.idPrice);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.logo);
        final ConstraintLayout linearLayout = (ConstraintLayout) convertView.findViewById(R.id.idConstraint);
        final com.example.androidweek5.Product product = listProductFilter.get(position);

        if (listProductFilter != null && !listProductFilter.isEmpty()) {
            txTitle.setText(product.getTitle());
            description.setText(product.getDescription());
            price.setText(product.getPrice()+"$");

            int idPro = product.getId();
            switch (idPro) {
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
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Screen2.class);
                Bundle bundle = new Bundle();
                bundle.putInt("id", product.getId());
                bundle.putString("title", product.getTitle());
                bundle.putString("description", product.getDescription());
                bundle.putString("price", product.getPrice()+"$");
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        if (positionSelect == position) {
            linearLayout.setBackgroundColor(Color.GRAY);
        } else {
            linearLayout.setBackgroundColor(Color.WHITE);
        }
        return convertView;
    }

    public void filterDonut(String filter) {
        listProductFilter = new ArrayList<>();
        for(Product product: listProduct) {
            if(product.getTitle().toLowerCase().indexOf(filter) != -1) {
                listProductFilter.add(product);
            }
        }
        notifyDataSetChanged();
    }
    public void filterPinkDonut () {
        filterDonut("pink");
    }

    public void filterFloating() {
        filterDonut("floating");
    }
    public void allDonut() {
        listProductFilter = listProduct;
        notifyDataSetChanged();
    }

    public void filterByText(Editable text) {
        listProductFilter = new ArrayList<>();
        for(Product product: listProduct) {
            if(product.getTitle().toLowerCase().indexOf(text.toString()) != -1) {
                listProductFilter.add(product);
            }
        }
        notifyDataSetChanged();
    }
}
