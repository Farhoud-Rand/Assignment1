package com.example.assignment1;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private List<Category> categoryList;

    public CategoryAdapter(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Category category = categoryList.get(position);
        holder.categoryName.setText(category.getName());
        holder.setShape(category.getShape());
        // Show or hide the items based on the isExpanded flag
        if (category.isExpanded()) {
            holder.itemList.setVisibility(View.VISIBLE);

            // Set up the adapter for the item list RecyclerView
            ItemAdapter itemAdapter = new ItemAdapter(category.getItemList());
            holder.itemList.setAdapter(itemAdapter);
        } else {
            holder.itemList.setVisibility(View.GONE);
        }

        // Set up an OnClickListener on the category name TextView
        // Handle the click event to toggle the item visibility
        holder.itemView.setOnClickListener(v -> {
            category.setExpanded(!category.isExpanded());
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView categoryName;
        private RecyclerView itemList;
        private ImageView shape;

        public ViewHolder(View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.category_name);
            shape = itemView.findViewById(R.id.shapeImage);
            itemList = itemView.findViewById(R.id.item_list);
            itemList.setLayoutManager(new LinearLayoutManager(itemView.getContext()));
        }

        public void setShape(Drawable drawable) {
            this.shape.setImageDrawable(drawable);
        }
    }
}
