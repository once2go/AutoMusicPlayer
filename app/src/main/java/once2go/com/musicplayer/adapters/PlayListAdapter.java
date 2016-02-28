package once2go.com.musicplayer.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import once2go.com.musicplayer.MusicPlayerApplication;
import once2go.com.musicplayer.R;
import once2go.com.musicplayer.controller.ControlsActionListener;
import once2go.com.musicplayer.model.Mp3File;
import once2go.com.musicplayer.model.Mp3Metadata;
import once2go.com.musicplayer.utill.AnimationUtils;

/**
 * Created by once2go on 27.02.16.
 */
public class PlayListAdapter extends RecyclerView.Adapter<PlayListAdapter.PlayListViewHolder> {


    private List<Mp3File> mMp3FileList;
    private ControlsActionListener controlsActionListener;
    private int mPreviousPosition;

    public PlayListAdapter(List<Mp3File> mp3FileList) {
        mMp3FileList = mp3FileList;
        controlsActionListener = MusicPlayerApplication.getInstance().getPlayerController().getUiActionsListener();
    }

    @Override
    public PlayListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mp3_file_layout, parent, false);
        return new PlayListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final PlayListViewHolder holder, int position) {
        Mp3Metadata meta =  mMp3FileList.get(position).getMp3Metadata();
        holder.fileNameTextView.setText(meta.getArtist());
        if (meta.getEmbededPic() != null) {
            holder.fileCoverImageView.setImageBitmap(meta.getEmbededPic());
        }
        holder.fileDurationTextView.setText(meta.getDuration());
        holder.fileDataTextView.setText(meta.getTitle());
        ((View) holder.fileNameTextView.getParent()).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controlsActionListener.onPlay(mMp3FileList.get(holder.getAdapterPosition()).getFilePath());
            }
        });

        if (position > mPreviousPosition) {
            AnimationUtils.animateSunblind(holder, true);
        } else {
            AnimationUtils.animateSunblind(holder, false);

        }
        mPreviousPosition = position;
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
            cardView = (CardView) itemView.findViewById(R.id.mp3_file_card_view);
            fileNameTextView = (TextView) itemView.findViewById(R.id.mp3_file_name);
            fileDataTextView = (TextView) itemView.findViewById(R.id.mp3_file_data_info);
            fileDurationTextView = (TextView) itemView.findViewById(R.id.mp3_file_duration);
            fileCoverImageView = (ImageView) itemView.findViewById(R.id.mp3_file_cover_image);
        }
    }
}
