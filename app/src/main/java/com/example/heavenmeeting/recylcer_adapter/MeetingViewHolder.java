package com.example.heavenmeeting.recylcer_adapter;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.heavenmeeting.R;

import org.json.JSONObject;

public class MeetingViewHolder extends RecyclerView.ViewHolder {
    private TextView nameTextView;
    private TextView descriptionView;
    private TextView dateTextView;

    private  TextView firstAttendeeTextView;
    private  TextView secondAttendeeTextView;
    private  TextView thirdAttendeeTextView;



    public MeetingViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTextView = itemView.findViewById(R.id.text_view_header);
        dateTextView = itemView.findViewById(R.id.text_view_time);
        descriptionView = itemView.findViewById(R.id.text_view_description);
        firstAttendeeTextView = itemView.findViewById(R.id.text_view_first);
        secondAttendeeTextView = itemView.findViewById(R.id.text_view_second);
        thirdAttendeeTextView = itemView.findViewById(R.id.text_view_third);
    }

    public TextView getDateTextView() {
        return dateTextView;
    }

    public TextView getDescriptionView() {
        return descriptionView;
    }

    public TextView getNameTextView() {
        return nameTextView;
    }

    public TextView getFirstAttendeeTextView() {
        return firstAttendeeTextView;
    }

    public TextView getSecondAttendeeTextView() {
        return secondAttendeeTextView;
    }

    public TextView getThirdAttendeeTextView() {
        return thirdAttendeeTextView;
    }
}
