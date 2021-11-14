package com.example.interfaces;

import java.util.ArrayList;

public interface RepoView<T> {
    void showRepoItems(ArrayList<T> items);
}
