package textspeech.thezaxis.emandi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class VideoList extends AppCompatActivity {

    RecyclerView recyclerView;
    List<String> youTubeVideos=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        youTubeVideos.add("https://www.youtube.com/embed/WFdzu0c0JFs");
        youTubeVideos.add("https://www.youtube.com/embed/BC7LQRir7L8");
        youTubeVideos.add("https://www.youtube.com/embed/WFdzu0c0JFs");
        youTubeVideos.add("https://www.youtube.com/embed/Hrp-4OiHQ8E");
        youTubeVideos.add("https://www.youtube.com/embed/uVVLbu768Rg");
        youTubeVideos.add("https://www.youtube.com/embed/SOIdYKWyZ88");
        youTubeVideos.add("https://www.youtube.com/embed/tcfMDZybYbo");
        youTubeVideos.add("https://www.youtube.com/embed/RNP53bSTGtc");
        youTubeVideos.add("https://www.youtube.com/embed/XH34m0VY2zM");

        VideoAdapter videoAdapter = new VideoAdapter(youTubeVideos, this);
        recyclerView.setAdapter(videoAdapter);
    }
}
