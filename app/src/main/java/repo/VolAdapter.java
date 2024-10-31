package repo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.emsi.applicationgv.R;

import java.util.ArrayList;

import model.Vol;

public class VolAdapter extends ArrayAdapter<Vol> {

    private Context mContext;
    private ArrayList<Vol> mVolList;

    public VolAdapter(Context context, ArrayList<Vol> volList) {
        super(context, 0, volList);
        mContext = context;
        mVolList = volList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null) {
            listItem = LayoutInflater.from(mContext).inflate(R.layout.item_vol, parent, false);
        }

        Vol currentVol = mVolList.get(position);

        TextView company = listItem.findViewById(R.id.company);
        company.setText(currentVol.getCompagnieAerienne());

        TextView depart = listItem.findViewById(R.id.depart);
        depart.setText("Départ : " + currentVol.getDepart());

        TextView hdepart = listItem.findViewById(R.id.hDepart);
        hdepart.setText("Heure départ : " + currentVol.getHeureDepart());

        TextView harrivee = listItem.findViewById(R.id.hArrive);
        harrivee.setText("Heure arrivée : " + currentVol.getArrivee());

        return listItem;
    }
}

