package com.example.heavenmeeting.recylcer_adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.heavenmeeting.R;

import java.util.List;

public class MeetingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int VIEW_TYPE_MEETING = 0;
    private final int VIEW_TYPE_LOADING = 1;

    private List<Meeting> meetingList;

    public MeetingAdapter(List<Meeting> meetingList) {
        this.meetingList = meetingList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == VIEW_TYPE_MEETING) {
            View holder = LayoutInflater.from(parent.getContext()).inflate(R.layout.meeting_card, parent, false);
            return new MeetingViewHolder(holder);
        }
        else {
            View holder = LayoutInflater.from(parent.getContext()).inflate(R.layout.loading_row, parent, false);
            return new LoadingViewHolder(holder);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
       if(holder instanceof MeetingViewHolder) {
           PopulateMeetingHolder((MeetingViewHolder) holder, position);
       }
    }

    @Override
    public int getItemCount() {
        return this.meetingList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return this.meetingList.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_MEETING;
    }

    private void PopulateMeetingHolder(MeetingViewHolder holder, int position) {
        holder.getNameTextView().setText(this.meetingList.get(position).getName());
        holder.getDescriptionView().setText(this.meetingList.get(position).getDescription());
        holder.getDateTextView().setText(this.meetingList.get(position).getDate());

        for(int i = 0; i < this.meetingList.get(position).getAttendees().size(); i++) {
            if(i == 0) {
                holder.getFirstAttendeeTextView().setVisibility(View.VISIBLE);
                holder.getFirstAttendeeTextView().setText(this.meetingList.get(position).getAttendees().get(i));

            }
            if(i == 1) {
                holder.getSecondAttendeeTextView().setVisibility(View.VISIBLE);
                holder.getSecondAttendeeTextView().setText(this.meetingList.get(position).getAttendees().get(i));
            }
            if(i == 2) {
                holder.getThirdAttendeeTextView().setVisibility(View.VISIBLE);
                holder.getThirdAttendeeTextView().setText(this.meetingList.get(position).getAttendees().get(i));

            }
        }

    }
}
