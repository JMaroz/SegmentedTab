package com.marozzi.segmentedtab;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amarozzi on 11/10/2017.
 */

public class SegmentedGroup extends LinearLayout implements View.OnClickListener {

    public interface OnSegmentedGroupListener {

        void onSegmentedTabSelected(SegmentedTab tab, int checkedId);

    }

    private OnSegmentedGroupListener onSegmentedGroupListener;
    private SegmentedTab.Builder tabCustomization;
    private List<SegmentedTab> tabs;
    private SegmentedTab currentTab;

    public SegmentedGroup(Context context) {
        super(context);
        init(context, null, 0, 0);
    }

    public SegmentedGroup(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0, 0);
    }

    public SegmentedGroup(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SegmentedGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        tabs = new ArrayList<>();
        tabCustomization = new SegmentedTab.Builder();

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SegmentedGroup, defStyleAttr, defStyleRes);

        int cornerRadius = a.getDimensionPixelSize(R.styleable.SegmentedGroup_sg_corner_radius, 0);
        int cornerSize = a.getDimensionPixelSize(R.styleable.SegmentedGroup_sg_corner_size, 0);

        int cornerColor = a.getColor(R.styleable.SegmentedGroup_sg_corner_color, Color.TRANSPARENT);
        int cornerColorSelected = a.getColor(R.styleable.SegmentedGroup_sg_corner_color_selected, cornerColor);

        int backgroundColor = a.getColor(R.styleable.SegmentedGroup_sg_background_color, Color.TRANSPARENT);
        int backgroundColorSelected = a.getColor(R.styleable.SegmentedGroup_sg_background_color_selected, backgroundColor);

        int textColor = a.getColor(R.styleable.SegmentedGroup_sg_text_color, Color.TRANSPARENT);
        int textColorSelected = a.getColor(R.styleable.SegmentedGroup_sg_text_color_selected, textColor);

        a.recycle();

        tabCustomization.withCornerRadius(cornerRadius)
                .withCornerSize(cornerSize)
                .withCornerColor(cornerColor)
                .withCornerColorSelected(cornerColorSelected)
                .withBackgroundColor(backgroundColor)
                .withBackgroundColorSelected(backgroundColorSelected)
                .withTextColor(textColor)
                .withTextColorSelected(textColorSelected);

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        for (int i = 0; i < getChildCount(); i++) {
            View view = getChildAt(i);
            if (view instanceof SegmentedTab) {
                SegmentedTab tab = (SegmentedTab) view;
                tab.setCustomizations(tabCustomization, getCorners(i == 0 ? 0 : i == getChildCount() - 1 ? 1 : 2));
                tab.setOnClickListener(this);
                tabs.add(tab);

                if (i == 0) {
                    currentTab = tab;
                    currentTab.setSelected(true);
                }
            } else {
                throw new IllegalArgumentException("The insider view is not a SegmentedTab view");
            }
        }
    }

    private boolean[] getCorners(int type) {
        return type == 0 ? new boolean[]{true, true, false, false} : type == 1 ? new boolean[]{false, false, true, true} : new boolean[]{false, false, false, false};
    }

    public void setOnSegmentedGroupListener(OnSegmentedGroupListener onSegmentedGroupListener) {
        this.onSegmentedGroupListener = onSegmentedGroupListener;
    }

    @Override
    public void onClick(View v) {
        currentTab.setSelected(false);

        currentTab = (SegmentedTab) v;
        currentTab.setSelected(true);

        if (onSegmentedGroupListener != null)
            onSegmentedGroupListener.onSegmentedTabSelected(currentTab, currentTab.getId());
    }
}
