package com.jackie.flash.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jackie.flash.R;
import com.jackie.flash.models.entities.SocialNetwork;
import com.jackie.flash.viewmodels.SettingsActivityViewModel;

import java.util.List;

public class SocialNetworkAdapter extends RecyclerView.Adapter<SocialNetworkAdapter.ViewHolder> implements View.OnClickListener {

    private List<SocialNetwork> socialNetworkList;
    private SettingsActivityViewModel associateViewModel;

    public SocialNetworkAdapter(List<SocialNetwork> socialNetworkList, SettingsActivityViewModel associateViewModel){
        this.socialNetworkList = socialNetworkList;
        this.associateViewModel = associateViewModel;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View socialNetworkCardView = inflater.inflate(R.layout.item_social_network, parent, false);



        return new ViewHolder(socialNetworkCardView);


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        SocialNetwork socialNetwork = this.socialNetworkList.get(position);


        ImageView socialNetworkIcon = holder.socialNetworkIcon;
        TextView socialNetworkName = holder.socialNetworkName;
        CheckBox socialNetworkIsVisible = holder.socialNetworkIsVisible;


        socialNetworkIcon.setImageResource(socialNetwork.getIcon());
        socialNetworkName.setText(socialNetwork.getName());
        socialNetworkIsVisible.setChecked(socialNetwork.isChecked());
        socialNetworkIsVisible.setTag(position);
        socialNetworkIsVisible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                associateViewModel.changeSocialNetworkChecked(position);
            }
        });





    }

    @Override
    public int getItemCount() {
        return this.socialNetworkList.size();
    }

    @Override
    public void onClick(View view) {
        CheckBox checkBox = (CheckBox) view;
        Integer position = (Integer) checkBox.getTag();


        System.out.println(this.socialNetworkList.get(position));

        Toast.makeText(view.getContext(),  position+ " Selected", Toast.LENGTH_SHORT).show();

    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView socialNetworkIcon;
        public TextView socialNetworkName;
        public CheckBox socialNetworkIsVisible;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            socialNetworkIcon = itemView.findViewById(R.id.social_network_icon);
            socialNetworkName = itemView.findViewById(R.id.social_network_name);
            socialNetworkIsVisible = itemView.findViewById(R.id.social_network_is_visible);

        }
    }


}
