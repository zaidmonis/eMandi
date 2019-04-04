package textspeech.thezaxis.emandi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class BuyAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<Sell> productList;

    public BuyAdapter(Context context, List<Sell> productList) {
        this.context = context;
        this.productList = productList;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.buy_item, null);


        holder.cropNameTV = rowView.findViewById(R.id.crop_name_tv);
        holder.areaTV = rowView.findViewById(R.id.area_tv);
        holder.rateTV = rowView.findViewById(R.id.rate_tv);
        holder.priceTV = rowView.findViewById(R.id.price_tv);

        Sell sell = productList.get(position);

        holder.cropNameTV.setText(sell.getName());
        holder.areaTV.setText(String.valueOf(sell.getArea()));
        holder.rateTV.setText(String.valueOf(sell.getRate()));
        holder.priceTV.setText(String.valueOf(sell.getPrice()));


        return null;
    }
    class Holder {
        RelativeLayout itemLay;
        TextView cropNameTV, areaTV, rateTV, priceTV;
    }
}
