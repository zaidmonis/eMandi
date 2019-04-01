package textspeech.thezaxis.emandi;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private XmlPullParserFactory xmlFactoryObject;
    private XmlPullParser myparser;
    private Button sampleButton;
    private TextView sampleText;
    private RequestQueue mQueue;
    private GridView mandiGridView;
    List<Product> productList;

    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        /*sampleText = getActivity().findViewById(R.id.sample_text);
        sampleButton = getActivity().findViewById(R.id.sample_button);
        mQueue = Volley.newRequestQueue(getActivity());
        sampleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        });*/
    }

    private void jsonParse() {
        String url = " https://api.data.gov.in/resource/9ef84268-d588-465a-a308-a864a43d0070?api-key=579b464db66ec23bdd000001cdd3946e44ce4aad7209ff7b23ac571b&format=json&filters[district]=Meerut ";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("records");
                            Toast.makeText(getActivity(), ""+jsonArray.length(), Toast.LENGTH_SHORT).show();

                            for(int i = 0; i<jsonArray.length() ; i++){
                                JSONObject record = jsonArray.getJSONObject(i);
                                String timeStamp = record.getString("timestamp");
                                String state = record.getString("state");
                                String district = record.getString("district");
                                String market = record.getString("market");
                                String commodity = record.getString("commodity");
                                String variety = record.getString("variety");
                                String arrival_date = record.getString("arrival_date");
                                String min_price = record.getString("min_price");
                                String max_price = record.getString("max_price");
                                String modal_price = record.getString("modal_price");
                                Product product = new Product(timeStamp, state, district, market, commodity, variety, arrival_date, min_price, max_price, modal_price);
                                productList.add(product);
                                //sampleText.append(district +", " +market + ", " +commodity +", " +modal_price +"\n\n");
                            }
                            ProductAdapter adapter = new ProductAdapter(getActivity(), productList);
                            mandiGridView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), ""+ error, Toast.LENGTH_SHORT).show();
            }
        });
        mQueue.add(request);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT).show();


        try {
            xmlFactoryObject = XmlPullParserFactory.newInstance();
            myparser = xmlFactoryObject.newPullParser();
        } catch (Exception e) {
            e.printStackTrace();
        }




        //myparser.setInput("sds.xml", null);



        View view = inflater.inflate(R.layout.fragment_home, container, false);

        sampleText = view.findViewById(R.id.sample_text);
        sampleButton = view.findViewById(R.id.sample_button);
        sampleButton.setVisibility(View.VISIBLE);
        mandiGridView = view.findViewById(R.id.mandi_grid_view);
        mandiGridView.setNumColumns(1);
        productList = new ArrayList<>();
        mQueue = Volley.newRequestQueue(getActivity());
        sampleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sampleButton.setVisibility(View.GONE);
                sampleText.setVisibility(View.GONE);
                jsonParse();
            }
        });


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        /*if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
