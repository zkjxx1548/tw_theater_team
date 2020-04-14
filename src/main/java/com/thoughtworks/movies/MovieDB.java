package com.thoughtworks.movies;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Objects;

public class MovieDB {
    private final String FILE = Objects.requireNonNull(MovieDB.class.getClassLoader().getResource("movies.csv")).getFile();

    public void loadData() {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE))){
            bufferedReader.readLine();
            while (bufferedReader.ready()){
                String[] split = bufferedReader.readLine().trim().split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
