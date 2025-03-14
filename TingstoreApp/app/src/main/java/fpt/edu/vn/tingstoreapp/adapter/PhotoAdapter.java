package fpt.edu.vn.tingstoreapp.adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

import fpt.edu.vn.tingstoreapp.fragment.PhotoFragment;
import fpt.edu.vn.tingstoreapp.models.Image;

public class PhotoAdapter extends FragmentStateAdapter {
    private List<Image> photos;

    public PhotoAdapter(@NonNull FragmentActivity fragmentActivity, List<Image> photos) {
        super(fragmentActivity);
        this.photos = photos;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Image imageItem = photos.get(position);

        Bundle bundle = new Bundle();
        bundle.putSerializable("object_photo", imageItem);

        PhotoFragment photoFragment = new PhotoFragment();
        photoFragment.setArguments(bundle);

        return photoFragment;
    }

    @Override
    public int getItemCount() {
        if(photos != null) {
            return photos.size();
        }
        return 0;
    }
}

