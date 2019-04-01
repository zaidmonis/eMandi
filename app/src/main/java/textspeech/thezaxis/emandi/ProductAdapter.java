package textspeech.thezaxis.emandi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends BaseAdapter {


    private Context context;
    private LayoutInflater inflater;
    private List<Product> productList;

    public ProductAdapter(Context context, List<Product> productList) {
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
        final Holder holder = new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.mandi_item, null);
        holder.stateTV = rowView.findViewById(R.id.state_tv);
        holder.districtTV = rowView.findViewById(R.id.district_tv);
        holder.marketTv = rowView.findViewById(R.id.market_tv);
        holder.commodityTV = rowView.findViewById(R.id.commodity_tv);
        holder.modalPriceTV = rowView.findViewById(R.id.modal_price_tv);
        holder.arrivalDateTV = rowView.findViewById(R.id.arrival_date_tv);
        Product product = productList.get(position);

        holder.stateTV.setText(product.getState());
        holder.districtTV.setText(product.getDistrict());
        holder.marketTv.setText(product.getMarket());
        holder.commodityTV.setText(product.getCommodity());
        holder.modalPriceTV.setText(product.getModalPrice());
        holder.arrivalDateTV.setText(product.getArrival_Date());






        return rowView;
    }
    public class Holder {
        RelativeLayout itemLay;
        TextView stateTV, districtTV, marketTv, commodityTV, modalPriceTV, arrivalDateTV;
    }
}
