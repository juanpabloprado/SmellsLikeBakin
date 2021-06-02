package com.example.smellslikebakin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class CheckBoxesFragment extends Fragment {

    private static final String KEY_CHECKED_BOXES = "key_checked_boxes";
    private CheckBox[] checkBoxes;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int index = getArguments() != null ? getArguments().getInt(ViewPagerFragment.KEY_RECIPE_INDEX) : 0;

        View view = inflater.inflate(R.layout.fragment_checkboxes, container, false);

        LinearLayout linearLayout = view.findViewById(R.id.checkBoxesLayout);

        String[] contents = getContents(index);

        checkBoxes = new CheckBox[contents.length];
        boolean[] checkedBoxes = new boolean[checkBoxes.length];
        if(savedInstanceState != null && savedInstanceState.getBooleanArray(KEY_CHECKED_BOXES) != null) {
            checkedBoxes = savedInstanceState.getBooleanArray(KEY_CHECKED_BOXES);
        }
        setupCheckBoxes(contents, linearLayout, checkedBoxes);
        return view;
    }

    public abstract String[] getContents(int index);

    private void setupCheckBoxes(String[] contents, ViewGroup container, boolean[] checkedBoxes) {
        int i = 0;
        for (String content : contents) {
            checkBoxes[i] = new CheckBox(getActivity());
            checkBoxes[i].setPadding(8, 16, 8, 16);
            checkBoxes[i].setTextSize(20f);
            checkBoxes[i].setText(content);
            container.addView(checkBoxes[i]);
            if(checkedBoxes[i]) {
                checkBoxes[i].toggle();
            }
            i++;
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        boolean[] stateOfCheckBoxes = new boolean[checkBoxes.length];
        int i = 0;
        for (CheckBox checkBox : checkBoxes) {
            stateOfCheckBoxes[i] = checkBox.isChecked();
            i++;
        }
        outState.putBooleanArray(KEY_CHECKED_BOXES, stateOfCheckBoxes);
        super.onSaveInstanceState(outState);
    }
}
