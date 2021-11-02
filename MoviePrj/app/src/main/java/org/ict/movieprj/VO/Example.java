package org.ict.movieprj.VO;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Example {

    @SerializedName("boxOfficeResult")
    @Expose
    private BoxOfficeResult boxOfficeResult;

    public BoxOfficeResult getBoxOfficeResult() {
        return boxOfficeResult;
    }

    public void setBoxOfficeResult(BoxOfficeResult boxOfficeResult) {
        this.boxOfficeResult = boxOfficeResult;
    }

}
