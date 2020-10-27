package com.component.example.activity;

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

public class SimpleChatUIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AU.disableDefaultActionBar(this);

        setActivityContainerLayout();
    }

    public void chatNavigationLayout(ViewGroup viewGroup) {
        HorizontalLinearLayout horizontalLinearLayout = new HorizontalLinearLayout(this,
                viewGroup, GenericLayoutParams.MATCH_PARENT, GenericLayoutParams.WRAP_CONTENT);
        horizontalLinearLayout.setMargins(45, 23, 45, 0);
        horizontalLinearLayout.setPadding(11, 7, 11, 7);
        horizontalLinearLayout.setLayoutGravity(Gravity.CENTER_HORIZONTAL);
        horizontalLinearLayout.setDrawable(AU.curveBackgroundCorner(this, R.color.transparentWhite, 15.333f));
        horizontalLinearLayout.setWeightSum(3);

        TextViewComponent chatsMenu = new TextViewComponent(horizontalLinearLayout, "Chats", 4, TextViewComponent.BOLD_TEXT);
        chatsMenu.setLayoutParams(GenericLayoutParams.ZERO_SPACE, GenericLayoutParams.WRAP_CONTENT);
        chatsMenu.setDrawable(AU.curveBackgroundCorner(this, R.color.darkBlue, 11));
        chatsMenu.setPadding(7, 9, 7, 9);
        chatsMenu.setTextViewColor(R.color.whiteColor);
        chatsMenu.setGravity(Gravity.CENTER);
        chatsMenu.setLayoutWeight(1);

        TextViewComponent statusMenu = new TextViewComponent(horizontalLinearLayout, "Status", 4, TextViewComponent.BOLD_TEXT);
        statusMenu.setLayoutParams(GenericLayoutParams.ZERO_SPACE, GenericLayoutParams.WRAP_CONTENT);
        statusMenu.setPadding(7, 9, 7, 9);
        statusMenu.setTextViewColor(R.color.whiteColor);
        statusMenu.setGravity(Gravity.CENTER);
        statusMenu.setLayoutWeight(1);

        TextViewComponent callsMenu = new TextViewComponent(horizontalLinearLayout, "Calls", 4, TextViewComponent.BOLD_TEXT);
        callsMenu.setLayoutParams(GenericLayoutParams.ZERO_SPACE, GenericLayoutParams.WRAP_CONTENT);
        callsMenu.setPadding(7, 9, 7, 9);
        callsMenu.setTextViewColor(R.color.whiteColor);
        callsMenu.setGravity(Gravity.CENTER);
        callsMenu.setLayoutWeight(1);
    }

    public void setUppermostLayout(ViewGroup viewGroup) {
        HorizontalLinearLayout horizontalLinearLayout = new HorizontalLinearLayout(this,
                viewGroup, GenericLayoutParams.MATCH_PARENT, GenericLayoutParams.WRAP_CONTENT);
        horizontalLinearLayout.setPadding(23, 33, 23, 33);
        horizontalLinearLayout.setGravity(Gravity.CENTER_VERTICAL);

        ImageViewComponent cameraIcon = new ImageViewComponent(horizontalLinearLayout, R.drawable.icon_camera);
        cameraIcon.setImageSize(23);

        TextViewComponent activityHeader = new TextViewComponent(horizontalLinearLayout, "Simple Chat", 6, TextViewComponent.BOLD_TEXT);
        activityHeader.setLayoutParams(GenericLayoutParams.ZERO_SPACE, GenericLayoutParams.WRAP_CONTENT);
        activityHeader.setTextViewColor(R.color.whiteColor);
        activityHeader.setGravity(Gravity.CENTER);
        activityHeader.setLayoutWeight(1);

        ImageViewComponent searchIcon = new ImageViewComponent(horizontalLinearLayout, R.drawable.icon_search);
        searchIcon.setImageSize(23);
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
        navyVerticalLayout.setDrawable(AU.curveBackgroundCorner(this, R.color.darkBlue,
                0, 0, 0, 151));
        navyVerticalLayout.setLayoutWeight(3);

        VerticalLinearLayout whiteVerticalLayout =
                new VerticalLinearLayout(this, whiteNavyVerticalLayout,
                        GenericLayoutParams.MATCH_PARENT, GenericLayoutParams.ZERO_SPACE);
        whiteVerticalLayout.setDrawable(AU.curveBackgroundCorner(this, R.color.whiteColor,
                0, 151, 0, 0));
        whiteVerticalLayout.setLayoutWeight(7);

        setUppermostLayout(navyVerticalLayout);
        chatNavigationLayout(navyVerticalLayout);
    }
}


