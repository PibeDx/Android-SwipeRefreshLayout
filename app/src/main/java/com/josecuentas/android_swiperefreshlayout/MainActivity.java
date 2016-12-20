package com.josecuentas.android_swiperefreshlayout;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/*
* http://sapandiwakar.in/pull-to-refresh-for-android-recyclerview-or-any-other-vertically-scrolling-view/
* */


public class MainActivity extends AppCompatActivity {
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private UserAdapter mUserAdapter;
    private List<User> mUserList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        injectView();
        setupRecycler();
        mookUserList();
        injectAdapters();
        events();
    }

    private void injectView() {
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        mRecyclerView = (RecyclerView) findViewById(R.id.itemsRecyclerView);
    }

    private void setupRecycler() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(llm);
    }

    private void injectAdapters() {
        mUserAdapter = new UserAdapter(mUserList);
        mRecyclerView.setAdapter(mUserAdapter);
    }

    private void events() {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override public void onRefresh() {
                refreshItems();
            }
        });
    }

    private void refreshItems() {
        mUserList.clear();
        mookUserList();
        mUserList.add(new User("Nol"));
        onItemsLoadComplete();
    }

    private void onItemsLoadComplete() {
        mUserAdapter.notifyDataSetChanged();
        mSwipeRefreshLayout.setRefreshing(false);
    }


    private void mookUserList() {
        mUserList.add(new User("Juan"));
        mUserList.add(new User("José"));
        mUserList.add(new User("Pepe"));
        mUserList.add(new User("Angel"));
        mUserList.add(new User("Carlos"));
        mUserList.add(new User("Franz"));
    }
}
