package com.component.example.activity.simplechatactivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.chibuzo.component.GenericLayoutParams;
import com.chibuzo.component.layoutcomponent.FrameLayoutComponent;
import com.chibuzo.component.layoutcomponent.HorizontalLinearLayout;
import com.chibuzo.component.layoutcomponent.VerticalLinearLayout;
import com.chibuzo.component.utility.AU;
import com.chibuzo.component.viewcomponent.ImageViewComponent;
import com.chibuzo.component.viewcomponent.TextViewComponent;
import com.component.example.R;

public class SimpleChatHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AU.disableDefaultActionBar(this);

        setActivityContainerLayout();
    }

    /*** CREATE LabelIconButton CLASS AND ADD IT TO COMPONENT LIBRARY ***/
    public void setLabelIconButton(ViewGroup viewGroup) {

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

        VerticalLinearLayout whiteVerticalLayout =
                new VerticalLinearLayout(this, whiteNavyVerticalLayout,
                        GenericLayoutParams.MATCH_PARENT, GenericLayoutParams.ZERO_SPACE);
        whiteVerticalLayout.setDrawable(AU.curveBackgroundCorner(this, R.color.whiteColor,
                0, 0, 151, 0));
        whiteVerticalLayout.setLayoutWeight(5);

        VerticalLinearLayout navyVerticalLayout =
                new VerticalLinearLayout(this, whiteNavyVerticalLayout,
                        GenericLayoutParams.MATCH_PARENT, GenericLayoutParams.ZERO_SPACE);
        navyVerticalLayout.setDrawable(AU.curveBackgroundCorner(this, R.color.darkBlue,
                151, 0, 0, 0));
        navyVerticalLayout.setGravity(Gravity.CENTER);
        navyVerticalLayout.setLayoutWeight(5);

        ImageViewComponent imageViewComponent = new ImageViewComponent(whiteVerticalLayout, R.drawable.connect);
        imageViewComponent.setLayoutParams(GenericLayoutParams.MATCH_PARENT, GenericLayoutParams.MATCH_PARENT);
        imageViewComponent.setImageObject(R.drawable.connect);

        TextViewComponent firstTextComponent = new TextViewComponent(navyVerticalLayout,
                "Let's connect with each other", 7, TextViewComponent.BOLD_TEXT);
        firstTextComponent.setTextViewColor(R.color.whiteColor);

        TextViewComponent secondTextComponent = new TextViewComponent(navyVerticalLayout,
                "A message is a discrete communication intended by the source consumption", 4);
        secondTextComponent.setTextViewColor(R.color.whiteColor);

    }
}


