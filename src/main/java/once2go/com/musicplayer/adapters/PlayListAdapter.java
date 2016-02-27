package once2go.com.musicplayer.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import once2go.com.musicplayer.R;
import once2go.com.musicplayer.model.Mp3File;

/**
 * Created by once2go on 27.02.16.
 */
public class PlayListAdapter extends RecyclerView.Adapter<PlayListAdapter.PlayListViewHolder> {


    private List<Mp3File> mMp3FileList;

    public PlayListAdapter(List<Mp3File> mp3FileList) {
        mMp3FileList = mp3FileList;
    }

    @Override
    public PlayListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mp3_file_layout, parent, false);
        return new PlayListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PlayListViewHolder holder, int position) {
        holder.fileNameTextView.setText(mMp3FileList.get(position).getFileName());
        holder.fileDataTextView.setText(mMp3FileList.get(position).getFilePath().toString());
    }

    @Override
    public int getItemCount() {
        return mMp3FileList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class PlayListViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView fileNameTextView;
        TextView fileDataTextView;
        TextView fileDurationTextView;
        ImageView fileCoverImageView;

        public PlayListViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.mp3_file_card_view);
            fileNameTextView = (TextView)itemView.findViewById(R.id.mp3_file_name);
            fileDataTextView = (TextView)itemView.findViewById(R.id.mp3_file_data_info);
            fileDurationTextView = (TextView) itemView.findViewById(R.id.mp3_file_duration);
            fileCoverImageView = (ImageView) itemView.findViewById(R.id.mp3_file_cover_image);
        }
    }
}
