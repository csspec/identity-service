package org.csspec.IdentityService.api.helpers;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pair<T, V> {
    @JsonProperty("common")
    private T first;

    @JsonProperty("specific")
    private V second;

    public Pair(T first, V second) {
        this.first = first;
        this.second = second;
    }


    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public V getSecond() {
        return second;
    }

    public void setSecond(V second) {
        this.second = second;
    }
}
