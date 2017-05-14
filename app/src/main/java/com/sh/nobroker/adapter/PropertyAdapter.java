package com.sh.nobroker.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sh.model.Property;
import com.sh.nobroker.R;
import com.sh.utils.Const;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by shanaulhaque on 13/05/17.
 */

public class PropertyAdapter extends RecyclerView.Adapter<PropertyAdapter.PropertyViewHolder> {

    private static final String TAG = PropertyAdapter.class.getSimpleName();

   private Context context;

    private List<Property> propertiesList;

    public class PropertyViewHolder extends RecyclerView.ViewHolder {
        public TextView title,address, rent, furnishing,area, bathroom;
        public ImageView propertyImage;
        public PropertyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.tv_property_title);
            address = (TextView) view.findViewById(R.id.tv_property_address);
            rent = (TextView) view.findViewById(R.id.tv_rent);
            furnishing = (TextView) view.findViewById(R.id.tv_furnising);
            area = (TextView) view.findViewById(R.id.tv_area);
            bathroom = (TextView) view.findViewById(R.id.tv_bathroom);
            propertyImage = (ImageView) view.findViewById(R.id.iv_property_image);
        }
    }


    public PropertyAdapter(List<Property> propertiesList) {
        this.propertiesList = propertiesList;
    }

    @Override
    public PropertyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.property_row_list_item, parent, false);
        context = parent.getContext();
        return new PropertyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PropertyViewHolder holder, int position) {
        Property property = propertiesList.get(position);
        holder.title.setText(property.getTitle());
        holder.rent.setText(context.getString(R.string.Rs).toString() +" "+ NumberFormat.getNumberInstance(Locale.US).format(property.getRent()));
        holder.furnishing.setText(property.getFurnishingDesc() + " furnished");
        if(property.getImageAddress() != null && property.getImageAddress().size() > 0) {
            String imageUrl = property.getImageAddress().get(0);
            String folder[] = imageUrl.split("_");
            String url = Const.imageDownloadURL  + folder[0] + "/" + imageUrl;
           // Log.i(TAG, url);

            Picasso.with(context)
                    .load(url)
                    .placeholder(R.drawable.autorenew)
                    .error(R.drawable.close)
                    .resize(350,200)
                    .into(holder.propertyImage);

        }
        String addressStr = "at " + property.getAddress().getStreet() + ", " + property.getAddress().getCity();
        holder.address.setText(addressStr);
        holder.area.setText(Integer.toString(property.getPropertySize()) + " Sq ft.");
        holder.bathroom.setText(Integer.toString(property.getNoOfBathrooms()) + " Bathroom(s)");

    }

    @Override
    public int getItemCount() {
        return propertiesList.size();
    }
}
