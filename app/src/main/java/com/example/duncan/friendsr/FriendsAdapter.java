package com.example.duncan.friendsr;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FriendsAdapter extends ArrayAdapter<Friend> {
    private ArrayList<Friend> friends;

    public FriendsAdapter(Context context, int resource, ArrayList<Friend> objects) {
        super(context, resource, objects);
        friends = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

        TextView name = convertView.findViewById(R.id.textFriend);
        ImageView avatar = convertView.findViewById(R.id.imageFriend);

        Friend friend = friends.get(position);

        Drawable picture = getContext().getResources().getDrawable(friend.getDrawableId(), null);
        avatar.setImageDrawable(picture);

        String Name = friend.getName();
        name.setText(Name);

        return convertView;
    }
}