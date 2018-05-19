package com.example.saqib.stringdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Saqib on 19-05-2018.
 */

public class FeedbackAdapter extends RecyclerView.Adapter<FeedbackAdapter.FeedbackViewHolder> /*implements RatingChangeListener*/ {

    private List<Feedback> feedbacks;
    private Context context;
    //private RatingChangeListener listener;

    public FeedbackAdapter(Context context, List<Feedback> feedbacks/*, RatingChangeListener listener*/){
        this.feedbacks = feedbacks;
        this.context = context;
        //this.listener = listener;
    }

    @Override
    public FeedbackViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feedback, parent, false);
        return new FeedbackViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FeedbackViewHolder holder, int position) {
        holder.bind(feedbacks.get(position)/*, listener*/);
        //holder.question.setText(questionsList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return feedbacks == null ? 0 : feedbacks.size();
    }

    /*@Override
    public void onRatingChanged(Feedback item) {

    }*/

    public class FeedbackViewHolder extends RecyclerView.ViewHolder{

        private TextView question;
        private RatingBar ratingBar;
        private EditText review;

        public FeedbackViewHolder(View itemView) {
            super(itemView);
            question = (TextView) itemView.findViewById(R.id.question);
            ratingBar = (RatingBar) itemView.findViewById(R.id.rating);
            review = (EditText) itemView.findViewById(R.id.review);
        }

        public void bind(final Feedback item/*, final RatingChangeListener listener*/){
            question.setText(item.getQuestion().getName());
            ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    //listener.onRatingChanged(item);
                    if(rating < 3.0){
                        review.setVisibility(View.VISIBLE);
                    }
                    else {
                        review.setVisibility(View.GONE);
                    }
                }
            });

        }

    }
}
