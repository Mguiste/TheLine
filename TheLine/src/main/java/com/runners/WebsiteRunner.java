package com.runners;

import com.google.gson.Gson;
import com.Board;
import spark.Spark;

public class WebsiteRunner {
    private static final Gson GSON = new Gson();

    public static void run() {

        Spark.get("/", (request, response) -> GSON.toJson(new Board(5)));
    }
}
