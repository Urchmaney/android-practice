package com.example.bitcointest.RecyclerHolder;

import com.example.bitcointest.R;
import com.google.gson.JsonObject;

public class CoinModel {
    private String name;
    private String id;
    private String symbol;
    private  int rank;
    private  String type;
    private Boolean isActive;
    private Boolean isNew;

    public CoinModel (String name, String id, String symbol, int rank, String type, Boolean isActive, Boolean isNew) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.rank = rank;
        this.type = type;
        this.isActive = isActive;
        this.isNew = isNew;
    }

    public String getName() {
        return name;
    }

    public Boolean getActive() {
        return isActive;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getStatusColor() {
        if(isActive) {
            return R.color.green;
        }
        return  R.color.red;
    }

    public static  CoinModel ExtractCoinModel(JsonObject obj) {
        String name = obj.get("name").getAsString();
        String id = obj.get("id").getAsString();
        String symbol = obj.get("symbol").getAsString();
        int rank = obj.get("rank").getAsInt();
        String type = obj.get("type").getAsString();
        Boolean isActive = obj.get("is_active").getAsBoolean();
        Boolean isNew = obj.get("is_new").getAsBoolean();
        return  new CoinModel(name, id, symbol, rank,type, isActive, isNew);
    }
}
