package sourcya.osama.com.sourcyavideotask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import sourcya.osama.com.sourcyavideotask.model.Video;

/**
 * Created by osama on 6/12/2017.
 */

public class VideoAdapter extends ArrayAdapter<Video> {

    View row;
    ArrayList<Video> videos;
    Video video;
    Context con;

    VideoAdapter(Context c, ArrayList<Video> videos) {
        super(c, R.layout.activity_main, videos);
        this.con = c;
        this.videos = videos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        row = inflater.inflate(R.layout.video_row, parent, false);

        TextView videoName = (TextView) row.findViewById(R.id.tv_videoName);
        TextView videoType = (TextView) row.findViewById(R.id.tv_videoType);

        video = videos.get(position);

        videoName.setText(video.getVideoName());
        videoType.setText(video.getVideoType());


        return row;

    }

}
