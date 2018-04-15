package com.example.pj.contacts.Utils;


import android.content.Context;

import com.example.pj.contacts.R;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

public class UniversalImageLoader {

    private static final int defaultImage = R.drawable.ic_android;

    private Context context;

    public UniversalImageLoader(Context context) {
        this.context = context;
    }


    //image loader configuration
    public ImageLoaderConfiguration getConfiguration(){
        DisplayImageOptions displayImageOptions = new DisplayImageOptions.Builder()
                .showImageOnLoading(defaultImage)
                .showImageForEmptyUri(defaultImage)
                .showImageOnFail(defaultImage)
                .cacheOnDisk(true).cacheInMemory(true)
                .cacheOnDisk(true).resetViewBeforeLoading(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(400))
                .build();

        return new ImageLoaderConfiguration.Builder(context)
                .defaultDisplayImageOptions(displayImageOptions)
                .memoryCache(new WeakMemoryCache())
                .diskCacheSize(100 * 1024  * 1024)
                .build();
    }
}
