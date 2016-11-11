package com.application.fragment;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.android.volley.VolleyError;
import com.twittercrashlytics.R;
import com.application.Application;
import com.application.Utils.DataInitilizer;
import com.application.Utils.IAppConstants;
import com.application.Utils.OnDataReeceivedListener;
import com.application.adapter.CommentsListAdapter;
import com.application.network.model.Comment;

import java.util.List;

public class CommentsListFragment extends DialogFragment implements IAppConstants, OnDataReeceivedListener<Comment> {


    private static final String TAG = CommentsListFragment.class.getSimpleName();

    private RecyclerView recyListComments;
    private ProgressBar progressBar;


    private CommentsListAdapter commentsListAdapter;

    private String commentsUrl;
    private String issueId;

    private DataInitilizer dataInitilizer;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getDataFromBundle();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_comments_list, container, false);

        init(view);

        return view;
    }

    private void init(View view) {

        recyListComments = (RecyclerView) view.findViewById(R.id.recyListComments);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);

        dataInitilizer = new DataInitilizer(getActivity());
        dataInitilizer.setOnDataReeceivedListener(this);

    }

    private void getDataFromBundle() {

        Bundle bundle = getArguments();

        if (null != bundle) {

            commentsUrl = bundle.getString(KEY_COMMENTS_URL);
            issueId = bundle.getString(KEY_ISSUE_ID);
        }
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getDialog().setTitle(getString(R.string.issue) + issueId);

        initRecyclerView();
    }

   private void initRecyclerView() {

        recyListComments.setLayoutManager(new LinearLayoutManager(getActivity()));
        commentsListAdapter = new CommentsListAdapter(getActivity());
        recyListComments.setAdapter(commentsListAdapter);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        progressBar.setVisibility(View.VISIBLE);
        dataInitilizer.getCommentsList(commentsUrl);
    }


    @Override
    public void onDetach() {
        super.onDetach();

        Application.getInstance().cancelPendingRequests(TAG);
    }


    @Override
    public void onDataReceived(List<Comment> listIssues) {


        commentsListAdapter.add(listIssues);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onError(VolleyError volleyError) {

        progressBar.setVisibility(View.GONE);

    }
}
