package com.quintonsnewyorktimes.test;

import android.app.FragmentManager;
import android.content.Context;
import android.content.res.AssetManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.quintonsnewyorktimes.activity.MainActivity;
import com.quintonsnewyorktimes.articles_adapter.ArticlesAdapter;
import com.quintonsnewyorktimes.fragments.ArticlesFragment;
import com.quintonsnewyorktimes.models.Response;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.spy;

/**
 * Created by punit.shrirao on 13-03-2018.
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest({Context.class, AssetManager.class, MainActivity.class})
public class ArticlesAdapterTest {
    @Mock
    private ViewGroup viewGroup;
    private ArticlesAdapter articlesAdapter;
    private MainActivity spyMainActivity;
    @Mock
    private LayoutInflater mockLayoutInflater;
    @Mock
    private View mockInflatedView;

    private ArticlesFragment spyArticlesFragment;
    @Mock
    private Context context;
    @Mock
    private FragmentManager fragmentManager;
    @Mock
    Response response;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        spyArticlesFragment = spy(ArticlesFragment.class);
        spyMainActivity = spy(new MainActivity());
    }
}
