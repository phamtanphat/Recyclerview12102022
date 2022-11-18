package com.example.recyclerview12102022;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by pphat on 11/16/2022.
 */
public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.StoreViewHolder>{

    private List<Store> storeList;
    private OnItemClickListener onItemClickListener;

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
        TextView tvClose, tvName, tvAddress, tvService, tvSaleOff, tvDistance;
        public StoreViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.image_view_food);
            tvClose = itemView.findViewById(R.id.text_view_title_close_time);
            tvName = itemView.findViewById(R.id.text_view_name);
            tvAddress = itemView.findViewById(R.id.text_view_address);
            tvService = itemView.findViewById(R.id.text_view_service);
            tvSaleOff = itemView.findViewById(R.id.text_view_sale_off);
            tvDistance = itemView.findViewById(R.id.text_view_distance);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   if (onItemClickListener != null) {
                       onItemClickListener.onClick(getAdapterPosition());
                   }
                }
            });
        }

        public void bind(Store store) {
            img.setImageResource(store.getImage());
            tvName.setText(store.getName());
            tvAddress.setText(store.getAddress());

            // Service
            if (store.getListServiceType().isEmpty()) {
                tvService.setVisibility(View.GONE);
            } else {
                String service = "";
                if (store.getListServiceType().size() == 1) {
                    service += store.getListServiceType().get(0).toString();
                } else {
                    for (int i = 0; i < store.getListServiceType().size(); i++) {
                        if (i == store.getListServiceType().size() - 1) {
                            service += store.getListServiceType().get(i).toString();
                        } else {
                            service += store.getListServiceType().get(i).toString() + "/ ";
                        }
                    }
                }
                tvService.setText(service);
                tvService.setVisibility(View.VISIBLE);
            }

            // Sale off
            if (store.getSaleOff().isEmpty()) {
                tvSaleOff.setVisibility(View.GONE);
            } else {
                tvSaleOff.setText(store.getSaleOff());
                tvSaleOff.setVisibility(View.VISIBLE);
            }

            // Distance
            if (store.getDistance() == 0) {
                tvDistance.setVisibility(View.GONE);
            } else {
                tvDistance.setText("> " + store.getDistance());
                tvDistance.setVisibility(View.VISIBLE);
            }

            // Time Close
            Calendar calendar = Calendar.getInstance();
            int hourCurrent = calendar.get(Calendar.HOUR_OF_DAY);
            int minutesCurrent = calendar.get(Calendar.MINUTE);
            int millisecondsCurrent = ((hourCurrent * 60) + minutesCurrent) * 60000;

            if (store.getOpenTime() > millisecondsCurrent || store.getCloseTime() <= millisecondsCurrent) {
                long minutes = millisecondToMinus(store.getOpenTime());
                long hour = millisecondToHour(store.getOpenTime());

                tvClose.setText(String.format("Đóng cửa \n Đặt bàn vào lúc \n%s:%s", prefixForTime(hour), prefixForTime(minutes)));
                tvClose.setVisibility(View.VISIBLE);
            } else {
                tvClose.setVisibility(View.GONE);
            }
        }
    }

    private String prefixForTime(long time) {
        return time < 10 ? "0" + time : String.valueOf(time);
    }

    private long millisecondToMinus(long milliseconds) {
        return milliseconds % 3600000 / 60000;
    }

    private long millisecondToHour(long milliseconds) {
        return milliseconds / 3600000;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    interface OnItemClickListener {
        void onClick(int position);
    }
}
