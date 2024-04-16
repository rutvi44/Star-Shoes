package com.example.group6_prog3210_finalproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.ViewHolder> {

    private List<CartItem> cartItemList;
    private DBHandler dbHandler;

    public CartListAdapter(List<CartItem> cartItemList, DBHandler dbHandler) {
        this.cartItemList = cartItemList;
        this.dbHandler = dbHandler;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CartItem cartItem = cartItemList.get(position);
        holder.title.setText(cartItem.getTitle());
        holder.feeEachItem.setText(String.valueOf(cartItem.getFee()));
        holder.totalEachItem.setText(String.valueOf(Math.round((cartItem.getNumberInCart() * cartItem.getFee()) * 100) / 100));
        holder.num.setText(String.valueOf(cartItem.getNumberInCart()));

        String picName = cartItem.getPic();
        if (picName != null) {
            int drawableResourceId = holder.itemView.getContext().getResources()
                    .getIdentifier(picName, "drawable", holder.itemView.getContext().getPackageName());
            Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.pic);
        } else {
            // Handle the case where picName is null, e.g., set a default image
            holder.pic.setImageDrawable(null); // or any other action you want to take
        }

        AtomicInteger currentQuantity = new AtomicInteger(cartItem.getNumberInCart());
        holder.txtAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int quantity = currentQuantity.incrementAndGet();
                cartItem.setNumberInCart(quantity);
                holder.num.setText(String.valueOf(quantity));
                holder.totalEachItem.setText(String.valueOf(Math.round((quantity * cartItem.getFee()) * 100) / 100));
            }
        });

        holder.txtMinus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int quantity = currentQuantity.get();
                if (quantity > 0) {
                    quantity--;
                    cartItem.setNumberInCart(quantity);
                    holder.num.setText(String.valueOf(quantity));
                    holder.totalEachItem.setText(String.valueOf(Math.round((quantity * cartItem.getFee()) * 100) / 100));
                    // You may want to update the cart in the database here
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return cartItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView title, feeEachItem, txtMinus, txtAdd, totalEachItem, num;
        ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.titleText);
            feeEachItem = itemView.findViewById(R.id.feeEachItem);
            txtMinus = itemView.findViewById(R.id.textViewminus);
            txtAdd = itemView.findViewById(R.id.textViewAdd);
            totalEachItem = itemView.findViewById(R.id.totalEachItem);
            num = itemView.findViewById(R.id.textViewNumber);
            pic = itemView.findViewById(R.id.picCart);

        }
    }
}
