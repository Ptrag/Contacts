package com.example.pj.contacts.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.pj.contacts.ContactsDetail;
import com.example.pj.contacts.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListCustomAdapter extends ArrayAdapter<ContactsDetail>{

    private LayoutInflater layoutInflater;
    private List<ContactsDetail> contactsList =null;
    private ArrayList<ContactsDetail> arrayList;
    private int layoutResource;
    private Context mContext;
    private String mAppend;

    public ListCustomAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<ContactsDetail> contacts, String append) {
        super(context, resource, contacts);
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutResource = resource;
        this.mContext = context;
        mAppend = append;
        this.contactsList = contacts;
        arrayList = new ArrayList<>();
        this.arrayList.addAll(contactsList);
    }

    private static class ViewHolder{
        TextView name;
        CircleImageView contactImg;
        ProgressBar progressBar;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //holds the vidgets ahead of time so they dont slow down the app
        final ViewHolder holder;

        if(convertView == null){
            convertView = layoutInflater.inflate(layoutResource,parent,false);
            holder = new ViewHolder();
            holder.name = convertView.findViewById(R.id.contact_name);
            holder.contactImg = convertView.findViewById(R.id.profile_image);
            holder.progressBar = convertView.findViewById(R.id.progressBar);

            //storing vidgets so they dont get put at one time
            convertView.setTag(holder);

        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        String name = getItem(position).getName();
        String imgPath = getItem(position).getPhotoImg();
        holder.name.setText(name);

        //creating image loader obj with options for difrent states
        ImageLoader imageLoader = ImageLoader.getInstance();

        imageLoader.displayImage(mAppend + imgPath, holder.contactImg, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                holder.progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                holder.progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                holder.progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                holder.progressBar.setVisibility(View.GONE);
            }
        });

        return convertView;
    }
}
