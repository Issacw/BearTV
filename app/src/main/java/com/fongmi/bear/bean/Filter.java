package com.fongmi.bear.bean;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class Filter {

    @SerializedName("key")
    private String key;
    @SerializedName("name")
    private String name;
    @SerializedName("value")
    private List<Value> value;

    public static Filter objectFrom(JsonElement element) {
        return new Gson().fromJson(element, Filter.class);
    }

    public static List<Filter> arrayFrom(String str) {
        Type listType = new TypeToken<List<Filter>>() {}.getType();
        List<Filter> items = new Gson().fromJson(str, listType);
        return items == null ? Collections.emptyList() : items;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public List<Value> getValue() {
        return value;
    }

    public static class Value {

        @SerializedName("n")
        private String n;
        @SerializedName("v")
        private String v;

        private boolean select;

        public String getN() {
            return n;
        }

        public String getV() {
            return v;
        }

        public boolean isSelect() {
            return select;
        }

        public void setSelect(boolean select) {
            this.select = select;
        }
    }
}
