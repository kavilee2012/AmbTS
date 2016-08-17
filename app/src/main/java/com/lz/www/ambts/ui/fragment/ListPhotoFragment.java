package com.lz.www.ambts.ui.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.lz.www.ambts.R;
import com.lz.www.ambts.util.ImageLoader;

/**
 * Created by Administrator on 2016-08-17.
 */
public class ListPhotoFragment extends Fragment {
    private GridView mGridView;
    private String[] mUrls=null;
    private ImageLoader mImageLoader;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUrls = getResources().getStringArray(R.array.photo);
        mImageLoader = ImageLoader.getInstance(3, ImageLoader.Type.LIFO);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_photo, container,false);
        mGridView = (GridView) view.findViewById(R.id.gvPhoto);
        setUpAdapter();
        return view;
    }

    private void setUpAdapter()
    {
        if (getActivity() == null || mGridView == null)
            return;

        if (mUrls != null)
        {
            mGridView.setAdapter(new ListImgItemAdaper(getActivity(), 0,mUrls));
        } else
        {
            mGridView.setAdapter(null);
        }

    }

    private class ListImgItemAdaper extends ArrayAdapter<String>
    {
        public ListImgItemAdaper(Context context, int resource, String[] datas)
        {
            super(getActivity(), 0, datas);
            Log.e("TAG", "ListImgItemAdaper");
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            if (convertView == null)
            {
                convertView = getActivity().getLayoutInflater().inflate(
                        R.layout.item_photo, parent, false);
            }
            ImageView imageview = (ImageView) convertView
                    .findViewById(R.id.imgPhoto);
            imageview.setImageResource(R.drawable.pictures_no);
            mImageLoader.loadImage(getItem(position), imageview, true);
            return convertView;
        }

    }
}
