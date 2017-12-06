package sourcya.osama.com.sourcyavideotask;

import android.app.Activity;
import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

/**
 * Created by Osama  on 6/12/2017.
 */

public class VideoViewActivity extends Activity {

    ProgressDialog pDialog;
    VideoView videoview;

    String VideoURL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videoview_main);

        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("videoPath"))
            VideoURL = extras.getString("videoPath");
        else
            Toast.makeText(this, "Error Occurred", Toast.LENGTH_SHORT).show();

        videoview = (VideoView) findViewById(R.id.VideoView);
        pDialog = new ProgressDialog(VideoViewActivity.this);
        pDialog.setTitle("Connecting to video server");
        pDialog.setMessage("Buffering...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);
        pDialog.show();

        try {
            MediaController mediacontroller = new MediaController(
                    VideoViewActivity.this);
            mediacontroller.setAnchorView(videoview);
            Uri video = Uri.parse(VideoURL);
            videoview.setMediaController(mediacontroller);
            videoview.setVideoURI(video);

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
            pDialog.cancel();
            onBackPressed();
        }

        videoview.requestFocus();
        videoview.setOnPreparedListener(new OnPreparedListener() {
            // Close the progress bar and play the video
            public void onPrepared(MediaPlayer mp) {
                pDialog.dismiss();
                videoview.start();
            }
        });

    }

}
