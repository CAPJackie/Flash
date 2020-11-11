package com.example.flash.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flash.R;
import com.example.flash.entities.SocialNetwork;

import java.util.List;

public class SocialNetworkAdapter extends RecyclerView.Adapter<SocialNetworkAdapter.ViewHolder> {

    private List<SocialNetwork> socialNetworkList;

    public SocialNetworkAdapter(List<SocialNetwork> socialNetworkList){
        this.socialNetworkList = socialNetworkList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View socialNetworkCardView = inflater.inflate(R.layout.item_social_network, parent, false);


        ViewHolder viewHolder = new ViewHolder(socialNetworkCardView);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SocialNetwork socialNetwork = this.socialNetworkList.get(position);

        ImageView socialNetworkIcon = holder.socialNetworkIcon;
        TextView socialNetworkName = holder.socialNetworkName;


        socialNetworkIcon.setImageResource(socialNetwork.getIcon());
        socialNetworkName.setText(socialNetwork.getName());
    }

    @Override
    public int getItemCount() {
        return this.socialNetworkList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView socialNetworkIcon;
        public TextView socialNetworkName;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            socialNetworkIcon = itemView.findViewById(R.id.social_network_icon);
            socialNetworkName = itemView.findViewById(R.id.social_network_name);

        }
    }


}
