package com.timer.bko.intervalltimer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.timer.bko.intervalltimer.TrackFragment.OnListFragmentInteractionListener;
import com.timer.bko.intervalltimer.item.TrackItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link TrackItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyTrackRecyclerViewAdapter extends RecyclerView.Adapter<MyTrackRecyclerViewAdapter.ViewHolder> {

    private final List<TrackItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyTrackRecyclerViewAdapter(List<TrackItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_track, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.setItem(mValues.get(position));

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mArtistTextView;
        public final TextView mTitleTextView;

        public void setItem(TrackItem mItem) {
            this.mItem = mItem;
            mArtistTextView.setText(mItem.artist);
            mTitleTextView.setText(mItem.title);
        }

        public TrackItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mArtistTextView = (TextView) view.findViewById(R.id.artist);
            mTitleTextView = (TextView) view.findViewById(R.id.title);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTitleTextView.getText() + "'";
        }
    }
}
