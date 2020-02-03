package com.example.solotask.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.solotask.R;
import com.example.solotask.network.entities.Result;

import java.util.ArrayList;
import java.util.List;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ViewHolder> {
    private Context context;
    private OnFavoriteListener listener;
    private List<Result> resultList = new ArrayList<>();



    public ResultAdapter(Context context, OnFavoriteListener listener) {
        this.context = context;
        this.listener = listener;
    }

    public void setResultList(List<Result> resultList) {
        this.resultList = resultList;
        notifyDataSetChanged();
    }

    public Result getResultAt(int position) {
        return resultList.get ( position );
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_result_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Result currResult = resultList.get(position);
        holder.tvType.setText(currResult.getType());
        holder.tvWebTitle.setText(currResult.getWebTitle());
        Glide.with(context).load(currResult.getFields().getThumbnail())
                .apply(new RequestOptions().override(400,200))
                .into(holder.ivImage);
        if(currResult.isFavorite()){
            holder.cbFavorite.setChecked(true);
        }else {
            holder.cbFavorite.setChecked(false);
        }

    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements CompoundButton.OnCheckedChangeListener {

        private ImageView ivImage;
        private TextView tvType;
        private TextView tvWebTitle;
        private CheckBox cbFavorite;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.iv_image);
            tvType = itemView.findViewById(R.id.tv_type);
            tvWebTitle = itemView.findViewById(R.id.tv_web_title);
            cbFavorite = itemView.findViewById(R.id.cb_favorite);
      cbFavorite.setOnCheckedChangeListener(this);
        }


        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (buttonView.isPressed() && listener != null){
                if (isChecked){
                    listener.onFavoriteInserted(resultList.get(getAdapterPosition()));
                }else {
                    listener.onFavoriteDeleted(resultList.get(getAdapterPosition()));
                }
            }
        }
    }
    public interface OnFavoriteListener{
        void onFavoriteInserted(Result resultItem);

        void onFavoriteDeleted(Result resultItem);
    }
}
