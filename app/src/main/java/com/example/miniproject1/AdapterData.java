package com.example.miniproject1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {
    List<String> listdata;
    List<String> waktuJarak;
    List<String> biaya;
    List<String> estimasi;
    List<Integer> image;
    LayoutInflater inflater;

    private final rv_interface recyclerViewInterface;

    public AdapterData(Context context, List<String> listdata, List<String> waktuJarak, List<Integer> image, List<String> biaya, List<String> estimasi, rv_interface recyclerViewInterface) {
        this.listdata = listdata;
        this.waktuJarak = waktuJarak;
        this.estimasi = estimasi;
        this.biaya = biaya;
        this.image = image;
        this.inflater = LayoutInflater.from(context);

        this.recyclerViewInterface = recyclerViewInterface;


    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_data, parent,false);
        return new HolderData(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        holder.txtData.setText(listdata.get(position));
        holder.waktuJarak.setText(waktuJarak.get(position));
        holder.biaya.setText(biaya.get(position));
        holder.estimasi.setText(estimasi.get(position));
        holder.images.setImageResource(image.get(position));

    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public class HolderData extends RecyclerView.ViewHolder{
        TextView txtData;
        TextView waktuJarak;
        TextView biaya;
        TextView estimasi;
        ImageView images;

        public HolderData(@NonNull View itemView, rv_interface recyclerViewInterface) {
            super(itemView);

            txtData = itemView.findViewById(R.id.restaurant);
            waktuJarak = itemView.findViewById(R.id.waktuJarak);
            biaya = itemView.findViewById(R.id.biaya);
            estimasi = itemView.findViewById(R.id.estimasi);
            images = itemView.findViewById(R.id.image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterface != null){
                        int pos = getBindingAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });

        }
    }
}
