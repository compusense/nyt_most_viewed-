package com.quintonsnewyorktimes.fragments;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.quintonsnewyorktimes.R;
import com.quintonsnewyorktimes.app_utilities.Constant;
import com.quintonsnewyorktimes.app_utilities.nytProgressDialog;

/**
 * Created by punit.shrirao on 13-03-2018.
 */

public class ArticleDetailFragment extends Fragment {

    private View mView;
    private WebView mWebview;
    private String mUrl;
    private nytProgressDialog nytProgressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.full_article_detail, null);
        nytProgressDialog = new nytProgressDialog(getActivity());

        mUrl = getArguments().getString(Constant.BUNDLE_ARTICLE_URL);

        initView(mView);
        return mView;
    }

    //initialize view objects.
    private void initView(View view) {
        mWebview = view.findViewById(R.id.webview);
        mWebview.getSettings().setJavaScriptEnabled(true); // enable javascript
        mWebview.setWebViewClient(new WebViewController());
        mWebview.loadUrl(mUrl);
    }

    public class WebViewController extends WebViewClient {

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
            nytProgressDialog.showDialog();
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            nytProgressDialog.dismissDialog();
            super.onPageFinished(view, url);

        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
        }
    }
}
