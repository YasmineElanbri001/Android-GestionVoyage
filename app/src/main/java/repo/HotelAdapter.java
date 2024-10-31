package repo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.emsi.applicationgv.R;

import java.util.ArrayList;

import model.Hotel;

public class HotelAdapter extends ArrayAdapter<Hotel> {

    private Context mContext;
    private ArrayList<Hotel> mHotelList;

    public HotelAdapter(Context context, ArrayList<Hotel> hotelList) {
        super(context, 0, hotelList);
        mContext = context;
        mHotelList = hotelList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null) {
            listItem = LayoutInflater.from(mContext).inflate(R.layout.item_hotel, parent, false);
        }

        Hotel currentHotel = mHotelList.get(position);

        TextView nomHotel = listItem.findViewById(R.id.text_view_name);
        nomHotel.setText(currentHotel.getName());

        TextView cityTextView = listItem.findViewById(R.id.text_view_city);
        cityTextView.setText("Ville : " + currentHotel.getCity());

        TextView starsTextView = listItem.findViewById(R.id.text_view_stars);
        starsTextView.setText("Etoile(s) : " + currentHotel.getStars());

        Button reserverButton = listItem.findViewById(R.id.reserver);

        reserverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ReserveHotelActivity.class);
                intent.putExtra("nomHotel", nomHotel.getText().toString());
                mContext.startActivity(intent);
            }
        });

        return listItem;
    }
}

