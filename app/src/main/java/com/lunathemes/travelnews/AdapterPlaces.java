package com.lunathemes.travelnews;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterPlaces extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE = 1;
    private final PlacesFragment context;
    private final List<Object> listRecyclerItem;
    private ViewGroup parent;

    public AdapterPlaces(PlacesFragment context, List<Object> listRecyclerItem) {
        this.context = context;
        this.listRecyclerItem = listRecyclerItem;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView city;
        private TextView observation;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);


            city = (TextView) itemView.findViewById(R.id.city_id);
            observation = (TextView) itemView.findViewById(R.id.observation_id);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_places, parent,  false);
        switch (i) {
            case TYPE:

            default:

                View layoutView = LayoutInflater.from(viewGroup.getContext()).inflate(
                        R.layout.list_places, viewGroup, false);

                return new ItemViewHolder((layoutView));
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        int viewType = getItemViewType(i);

        switch (viewType) {
            case TYPE:
            default:

                ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;
                PlacesData placesData = (PlacesData) listRecyclerItem.get(i);

                itemViewHolder.city.setText(placesData.getCity());
                itemViewHolder.observation.setText(placesData.getObservation());
        }

    }

    @Override
    public int getItemCount() {
        return listRecyclerItem.size();
    }
}