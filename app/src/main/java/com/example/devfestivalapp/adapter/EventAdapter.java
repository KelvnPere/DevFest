package com.example.devfestivalapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.devfestivalapp.R;
import com.example.devfestivalapp.model.Event;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.CustomViewHolder> {
    private List<Event> repositories;

    public EventAdapter(List<Event> repositories) {
        this.repositories = repositories;
    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_program_item, parent, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Event event = repositories.get(position);
        holder.eventName.setText(event.getName());
    }

    @Override
    public int getItemCount() {
        return repositories.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView eventName, eventTime, eventSpeaker, eventTimeZone;

        public CustomViewHolder(View view) {
            super(view);
            eventName = view.findViewById(R.id.eventName);
            eventTime = view.findViewById(R.id.event_time);
            eventSpeaker = view.findViewById(R.id.eventSpeaker);
            eventTimeZone = view.findViewById(R.id.eventTimeZone);
        }
    }
}