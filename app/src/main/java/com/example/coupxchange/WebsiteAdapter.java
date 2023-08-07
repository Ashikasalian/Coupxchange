package com.example.coupxchange;

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

import com.example.coupxchange.R;
import com.example.coupxchange.Website;

import java.util.ArrayList;
import java.util.List;

public class WebsiteAdapter extends RecyclerView.Adapter<WebsiteAdapter.ViewHolder> {

    private Context context;
    private List<Website> websiteList;
    private List<Website> selectedWebsites;

    public WebsiteAdapter(Context context, List<Website> websiteList) {
        this.context = context;
        this.websiteList = websiteList;
        selectedWebsites = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.website_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Website website = websiteList.get(position);
        holder.websiteName.setText(website.getName());
        holder.websiteIcon.setImageResource(website.getIcon());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox checkBox = v.findViewById(R.id.website_checkbox);
                checkBox.setChecked(!checkBox.isChecked());
                website.setSelected(checkBox.isChecked());
                if (website.isSelected()) {
                    selectedWebsites.add(website);
                } else {
                    selectedWebsites.remove(website);
                }
            }
        });

        holder.checkBox.setOnCheckedChangeListener(null);
        holder.checkBox.setChecked(website.isSelected());
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                website.setSelected(isChecked);
                if (isChecked) {
                    selectedWebsites.add(website);
                } else {
                    selectedWebsites.remove(website);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return websiteList.size();
    }

    public List<Website> getSelectedWebsites() {
        return selectedWebsites;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView websiteIcon;
        private TextView websiteName;
        private CheckBox checkBox;

        public ViewHolder(View itemView) {
            super(itemView);
            websiteIcon = itemView.findViewById(R.id.website_icon);
            websiteName = itemView.findViewById(R.id.website_name);
            checkBox = itemView.findViewById(R.id.website_checkbox);
        }
    }
}
