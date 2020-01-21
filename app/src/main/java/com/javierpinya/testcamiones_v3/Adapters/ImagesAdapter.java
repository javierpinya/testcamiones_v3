package com.javierpinya.testcamiones_v3.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.javierpinya.testcamiones_v3.R;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ViewHolder> {

    private Context context;
    private List<String> images;
    private int layout;

    public ImagesAdapter(Context context, List<String> images, int layout){
        this.context = context;
        this.images = images;
        this.layout = layout;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImagesAdapter.ViewHolder holder, int position) {
        Picasso.get().load(new File(images.get(position))).fit().placeholder(R.drawable.ic_launcher_background).into(holder.image);
        holder.tv.setText(images.get(position));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView image;
        public TextView tv;

        public ViewHolder(View itemView){
            super(itemView);
            this.image = (ImageView)itemView.findViewById(R.id.imageViewLayout);
            this.tv = (TextView)itemView.findViewById(R.id.textView);

        }
    }

}
