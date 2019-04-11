package com.codepath.marvelfanapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.parceler.Parcels;

import java.util.List;

public class MovieActivity extends RecyclerView.Adapter<MovieActivity.ViewHolder>{

    Context context;
    List<com.codepath.marvelfanapp.Movie> movies;

    public MovieActivity(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.d("smile","onCreateNewHolder");
        View view = LayoutInflater.from(context).inflate(R.layout.activity_movie, viewGroup, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Log.d("smile","OnBindViewHolder:" + i);
        com.codepath.marvelfanapp.Movie movie = movies.get(i);
        viewHolder.bind(movie);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvOverView;
        ImageView ivPoster;
        RelativeLayout container;
        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvDetails);
            tvOverView = itemView.findViewById(R.id.tvDetails);
            ivPoster = itemView.findViewById(R.id.ivPoster);
            container = itemView.findViewById(R.id.container);
        }

        public void bind(final com.codepath.marvelfanapp.Movie movie) {

            tvTitle.setText(movie.getTitle());
            tvOverView.setText(movie.getOverview());
            Glide.with(context).load(movie.getPosterPatch()).into(ivPoster);
            // Add click listener on the whole row
            container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Navigate to detail activity on tap
                    Intent i = new Intent(context, RateActivity.class);
                    i.putExtra("movie", Parcels.wrap(movie));
                    context.startActivity(i);
                }
            });
        }
    }
}

