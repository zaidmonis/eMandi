package textspeech.thezaxis.emandi;



import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {
    List<String> youTubeVideosList;
    Context context;
    public VideoAdapter(){}
    public VideoAdapter(List<String> youTubeVideosList, Context context){
        this.context = context;
        this.youTubeVideosList=youTubeVideosList;
    }

    public VideoViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.video_view,parent,false);
        return  new VideoViewHolder(view);
    }
    public void onBindViewHolder(VideoViewHolder holder, final int position){
        String url = youTubeVideosList.get(position);
        url = url.replace("www.youtube", "img.youtube");
        url = url.replace("embed", "vi");
        url = url.concat("/0.jpg");
        //Toast.makeText(context, ""+url, Toast.LENGTH_SHORT).show();
        //holder.videoWeb.loadData(youTubeVideosList.get(position).getVideoUrl(),"text/html","utf-8");
        Glide.with(context).load(url).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(youTubeVideosList.get(position)));
                context.startActivity(intent);
            }
        });
    }

    public int getItemCount(){return youTubeVideosList.size();}

    public  class VideoViewHolder extends RecyclerView.ViewHolder{
        //WebView videoWeb;
        ImageView imageView;
        public VideoViewHolder(View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.videoImageview);
            /*videoWeb=(WebView)itemView.findViewById(R.id.videowebview);
            videoWeb.getSettings().setJavaScriptEnabled(true);
            videoWeb.setWebChromeClient(new WebChromeClient());*/
        }
    }
}
