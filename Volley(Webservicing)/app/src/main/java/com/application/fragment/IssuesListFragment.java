package com.application.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.application.Application;
import com.application.Utils.AppUtil;
import com.application.Utils.DateComparator;
import com.application.Utils.IAppConstants;
import com.application.Utils.OnItemClickListener;
import com.application.adapter.IssuesListAdapter;
import com.application.network.GsonRequest;
import com.application.network.model.Issue;
import com.twittercrashlytics.R;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class IssuesListFragment extends Fragment implements IAppConstants, OnItemClickListener, Response.Listener<Issue[]> {


    private static final String TAG = IssuesListFragment.class.getSimpleName();

    private RecyclerView recyListComments;
    private ProgressBar progressBar;

    private IssuesListAdapter issuesListAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_issues_list, container, false);


        return view;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyListComments = (RecyclerView) view.findViewById(R.id.recyListComments);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);

        initRecyclerView();
    }
    private void initRecyclerView() {

        recyListComments.setLayoutManager(new LinearLayoutManager(getActivity()));
        issuesListAdapter = new IssuesListAdapter(getActivity());
        recyListComments.setAdapter(issuesListAdapter);
        issuesListAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getIssuesList();
    }

    private void getIssuesList() {

        if (AppUtil.isNetworkAvailable(getActivity())) {

            GsonRequest<Issue[]> myReq = new GsonRequest<Issue[]>(BASE_URL,
                    Issue[].class,
                    null,
                    this,
                    createMyReqErrorListener());

            Application.getInstance().addToRequestQueue(myReq, TAG);
        } else {

            progressBar.setVisibility(View.GONE);

            Toast.makeText(getActivity(), getString(R.string.no_network), Toast.LENGTH_SHORT).show();

        }


    }


    private Response.ErrorListener createMyReqErrorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                progressBar.setVisibility(View.GONE);

                Log.e(TAG, "onErrorResponse: " + error.toString());

            }
        };
    }

    @Override
    public void onItemClick(Object object, int position) {

        Issue issue = (Issue) object;

        CommentsListFragment CommentsListFragment = new CommentsListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_COMMENTS_URL, issue.getCommentsUrl());
        bundle.putString(KEY_ISSUE_ID, issue.getId());
        CommentsListFragment.setArguments(bundle);
        CommentsListFragment.show(getActivity().getSupportFragmentManager(), TAG);

    }

    @Override
    public void onDetach() {
        super.onDetach();

        Application.getInstance().cancelPendingRequests(TAG);
    }


    @Override
    public void onResponse(Issue[] response) {

        List<Issue> listIssues = Arrays.asList(response);

        Collections.sort(listIssues,new DateComparator());

        issuesListAdapter.add(listIssues);


        progressBar.setVisibility(View.GONE);
    }
}
