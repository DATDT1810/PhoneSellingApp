package fpt.edu.vn.tingstoreapp.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import fpt.edu.vn.tingstoreapp.R;
import fpt.edu.vn.tingstoreapp.models.Image;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PhotoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PhotoFragment extends Fragment {
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_photo, container, false);
        Bundle bundle = getArguments();
        Image imageItem = (Image) bundle.getSerializable("object_photo");

        ImageView imgPhoto = view.findViewById(R.id.img_pic);
//        imgPhoto.setImageResource(imageItem.getResourceId());
        Glide.with(this).load(imageItem.getImageUrl()).into(imgPhoto);

        return view;
    }
}