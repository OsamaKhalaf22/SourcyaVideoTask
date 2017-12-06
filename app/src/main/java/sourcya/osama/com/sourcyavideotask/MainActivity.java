package sourcya.osama.com.sourcyavideotask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import sourcya.osama.com.sourcyavideotask.model.Video;

/**
 * Created by Osama  on 6/12/2017.
 */

public class MainActivity extends AppCompatActivity {
    ArrayList<Video> videos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVideos();
        ListView videosListView = (ListView) findViewById(R.id.videosListView);

        videosListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent;
                if (videos.get(position).getVidepPath().endsWith(".wmv"))
                    intent = new Intent(MainActivity.this, VLCPlayer.class);
                else
                    intent = new Intent(MainActivity.this, VideoViewActivity.class);
                intent.putExtra("videoPath", videos.get(position).getVidepPath());
                startActivity(intent);
            }
        });

        VideoAdapter videoAdapter = new VideoAdapter(this, videos);
        videosListView.setAdapter(videoAdapter);

    }

    /**
     * Initialize videos array list
     */
    private void initVideos() {
        Video video = new Video();
        video.setVideoName("Big Buck Bunny");
        video.setVidepPath("rtsp://184.72.239.149/vod/mp4:BigBuckBunny_175k.mov");
        video.setVideoType("Kids");
        videos.add(video);

        video = new Video();
        video.setVideoName("Apple Conf.");
        video.setVidepPath("http://qthttp.apple.com.edgesuite.net/1010qwoeiuryfg/sl.m3u8");
        video.setVideoType("Technology");
        videos.add(video);


        video = new Video();
        video.setVideoName("Ray Charles");
        video.setVidepPath("http://www.cybertechmedia.com/samples/raycharles.wmv");
        video.setVideoType("Media");
        videos.add(video);


    }
}
