package com.example.recyclerview12102022;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Created by pphat on 11/16/2022.
 */
public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.StoreViewHolder>{

    private List<Store> storeList;

    public StoreAdapter(List<Store> storeList) {
        this.storeList = storeList;
    }

    @NonNull
    @Override
    public StoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layout_item_store, parent, false);
        return new StoreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreViewHolder holder, int position) {
        holder.bind(storeList.get(position));
    }

    @Override
    public int getItemCount() {
        if (storeList.isEmpty()) {
            return 0;
        }
        return storeList.size();
    }

    class StoreViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView tvClose, tvName, tvAddress, tvCategory, tvSaleOff, tvDistance;
        public StoreViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.image_view_food);
            tvClose = itemView.findViewById(R.id.text_view_title_close_time);
            tvName = itemView.findViewById(R.id.text_view_name);
            tvAddress = itemView.findViewById(R.id.text_view_address);
            tvCategory = itemView.findViewById(R.id.text_view_category);
            tvSaleOff = itemView.findViewById(R.id.text_view_sale_off);
            tvDistance = itemView.findViewById(R.id.text_view_distance);
        }

        public void bind(Store store) {
            img.setImageResource(store.getImage());
            tvName.setText(store.getName());
            tvAddress.setText(store.getAddress());

        }
    }
}
