package com.example.david0926.dreamtree.Parse;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.david0926.dreamtree.R;


//리사이클러뷰의 터치 이벤트 구현을 위한 클래스
//android code path 참고

public class RecycleClick_Parse {
    private final RecyclerView mRecyclerView;
    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null) {
                RecyclerView.ViewHolder holder = mRecyclerView.getChildViewHolder(v);
                mOnItemClickListener.onItemClicked(mRecyclerView, holder.getAdapterPosition(), v);
            }
        }
    };
    private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            if (mOnItemLongClickListener != null) {
                RecyclerView.ViewHolder holder = mRecyclerView.getChildViewHolder(v);
                return mOnItemLongClickListener.onItemLongClicked(mRecyclerView, holder.getAdapterPosition(), v);
            }
            return false;
        }
    };
    private RecyclerView.OnChildAttachStateChangeListener mAttachListener
            = new RecyclerView.OnChildAttachStateChangeListener() {
        @Override
        public void onChildViewAttachedToWindow(View view) {
            if (mOnItemClickListener != null) {
                view.setOnClickListener(mOnClickListener);
            }
            if (mOnItemLongClickListener != null) {
                view.setOnLongClickListener(mOnLongClickListener);
            }
        }

        @Override
        public void onChildViewDetachedFromWindow(View view) {

        }
    };

    private RecycleClick_Parse(RecyclerView recyclerView) {
        mRecyclerView = recyclerView;
        mRecyclerView.setTag(R.id.parse_recycler, this);
        mRecyclerView.addOnChildAttachStateChangeListener(mAttachListener);
    }

    public static RecycleClick_Parse addTo(RecyclerView view) {
        RecycleClick_Parse support = (RecycleClick_Parse) view.getTag(R.id.parse_recycler);
        if (support == null) {
            support = new RecycleClick_Parse(view);
        }
        return support;
    }

    public static RecycleClick_Parse removeFrom(RecyclerView view) {
        RecycleClick_Parse support = (RecycleClick_Parse) view.getTag(R.id.parse_recycler);
        if (support != null) {
            support.detach(view);
        }
        return support;
    }

    public RecycleClick_Parse setOnItemClickListener(OnItemClickListener listener) {
        mOnItemClickListener = listener;
        return this;
    }

    public RecycleClick_Parse setOnItemLongClickListener(OnItemLongClickListener listener) {
        mOnItemLongClickListener = listener;
        return this;
    }

    private void detach(RecyclerView view) {
        view.removeOnChildAttachStateChangeListener(mAttachListener);
        view.setTag(R.id.parse_recycler, null);
    }

    public interface OnItemClickListener {

        void onItemClicked(RecyclerView recyclerView, int position, View v);
    }

    public interface OnItemLongClickListener {

        boolean onItemLongClicked(RecyclerView recyclerView, int position, View v);
    }



}
