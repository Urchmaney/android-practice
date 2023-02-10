package com.example.bitcointest.RecyclerHolder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bitcointest.R;

import java.util.List;


public class CoinAdapter extends RecyclerView.Adapter<CoinViewHolder> {

    private final List<CoinModel> coinList;


    public CoinAdapter(List<CoinModel> coinList) {
        this.coinList = coinList;
    }
    @NonNull
    @Override
    public CoinViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_holder, parent, false);
        return new CoinViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CoinViewHolder holder, int position) {
        holder.getTextViewTitle().setText(coinList.get(position).getName());
        holder.getTextViewSubHeader().setText(coinList.get(position).getSymbol());
        holder.getCardViewIconStatus().setCardBackgroundColor(holder.getCardViewIconStatus().getContext().getResources().getColor(coinList.get(position).getStatusColor()));
       // holder.getCardViewIconStatus().setCardBackgroundColor(coinList.get(position).getStatusColor());
    }

    @Override
    public int getItemCount() {
        return coinList.size();
    }
}
