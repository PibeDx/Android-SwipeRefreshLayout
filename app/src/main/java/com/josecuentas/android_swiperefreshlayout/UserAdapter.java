package com.josecuentas.android_swiperefreshlayout;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jcuentas on 19/12/16.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<User> mUserList;

    public UserAdapter(List<User> userList) {
        mUserList = userList;
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder vh;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_user, parent, false);
        vh = new ViewHolder(view);
        return vh;
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        User user = mUserList.get(position);

        String name = user.getName();

        holder.mTviName.setText(name);
    }

    @Override public int getItemCount() {
        return mUserList.size();
    }




    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView mTviName = (TextView) itemView.findViewById(R.id.tviName);

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
