package textspeech.thezaxis.emandi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Vector;

public class video_list extends AppCompatActivity {

    RecyclerView recyclerView;
    Vector<YouTubeVideos> youTubeVideos=new Vector<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        youTubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Sb7DI7EjkXM\" frameborder=\"0\" allowfullscreen></iframe>") );
        youTubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/WFdzu0c0JFs\" frameborder=\"0\" allowfullscreen></iframe>") );
        youTubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/BC7LQRir7L8\" frameborder=\"0\" allowfullscreen></iframe>") );
        youTubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/WFdzu0c0JFs\" frameborder=\"0\" allowfullscreen></iframe>") );
        youTubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Hrp-4OiHQ8E\" frameborder=\"0\" allowfullscreen></iframe>") );
        youTubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/uVVLbu768Rg\" frameborder=\"0\" allowfullscreen></iframe>") );
        youTubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/SOIdYKWyZ88\" frameborder=\"0\" allowfullscreen></iframe>") );
        youTubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/tcfMDZybYbo\" frameborder=\"0\" allowfullscreen></iframe>") );
        youTubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/RNP53bSTGtc\" frameborder=\"0\" allowfullscreen></iframe>") );
        youTubeVideos.add( new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/XH34m0VY2zM\" frameborder=\"0\" allowfullscreen></iframe>") );

        VideoAdapter videoAdapter = new VideoAdapter(youTubeVideos);
        recyclerView.setAdapter(videoAdapter);
    }
}
