package com.quintonsnewyorktimes.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.quintonsnewyorktimes.NYT_App;
import com.quintonsnewyorktimes.R;
import com.quintonsnewyorktimes.activity.MainActivity;
import com.quintonsnewyorktimes.app_utilities.nytProgressDialog;
import com.quintonsnewyorktimes.articles_adapter.ArticlesAdapter;
import com.quintonsnewyorktimes.connection.NetworkError;
import com.quintonsnewyorktimes.connection.Service;
import com.quintonsnewyorktimes.models.Response;

import javax.inject.Inject;

/**
 * Created by punit.shrirao on 13-03-2018.
 */

public class ArticlesFragment extends Fragment {

    @Inject
    Service service;
    private nytProgressDialog nytProgressDialog;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         /* injecting dependency */
        NYT_App NYTApp = (NYT_App) getActivity().getApplication();
        (NYTApp).getAppComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.articles_list, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        nytProgressDialog = new nytProgressDialog(getActivity());
        nytProgressDialog.showDialog();

        service.getBaseURL(new Service.ResponseCallback<Response>() {
            @Override
            public void onSuccess(Response response) {
                layoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(layoutManager);

                mAdapter = new ArticlesAdapter(response, (MainActivity) getActivity(), getFragmentManager());
                recyclerView.setAdapter(mAdapter);
                nytProgressDialog.dismissDialog();
            }

            @Override
            public void onError(NetworkError networkError) {
                nytProgressDialog.dismiss();
                Toast.makeText(getActivity(), " Error Occured", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
