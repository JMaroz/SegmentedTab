package com.marozzi.segmentedtab;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.StateSet;

/**
 * Created by amarozzi on 11/10/2017.
 */

public class SegmentedTab extends android.support.v7.widget.AppCompatButton {

    private int cornerRadius;
    private int cornerSize = 20;

    private int cornerColor;
    private int cornerColorSelected;
    private int backgroundColor;
    private int backgroundColorSelected;

    private int textColor;
    private int textColorSelected;

    private boolean[] corners;

    public SegmentedTab(Context context) {
        super(context);
    }

    public SegmentedTab(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SegmentedTab(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setCornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
    }

    public void setCornerSize(int cornerSize) {
        this.cornerSize = cornerSize;
    }

    public void setCornerColor(int cornerColor) {
        this.cornerColor = cornerColor;
    }

    public void setCornerColorSelected(int cornerColorSelected) {
        this.cornerColorSelected = cornerColorSelected;
    }

    @Override
    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void setBackgroundColorSelected(int backgroundColorSelected) {
        this.backgroundColorSelected = backgroundColorSelected;
    }

    @Override
    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public void setTextColorSelected(int textColorSelected) {
        this.textColorSelected = textColorSelected;
    }

    public void setCustomizations(Builder builder, boolean[] corners) {
        if (builder.cornerRadius != null)
            setCornerRadius(builder.cornerRadius);

        if (builder.cornerSize != null)
            setCornerSize(builder.cornerSize);

        if (builder.cornerColor != null)
            setCornerColor(builder.cornerColor);

        if (builder.cornerColorSelected != null)
            setCornerColorSelected(builder.cornerColorSelected);

        if (builder.backgroundColor != null)
            setBackgroundColor(builder.backgroundColor);

        if (builder.backgroundColorSelected != null)
            setBackgroundColorSelected(builder.backgroundColorSelected);

        if (builder.textColor != null)
            setTextColor(builder.textColor);

        if (builder.textColorSelected != null)
            setTextColorSelected(builder.textColorSelected);

        this.corners = corners;

        update();
    }

    public void update() {
        setBackground(getBackgroundStates());
        setTextColor(getColorStates());
    }

    private StateListDrawable getBackgroundStates() {
        StateListDrawable out = new StateListDrawable();
        out.addState(new int[]{android.R.attr.state_pressed}, createDrawable(backgroundColorSelected, cornerColorSelected, cornerSize, cornerRadius));
        out.addState(new int[]{android.R.attr.state_selected}, createDrawable(backgroundColorSelected, cornerColorSelected, cornerSize, cornerRadius));
        out.addState(StateSet.WILD_CARD, createDrawable(backgroundColor, cornerColor, cornerSize, cornerRadius));
        return out;
    }

    private GradientDrawable createDrawable(int color, int cornerColor, int cornerSize, int cornerRadius) {
        GradientDrawable out = new GradientDrawable();
        out.setColor(color);
        out.setStroke(cornerSize, cornerColor);

        //float[] radi={upLeft,upLeft, upRight, upRight,downRight,downRight,downLeft,downLeft};
        out.setCornerRadii(new float[]{getCornerRadius(0, cornerRadius), getCornerRadius(0, cornerRadius),
                getCornerRadius(2, cornerRadius), getCornerRadius(2, cornerRadius),
                getCornerRadius(3, cornerRadius), getCornerRadius(3, cornerRadius),
                getCornerRadius(1, cornerRadius), getCornerRadius(1, cornerRadius)});
        return out;
    }

    private int getCornerRadius(int pos, int cornerRadius) {
        return corners != null && corners[pos] ? cornerRadius : 0;
    }

    private ColorStateList getColorStates() {
        return new ColorStateList(
                new int[][]{
                        new int[]{android.R.attr.state_pressed},
                        new int[]{android.R.attr.state_selected},
                        new int[]{}
                },
                new int[]{
                        textColorSelected,
                        textColorSelected,
                        textColor
                }
        );
    }

    public static final class Builder {
        private Integer cornerRadius;
        private Integer cornerSize;
        private Integer cornerColor;
        private Integer cornerColorSelected;
        private Integer backgroundColor;
        private Integer backgroundColorSelected;
        private Integer textColor;
        private Integer textColorSelected;

        public Builder() {
        }

        public Builder withCornerRadius(int radius) {
            cornerRadius = radius;
            return this;
        }

        public Builder withCornerSize(int size) {
            cornerSize = size;
            return this;
        }

        public Builder withCornerColor(int color) {
            cornerColor = color;
            return this;
        }

        public Builder withCornerColorSelected(int selectedColor) {
            cornerColorSelected = selectedColor;
            return this;
        }

        public Builder withBackgroundColor(int color) {
            backgroundColor = color;
            return this;
        }

        public Builder withBackgroundColorSelected(int selectedColor) {
            backgroundColorSelected = selectedColor;
            return this;
        }

        public Builder withTextColor(int color) {
            textColor = color;
            return this;
        }

        public Builder withTextColorSelected(int selectedColor) {
            textColorSelected = selectedColor;
            return this;
        }
    }
}