package com.example.heavenmeeting;

import android.os.Bundle;

import com.example.heavenmeeting.recylcer_adapter.Meeting;
import com.example.heavenmeeting.recylcer_adapter.MeetingAdapter;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.heavenmeeting.databinding.ActivityMainBinding;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Meeting> meetings;
    private MeetingAdapter adapter;
    private LinearLayoutManager layoutManager;
    private int page = 1;
    private String url = "https://quotable.io/quotes?page=";
    private final int MAX_PAGE = 103;

    private boolean isLoading = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_heaven);

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        meetings = new ArrayList();
        adapter = new MeetingAdapter(meetings);
        recyclerView.setAdapter(adapter);
        intiateRecyclerScrollListener();
        GetMeetings(url + page);
    }

    public void GetMeetings(String url) {
        Ion.with(MainActivity.this)
            .load(url)
            .asJsonObject()
            .setCallback(new FutureCallback<JsonObject>() {
                @Override
                public void onCompleted(Exception e, JsonObject data) {
                    if (e != null) {
                        System.out.println("errrr==================r"+ e);
                        return;
                    }

                    if(meetings.size() > 0 && meetings.get(meetings.size() - 1) == null) {
                        meetings.remove(meetings.size() - 1);
                        adapter.notifyItemRemoved(meetings.size());

                    }

                    JsonArray result = data.get("results").getAsJsonArray();

                    for(int i = 0; i < result.size(); i++) {
                        JsonObject obj = result.get(i).getAsJsonObject();
                        meetings.add(Meeting.ExractMeeting(obj));
                    }
                    meetings.add(null);
                    adapter.notifyDataSetChanged();
                    isLoading = false;
                }
            });
    }

    private  void intiateRecyclerScrollListener() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (!isLoading) {
                    if (layoutManager != null && layoutManager.findLastCompletelyVisibleItemPosition() == meetings.size() - 1 && page < MAX_PAGE) {
                        //bottom of list!
                        page += 1;
                        GetMeetings(url + page);
                        isLoading = true;
                    }
                }
            }
        });
    }

//    private void loadMore() {
//        meetings.add(null);
//        adapter.notifyItemInserted(meetings.size() - 1);
//
//
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                rowsArrayList.remove(rowsArrayList.size() - 1);
//                int scrollPosition = rowsArrayList.size();
//                recyclerViewAdapter.notifyItemRemoved(scrollPosition);
//                int currentSize = scrollPosition;
//                int nextLimit = currentSize + 10;
//
//                while (currentSize - 1 < nextLimit) {
//                    rowsArrayList.add("Item " + currentSize);
//                    currentSize++;
//                }
//
//                recyclerViewAdapter.notifyDataSetChanged();
//                isLoading = false;
//            }
//        }, 2000);
//    }


}