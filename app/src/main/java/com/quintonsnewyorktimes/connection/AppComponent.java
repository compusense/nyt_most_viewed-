package com.quintonsnewyorktimes.connection;



import com.quintonsnewyorktimes.activity.MainActivity;
import com.quintonsnewyorktimes.fragments.ArticlesFragment;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {NetWorkModule.class, AppModule.class})
public interface AppComponent {

//    void inject(UploadImageFragment uploadImageFragment);
    void inject(MainActivity mainActivity);
    void inject(ArticlesFragment articlesFragment);
}
