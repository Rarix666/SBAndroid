package com.example.sbandroid;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.action.ViewActions.*;
import static org.hamcrest.Matchers.*;

import android.os.SystemClock;
import android.view.View;
import android.widget.DatePicker;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.contrib.PickerActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.contrib.RecyclerViewActions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

@RunWith(AndroidJUnit4.class)
public class SBUITest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    public static ViewAction clickChildViewWithId(final int id) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isAssignableFrom(View.class);
            }

            @Override
            public String getDescription() {
                return "Клик на дочерний элемент";
            }

            @Override
            public void perform(UiController uiController, View view) {
                View v = view.findViewById(id);
                if (v != null) {
                    v.performClick();
                }
            }
        };
    }

    @Test
    public void tc_001_testSearchInc(){
        onView(withId(R.id.Delo_EditText))
                .perform(typeText("11"));
        onView(withId(R.id.button2)).perform(click());
    }
    @Test
    public void tc_002_testSearchCivil(){
        onView(withId(R.id.Pasport_EditText))
                .perform(typeText("634567"));
        onView(withId(R.id.Poisk_Button)).perform(click());
    }
    @Test
    public void tc_003_testUpdateIncidentTrue(){
        SystemClock.sleep(1000);
        onView(withId(R.id.Recycle_Incedent))
                .perform(scrollToPosition(0));
        onView(withId(R.id.Recycle_Incedent))
                .perform(actionOnItemAtPosition(0, clickChildViewWithId(R.id.buttonEdit)));
        onView(withId(R.id.numberEdit)).perform(replaceText("Петровск"));
        SystemClock.sleep(1000);
        onView(withId(android.R.id.button1)).perform(click());
    }
    @Test
    public void tc_004_testUpdateIncidentFalse(){
        SystemClock.sleep(1000);
        onView(withId(R.id.Recycle_Incedent))
                .perform(scrollToPosition(0));
        onView(withId(R.id.Recycle_Incedent))
                .perform(actionOnItemAtPosition(0, clickChildViewWithId(R.id.buttonEdit)));
        onView(withId(R.id.numberEdit)).perform(replaceText(""));
        SystemClock.sleep(1000);
        onView(withId(android.R.id.button1)).perform(click());
    }
    @Test
    public void tc_005_testUpdateDescriptionTrue(){
        SystemClock.sleep(1000);
        onView(withId(R.id.Recycle_Incedent))
                .perform(scrollToPosition(0));
        onView(withId(R.id.Recycle_Incedent))
                .perform(actionOnItemAtPosition(0, clickChildViewWithId(R.id.buttonEdit)));
        onView(withId(R.id.descriptionEdit)).perform(replaceText("г. Самара"));
        SystemClock.sleep(1000);
        onView(withId(android.R.id.button1)).perform(click());
    }
    @Test
    public void tc_006_testUpdateDescriptionFalse(){
        SystemClock.sleep(1000);
        onView(withId(R.id.Recycle_Incedent))
                .perform(scrollToPosition(0));
        onView(withId(R.id.Recycle_Incedent))
                .perform(actionOnItemAtPosition(0, clickChildViewWithId(R.id.buttonEdit)));
        onView(withId(R.id.descriptionEdit)).perform(replaceText(""));
        SystemClock.sleep(1000);
        onView(withId(android.R.id.button1)).perform(click());
    }
    @Test
    public void tc_007_testUpdateSuspectsTrue(){
        SystemClock.sleep(1000);
        onView(withId(R.id.Recycle_Incedent))
                .perform(scrollToPosition(0));
        onView(withId(R.id.Recycle_Incedent))
                .perform(actionOnItemAtPosition(0, clickChildViewWithId(R.id.buttonEdit)));
        onView(withId(R.id.suspectsEdit)).perform(replaceText("Петров"));
        SystemClock.sleep(1000);
        onView(withId(android.R.id.button1)).perform(click());
    }
    @Test
    public void tc_008_testUpdateSuspectsFalse(){
        SystemClock.sleep(1000);
        onView(withId(R.id.Recycle_Incedent))
                .perform(scrollToPosition(0));
        onView(withId(R.id.Recycle_Incedent))
                .perform(actionOnItemAtPosition(0, clickChildViewWithId(R.id.buttonEdit)));
        onView(withId(R.id.suspectsEdit)).perform(replaceText(""));
        SystemClock.sleep(1000);
        onView(withId(android.R.id.button1)).perform(click());
    }
    @Test
    public void tc_009_testAutorFalse(){
        onView(withId(R.id.editTextText))
                .perform(typeText("Hacker"));
        onView(withId(R.id.editTextTextPassword))
                .perform(typeText("54321"));

        onView(withId(R.id.button)).perform(click());
    }
    @Test
    public void tc_010_testAutorTrue() {
        onView(withId(R.id.editTextText))
                .perform(typeText("User"));
        onView(withId(R.id.editTextTextPassword))
                .perform(typeText("1234"));
        onView(withId(R.id.button)).perform(click());
    }
    @Test
    public void tc_011_testIncidentAdd(){
        onView(withId(R.id.buttonCreateInc)).perform(click());

        SystemClock.sleep(1000);

        onView(withId(R.id.numberEditCreate)).perform(click())
                .perform(typeText("г. Ульяновск, д. 9"));

        onView(withId(R.id.descriptionEditCreate)).perform(click())
                .perform(typeText("Ограбление"));

        onView(withId(R.id.suspectsEditCreate)).perform(click())
                .perform(typeText("Петров"));

        onView(withId(android.R.id.button1)).perform(click());
    }
    @Test
    public void tc_012_testIncidentAddNull(){
        SystemClock.sleep(1000);
        onView(withId(R.id.buttonCreateInc)).perform(click());
        onView(withId(android.R.id.button1)).perform(click());
    }
    @Test
    public void tc_013_testNoWifi(){
        onView(withId(R.id.textView))
                .check(matches(withText("Отсутствует интернет")));
    }
    @Test
    public void tc_014_testAndroidDarkMod(){
        onView(withId(R.id.textView))
                .check(matches(withText("Авторизация")));
    }
    @Test
    public void tc_015_testDeleteInc(){
        SystemClock.sleep(1000);
        onView(withId(R.id.Recycle_Incedent))
                .perform(scrollToPosition(0));
        onView(withId(R.id.Recycle_Incedent))
                .perform(actionOnItemAtPosition(0, clickChildViewWithId(R.id.buttonEdit)));

        SystemClock.sleep(1000);
        onView(withId(android.R.id.button3)).perform(click());
    }

}
