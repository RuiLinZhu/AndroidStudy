package com.example.myapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.entity.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseRecyclerViewAdapter extends RecyclerView.Adapter<CourseRecyclerViewAdapter.ViewHolder> {
    private List<Course> courses;
    private List<Integer> imgIds;

    public CourseRecyclerViewAdapter(List<Course> courses){
        this.courses=courses;
        setImgIds();
    }

    private void setImgIds(){
        imgIds=new ArrayList<>();
        imgIds.add(R.drawable.zed);
        imgIds.add(R.drawable.zed);
        imgIds.add(R.drawable.zed);
        imgIds.add(R.drawable.zed);
        imgIds.add(R.drawable.zed);
        imgIds.add(R.drawable.zed);
        imgIds.add(R.drawable.zed);
        imgIds.add(R.drawable.zed);
        imgIds.add(R.drawable.zed);
        imgIds.add(R.drawable.zed);
        imgIds.add(R.drawable.zed);
        imgIds.add(R.drawable.zed);
        imgIds.add(R.drawable.zed);
        imgIds.add(R.drawable.zed);
        imgIds.add(R.drawable.zed);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.id.item_course,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Course course=courses.get(position);
        holder.ivImg.setImageResource(imgIds.get(position));
        holder.tvTitle.setText(course.getTitle());
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivImg;
        TextView tvTitle;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            ivImg=itemView.findViewById(R.id.iv_img);
            tvTitle=itemView.findViewById(R.id.tv_title);
        }
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder,final int position) {
        Course course = courses.get(position);
        holder.ivImg.setImageResource(imgIds.get(position));
        holder.tvTitle.setText(course.getTitle());
        if (onItemClickListener !=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(holder.itemView,position);
                }
            });
        }
    }

    private void initCourseView(View view){

    }
}
