package com.component.example.activity;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;

import com.chibuzo.component.GenericLayoutParams;
import com.chibuzo.component.layoutcomponent.FrameLayoutComponent;
import com.chibuzo.component.layoutcomponent.HorizontalLinearLayout;
import com.chibuzo.component.layoutcomponent.VerticalLinearLayout;
import com.chibuzo.component.utility.AU;
import com.chibuzo.component.viewcomponent.ImageViewComponent;
import com.component.example.R;

public class SimpleChatUI extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AU.disableDefaultActionBar(this);

        setActivityContainerLayout();
    }

    public void setUppermostLayout(ViewGroup viewGroup) {
        HorizontalLinearLayout horizontalLinearLayout = new HorizontalLinearLayout(this,
                viewGroup, GenericLayoutParams.MATCH_PARENT, GenericLayoutParams.WRAP_CONTENT);

        // image icon
        // header
        // search icon
        ImageViewComponent cameraIcon = new ImageViewComponent(horizontalLinearLayout, R.drawable.icon_camera);
    }

    public void setActivityContainerLayout() {
        FrameLayoutComponent activityContainer =
                new FrameLayoutComponent(this, GenericLayoutParams.MATCH_PARENT,
                        GenericLayoutParams.MATCH_PARENT);

        activityContainer.setBackgroundColor(ContextCompat.getColor(this, R.color.whiteColor));

        setContentView(activityContainer);

        HorizontalLinearLayout whiteNavyLayout = new HorizontalLinearLayout(this,
                activityContainer, GenericLayoutParams.MATCH_PARENT, GenericLayoutParams.MATCH_PARENT);
        whiteNavyLayout.setWeightSum(2);

        VerticalLinearLayout whiteLayout = new VerticalLinearLayout(this, whiteNavyLayout,
                GenericLayoutParams.ZERO_SPACE, GenericLayoutParams.MATCH_PARENT);
        whiteLayout.setComponentColor(R.color.whiteColor);
        whiteLayout.setLayoutWeight(1);

        VerticalLinearLayout navyLayout = new VerticalLinearLayout(this, whiteNavyLayout,
                GenericLayoutParams.ZERO_SPACE, GenericLayoutParams.MATCH_PARENT);
        navyLayout.setComponentColor(R.color.darkBlue);
        navyLayout.setLayoutWeight(1);

        VerticalLinearLayout whiteNavyVerticalLayout =
                new VerticalLinearLayout(this, activityContainer,
                        GenericLayoutParams.MATCH_PARENT, GenericLayoutParams.MATCH_PARENT);
        whiteNavyVerticalLayout.setWeightSum(10);

        VerticalLinearLayout navyVerticalLayout =
                new VerticalLinearLayout(this, whiteNavyVerticalLayout,
                        GenericLayoutParams.MATCH_PARENT, GenericLayoutParams.ZERO_SPACE);
        navyVerticalLayout.setDrawable(curveBackgroundCorner(R.color.darkBlue,
                0, 0, 0, 131));
        navyVerticalLayout.setLayoutWeight(3);

        VerticalLinearLayout whiteVerticalLayout =
                new VerticalLinearLayout(this, whiteNavyVerticalLayout,
                        GenericLayoutParams.MATCH_PARENT, GenericLayoutParams.ZERO_SPACE);
        whiteVerticalLayout.setDrawable(curveBackgroundCorner(R.color.whiteColor,
                0, 131, 0, 0));
        whiteVerticalLayout.setLayoutWeight(7);
    }

    public GradientDrawable curveBackgroundCorner(int color, float leftTop,
                                                  float rightTop, float rightBottom, float leftBottom) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ContextCompat.getColor(this, color));
        gradientDrawable.setCornerRadii(new float[]{leftTop, leftTop,
                rightTop, rightTop, rightBottom, rightBottom, leftBottom, leftBottom});
        return gradientDrawable;
    }
}


