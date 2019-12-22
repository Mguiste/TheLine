package com.TheLine.Runners;

import com.google.gson.Gson;
import com.TheLine.Board;
import spark.Spark;

public class WebsiteRunner {
    private static final Gson GSON = new Gson();

    public static void run() {

        Spark.get("/", (request, response) -> GSON.toJson(new Board(5)));
    }
}
