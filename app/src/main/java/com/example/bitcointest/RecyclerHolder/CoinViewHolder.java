package com.example.bitcointest.RecyclerHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bitcointest.R;

public class CoinViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageViewIcon;
    private CardView cardViewIconStatus;
    private TextView textViewTitle;
    private TextView textViewSubHeader;
    public CoinViewHolder(@NonNull View itemView) {
        super(itemView);
        this.imageViewIcon = itemView.findViewById(R.id.image_view_image);
        this.cardViewIconStatus = itemView.findViewById(R.id.card_view_status);
        this.textViewTitle = itemView.findViewById(R.id.text_view_header);
        this.textViewSubHeader = itemView.findViewById(R.id.text_view_sub_header);

    }

    public TextView getTextViewTitle() {
        return textViewTitle;
    }

    public TextView getTextViewSubHeader() {
        return textViewSubHeader;
    }

    public CardView getCardViewIconStatus() {
        return cardViewIconStatus;
    }
}
