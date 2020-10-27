package com.component.example;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.chibuzo.component.GenericLayoutParams;
import com.chibuzo.component.layoutcomponent.VerticalLinearLayout;
import com.chibuzo.component.utility.AU;
import com.chibuzo.component.viewcomponent.ButtonComponent;
import com.chibuzo.component.viewcomponent.ScrollViewComponent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AU.disableDefaultActionBar(this);

        VerticalLinearLayout activityContainer =
                new VerticalLinearLayout(this, GenericLayoutParams.MATCH_PARENT,
                        GenericLayoutParams.MATCH_PARENT);

        activityContainer.setBackgroundColor(ContextCompat.getColor(this, R.color.whiteColor));

        setContentView(activityContainer);

        ScrollViewComponent scrollViewComponent = new ScrollViewComponent(activityContainer);

        VerticalLinearLayout mainLayout =
                new VerticalLinearLayout(this, scrollViewComponent,
                        GenericLayoutParams.MATCH_PARENT, GenericLayoutParams.MATCH_PARENT);

        mainLayout.setPadding(23, 23, 23, 23);

        ButtonComponent SimpleChatButton = new ButtonComponent(mainLayout, "Simple Chat");
        
    }
}


